package gordanramsey.loves.babyeating.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.init.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.Path;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;

import java.util.Map;

import gordanramsey.loves.babyeating.ElementsBabyeatingMod;

@ElementsBabyeatingMod.ModElement.Tag
public class ProcedureFitInSmallerGapDEEGAN extends ElementsBabyeatingMod.ModElement {
	public ProcedureFitInSmallerGapDEEGAN(ElementsBabyeatingMod instance) {
		super(instance, 81);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {

		// =========================
		// BASIC VALIDATION
		// =========================
		if (dependencies.get("entity") == null || dependencies.get("world") == null) return;

		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");

		if (!(entity instanceof EntityLivingBase)) return;
		EntityLivingBase mob = (EntityLivingBase) entity;

		// =========================
		// GAME RULE CHECK
		// =========================
		if (!world.getGameRules().getBoolean("mobGriefing")) return;

		// =========================
		// TARGET ACQUISITION
		// =========================
		EntityLivingBase target = null;

		if (mob instanceof EntityCreature) {
			target = ((EntityCreature) mob).getAttackTarget();
		}

		if (target == null) {
			target = mob.getRevengeTarget();
		}

		if (!(target instanceof EntityPlayer)) return;

		// require visibility
		if (!mob.canEntityBeSeen(target)) return;

		// =========================
		// NBT STATE
		// =========================
		int stuckTicks = mob.getEntityData().getInteger("sb_stuckTicks");
		int buildCooldown = mob.getEntityData().getInteger("sb_buildCooldown");
		int bridgeCooldown = mob.getEntityData().getInteger("sb_bridgeCooldown");
		int explosionCooldown = mob.getEntityData().getInteger("sb_explosionCooldown");

		if (buildCooldown > 0) mob.getEntityData().setInteger("sb_buildCooldown", buildCooldown - 1);
		if (bridgeCooldown > 0) mob.getEntityData().setInteger("sb_bridgeCooldown", bridgeCooldown - 1);
		if (explosionCooldown > 0) mob.getEntityData().setInteger("sb_explosionCooldown", explosionCooldown - 1);

		// =========================
		// PATH CHECK
		// =========================
		boolean noPath = true;

		if (mob instanceof EntityCreature) {
			Path path = ((EntityCreature) mob).getNavigator().getPath();
			noPath = (path == null || path.isFinished());
		}

		double yDiff = target.posY - mob.posY;
		double dist = mob.getDistance(target);

		// =========================
		// ANTI-FALL SNAP
		// =========================
		BlockPos under = new BlockPos(mob.posX, mob.posY - 1, mob.posZ);
		if (!world.isAirBlock(under)) {
			mob.setPositionAndUpdate(mob.posX, under.getY() + 1, mob.posZ);
		}

		// =========================
		// CHECK MINEABLE FOR TRAP
		// =========================
		boolean hasMineable = false;

		Vec3d look = mob.getLookVec();
		BlockPos probe = new BlockPos(mob.posX + look.x * 2, mob.posY, mob.posZ + look.z * 2);

		for (int x = -1; x <= 1; x++) {
			for (int y = -1; y <= 2; y++) {
				for (int z = -1; z <= 1; z++) {

					BlockPos p = probe.add(x, y, z);

					if (isBreakable(world, p)) {
						hasMineable = true;
					}
				}
			}
		}

		if (noPath && !hasMineable) stuckTicks++;
		else stuckTicks = 0;

		mob.getEntityData().setInteger("sb_stuckTicks", stuckTicks);

		// =========================
		// TELEPORT (ONLY TRUE TRAP)
		// =========================
		if (stuckTicks >= 300) {

			for (int i = 0; i < 25; i++) {

				double tx = target.posX + (Math.random() * 32 - 16);
				double tz = target.posZ + (Math.random() * 32 - 16);

				BlockPos tp = world.getHeight(new BlockPos(tx, 0, tz));

				if (world.isAirBlock(tp.up()) && world.isAirBlock(tp.up(2))) {

					mob.setPositionAndUpdate(tp.getX() + 0.5, tp.getY(), tp.getZ() + 0.5);

					world.playSound(null, tp,
						SoundEvents.ENTITY_ENDERMEN_TELEPORT,
						SoundCategory.HOSTILE, 1F, 1F);

					mob.getEntityData().setInteger("sb_stuckTicks", 0);
					return;
				}
			}
		}

		// =========================
		// BRIDGE BUILD (SAFE)
		// =========================
		if (noPath && yDiff > 3 && dist > 6 && bridgeCooldown <= 0 && buildCooldown <= 0) {

			Vec3d dir = target.getPositionVector().subtract(mob.getPositionVector()).normalize();

			for (int i = 1; i <= 10; i++) {

				BlockPos base = new BlockPos(
						mob.posX + dir.x * i,
						mob.posY - 1,
						mob.posZ + dir.z * i
				);

				for (int w = -1; w <= 1; w++) {

					BlockPos p = (Math.abs(dir.x) > Math.abs(dir.z))
							? base.add(0, 0, w)
							: base.add(w, 0, 0);

					if (world.isAirBlock(p)) {
						world.setBlockState(p, getBuildBlock());
					}
				}
			}

			mob.getEntityData().setInteger("sb_bridgeCooldown", 100);
			mob.getEntityData().setInteger("sb_buildCooldown", 40);
		}

		// =========================
		// MINING (3x3 TUNNEL)
		// =========================
		if (noPath && Math.abs(yDiff) <= 5) {

			Vec3d eyes = mob.getPositionEyes(1.0F);

			Vec3d end = new Vec3d(
					eyes.x + look.x * 2.5D,
					eyes.y + look.y * 2.5D,
					eyes.z + look.z * 2.5D
			);

			RayTraceResult ray = world.rayTraceBlocks(eyes, end, false, false, true);

			if (ray != null && ray.getBlockPos() != null) {

				BlockPos hit = ray.getBlockPos();

				for (int x = -1; x <= 1; x++) {
					for (int y = 0; y <= 2; y++) {
						for (int z = -1; z <= 1; z++) {

							BlockPos p = hit.add(x, y, z);

							if (!world.isAirBlock(p) && isBreakable(world, p)) {
								world.destroyBlock(p, true);
							}
						}
					}
				}
			}
		}

		// =========================
		// EXPLOSION CONTROL
		// =========================
		if (noPath && Math.abs(yDiff) > 5 && explosionCooldown <= 0) {

			if (Math.abs(yDiff) > 3) {

				mob.hurtResistantTime = 20;

				world.createExplosion(mob,
						mob.posX,
						mob.posY,
						mob.posZ,
						2.0F,
						true);

				mob.getEntityData().setInteger("sb_explosionCooldown", 40);
			}
		}
	}

	// =========================
	// BLOCK HELPERS
	// =========================

	private static IBlockState getBuildBlock() {

		double r = Math.random();

		if (r < 0.33) return Blocks.DIRT.getDefaultState();
		if (r < 0.66) return Blocks.COBBLESTONE.getDefaultState();
		return Blocks.PLANKS.getDefaultState();
	}

	private static boolean isBreakable(World world, BlockPos pos) {

		Block b = world.getBlockState(pos).getBlock();

		if (b == Blocks.BEDROCK || b == Blocks.BARRIER || b == Blocks.COMMAND_BLOCK) {
			return false;
		}

		return b != Blocks.AIR;
	}
}