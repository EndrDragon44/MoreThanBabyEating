package gordanramsey.loves.babyeating.procedure;

import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.WorldServer;
import net.minecraft.world.World;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;
import net.minecraft.init.Blocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import gordanramsey.loves.babyeating.entity.EntityAfricaVillager;


import java.util.*;

import gordanramsey.loves.babyeating.ElementsBabyeatingMod;

@ElementsBabyeatingMod.ModElement.Tag
public class ProcedureSpawnDungeon extends ElementsBabyeatingMod.ModElement {

	public ProcedureSpawnDungeon(ElementsBabyeatingMod instance) {
		super(instance, 65);
	}

	private static class StructureEntry {
		public final String name;

		public StructureEntry(String name) {
			this.name = name;
		}
	}

	private static final StructureEntry[] STRUCTURES = new StructureEntry[] {
		new StructureEntry("brknhouse"),
		new StructureEntry("graveyard"),
		new StructureEntry("house1"),
		new StructureEntry("toilet"),
		new StructureEntry("hausethingymabobber"),
		new StructureEntry("orphanage"),
		new StructureEntry("v_tent"),
		new StructureEntry("brknhouse_oak")
	};

	public static void executeProcedure(Map<String, Object> dependencies) {

		if (dependencies.get("x") == null || dependencies.get("y") == null ||
			dependencies.get("z") == null || dependencies.get("world") == null) {
			System.err.println("Missing dependencies!");
			return;
		}

		int originX = (int) dependencies.get("x");
		int originY = (int) dependencies.get("y");
		int originZ = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");

		final int GRID_SIZE_X = 19;
		final int GRID_SIZE_Z = 19;
		final int STRUCTURES_TO_SPAWN = 34;

		final double SPAWN_CHANCE = 0.78;
		final double MOB_CHANCE = 0.45;

		Set<String> usedCells = new HashSet<>();
		Random rand = new Random();

		for (int i = 0; i < STRUCTURES_TO_SPAWN; i++) {

			int gx = rand.nextInt(7) - 3;
			int gz = rand.nextInt(7) - 3;

			String key = gx + "," + gz;

			if (usedCells.contains(key)) {
				i--;
				continue;
			}
			usedCells.add(key);

			double xOff = originX + (gx * GRID_SIZE_X);
			double zOff = originZ + (gz * GRID_SIZE_Z);

			if (rand.nextDouble() >= SPAWN_CHANCE) {
				continue;
			}

			BlockPos check = new BlockPos((int) xOff, originY, (int) zOff);
			if (world.getBlockState(check).getBlock() == Blocks.DIRT.getStateFromMeta(1).getBlock()) {
				continue;
			}

			// =========================
			// STRUCTURE SELECTION
			// =========================
			String structureName = STRUCTURES[rand.nextInt(STRUCTURES.length)].name;

			// =========================
			// HEIGHT FIX
			// =========================
			BlockPos surface = world.getHeight(new BlockPos((int) xOff, 0, (int) zOff));
			double yOff = surface.getY();

			// =========================
			// ROTATION SYSTEM (NEW)
			// =========================
			Rotation rotation;

			switch (rand.nextInt(4)) {
				case 0:
					rotation = Rotation.NONE;
					break;
				case 1:
					rotation = Rotation.CLOCKWISE_90;
					break;
				case 2:
					rotation = Rotation.CLOCKWISE_180;
					break;
				default:
					rotation = Rotation.COUNTERCLOCKWISE_90;
					break;
			}

			// =========================
			// SPAWN
			// =========================
			if (!world.isRemote) {

				Template template = ((WorldServer) world)
						.getStructureTemplateManager()
						.getTemplate(world.getMinecraftServer(),
								new ResourceLocation("babyeating", structureName));

				if (template != null) {

					BlockPos spawnTo = new BlockPos((int) (xOff - 5), (int) yOff, (int) (zOff - 5));

					IBlockState state = world.getBlockState(spawnTo);
					world.notifyBlockUpdate(spawnTo, state, state, 3);

					template.addBlocksToWorldChunk(
							world,
							spawnTo,
							new PlacementSettings()
									.setRotation(rotation)
									.setMirror(Mirror.NONE)
									.setChunk((ChunkPos) null)
									.setReplacedBlock(null)
									.setIgnoreStructureBlock(false)
									.setIgnoreEntities(false)
					);

					// optional mob spawn (kept simple & safe)
					/* if (rand.nextDouble() < MOB_CHANCE) {
						int mobs = 1 + rand.nextInt(2);

						for (int m = 0; m < mobs; m++) {
							try {
								Entity entityToSpawn = new EntityAfricaVillager.EntityCustom(world);
								if (entityToSpawn != null) {
									double mx = xOff + (rand.nextDouble() * 4 - 2);
									double mz = zOff + (rand.nextDouble() * 4 - 2);
									entityToSpawn.setLocationAndAngles(mx, yOff + 1, mz, world.rand.nextFloat() * 360F, 0.0F);
									world.spawnEntity(entityToSpawn);
								}


							} catch (Exception e) {
								System.err.println("Failed to spawn african entity");
							}
						}
					} */
				}
			}
		}
	}
}