package gordanramsey.loves.babyeating.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSender;

import java.util.Map;

import gordanramsey.loves.babyeating.entity.EntityPriestAfrican;
import gordanramsey.loves.babyeating.entity.EntityNitwitAfrican;
import gordanramsey.loves.babyeating.entity.EntityLibrarianAfrican;
import gordanramsey.loves.babyeating.entity.EntityFarmerAfrican;
import gordanramsey.loves.babyeating.entity.EntityButcherAfrican;
import gordanramsey.loves.babyeating.entity.EntityBlacksmithAfrican;
import gordanramsey.loves.babyeating.ElementsBabyeatingMod;

@ElementsBabyeatingMod.ModElement.Tag
public class ProcedureAfricaVillagerOnInitialEntitySpawn extends ElementsBabyeatingMod.ModElement {
	public ProcedureAfricaVillagerOnInitialEntitySpawn(ElementsBabyeatingMod instance) {
		super(instance, 44);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure AfricaVillagerOnInitialEntitySpawn!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure AfricaVillagerOnInitialEntitySpawn!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		double random = 0;
		random = (double) Math.random();
		if (((random) < (1.0 / 6.0))) {
			if (!world.isRemote) {
				Entity entityToSpawn = new EntityNitwitAfrican.EntityCustom(world);
				if (entityToSpawn != null) {
					entityToSpawn.setLocationAndAngles((entity.posX), (entity.posY), (entity.posZ), world.rand.nextFloat() * 360F, 0.0F);
					world.spawnEntity(entityToSpawn);
				}
			}
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, (int) 100, (int) 1, (false), (false)));
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getMinecraftServer() != null) {
					_ent.world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
						@Override
						public String getName() {
							return "";
						}

						@Override
						public boolean canUseCommand(int permission, String command) {
							return true;
						}

						@Override
						public World getEntityWorld() {
							return _ent.world;
						}

						@Override
						public MinecraftServer getServer() {
							return _ent.world.getMinecraftServer();
						}

						@Override
						public boolean sendCommandFeedback() {
							return false;
						}

						@Override
						public BlockPos getPosition() {
							return _ent.getPosition();
						}

						@Override
						public Vec3d getPositionVector() {
							return new Vec3d(_ent.posX, _ent.posY, _ent.posZ);
						}

						@Override
						public Entity getCommandSenderEntity() {
							return _ent;
						}
					}, "tp @s ~ 500 ~");
				}
			}
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getMinecraftServer() != null) {
					_ent.world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
						@Override
						public String getName() {
							return "";
						}

						@Override
						public boolean canUseCommand(int permission, String command) {
							return true;
						}

						@Override
						public World getEntityWorld() {
							return _ent.world;
						}

						@Override
						public MinecraftServer getServer() {
							return _ent.world.getMinecraftServer();
						}

						@Override
						public boolean sendCommandFeedback() {
							return false;
						}

						@Override
						public BlockPos getPosition() {
							return _ent.getPosition();
						}

						@Override
						public Vec3d getPositionVector() {
							return new Vec3d(_ent.posX, _ent.posY, _ent.posZ);
						}

						@Override
						public Entity getCommandSenderEntity() {
							return _ent;
						}
					}, "kill @s");
				}
			}
		} else if (((random) < (2.0 / 6.0))) {
			if (!world.isRemote) {
				Entity entityToSpawn = new EntityFarmerAfrican.EntityCustom(world);
				if (entityToSpawn != null) {
					entityToSpawn.setLocationAndAngles((entity.posX), (entity.posY), (entity.posZ), world.rand.nextFloat() * 360F, 0.0F);
					world.spawnEntity(entityToSpawn);
				}
			}
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, (int) 100, (int) 1, (false), (false)));
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getMinecraftServer() != null) {
					_ent.world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
						@Override
						public String getName() {
							return "";
						}

						@Override
						public boolean canUseCommand(int permission, String command) {
							return true;
						}

						@Override
						public World getEntityWorld() {
							return _ent.world;
						}

						@Override
						public MinecraftServer getServer() {
							return _ent.world.getMinecraftServer();
						}

						@Override
						public boolean sendCommandFeedback() {
							return false;
						}

						@Override
						public BlockPos getPosition() {
							return _ent.getPosition();
						}

						@Override
						public Vec3d getPositionVector() {
							return new Vec3d(_ent.posX, _ent.posY, _ent.posZ);
						}

						@Override
						public Entity getCommandSenderEntity() {
							return _ent;
						}
					}, "tp @s ~ 500 ~");
				}
			}
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getMinecraftServer() != null) {
					_ent.world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
						@Override
						public String getName() {
							return "";
						}

						@Override
						public boolean canUseCommand(int permission, String command) {
							return true;
						}

						@Override
						public World getEntityWorld() {
							return _ent.world;
						}

						@Override
						public MinecraftServer getServer() {
							return _ent.world.getMinecraftServer();
						}

						@Override
						public boolean sendCommandFeedback() {
							return false;
						}

						@Override
						public BlockPos getPosition() {
							return _ent.getPosition();
						}

						@Override
						public Vec3d getPositionVector() {
							return new Vec3d(_ent.posX, _ent.posY, _ent.posZ);
						}

						@Override
						public Entity getCommandSenderEntity() {
							return _ent;
						}
					}, "kill @s");
				}
			}
		} else if (((random) < (3.0 / 6.0))) {
			if (!world.isRemote) {
				Entity entityToSpawn = new EntityButcherAfrican.EntityCustom(world);
				if (entityToSpawn != null) {
					entityToSpawn.setLocationAndAngles((entity.posX), (entity.posY), (entity.posZ), world.rand.nextFloat() * 360F, 0.0F);
					world.spawnEntity(entityToSpawn);
				}
			}
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, (int) 100, (int) 1, (false), (false)));
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getMinecraftServer() != null) {
					_ent.world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
						@Override
						public String getName() {
							return "";
						}

						@Override
						public boolean canUseCommand(int permission, String command) {
							return true;
						}

						@Override
						public World getEntityWorld() {
							return _ent.world;
						}

						@Override
						public MinecraftServer getServer() {
							return _ent.world.getMinecraftServer();
						}

						@Override
						public boolean sendCommandFeedback() {
							return false;
						}

						@Override
						public BlockPos getPosition() {
							return _ent.getPosition();
						}

						@Override
						public Vec3d getPositionVector() {
							return new Vec3d(_ent.posX, _ent.posY, _ent.posZ);
						}

						@Override
						public Entity getCommandSenderEntity() {
							return _ent;
						}
					}, "tp @s ~ 500 ~");
				}
			}
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getMinecraftServer() != null) {
					_ent.world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
						@Override
						public String getName() {
							return "";
						}

						@Override
						public boolean canUseCommand(int permission, String command) {
							return true;
						}

						@Override
						public World getEntityWorld() {
							return _ent.world;
						}

						@Override
						public MinecraftServer getServer() {
							return _ent.world.getMinecraftServer();
						}

						@Override
						public boolean sendCommandFeedback() {
							return false;
						}

						@Override
						public BlockPos getPosition() {
							return _ent.getPosition();
						}

						@Override
						public Vec3d getPositionVector() {
							return new Vec3d(_ent.posX, _ent.posY, _ent.posZ);
						}

						@Override
						public Entity getCommandSenderEntity() {
							return _ent;
						}
					}, "kill @s");
				}
			}
		} else if (((random) < (4.0 / 6.0))) {
			if (!world.isRemote) {
				Entity entityToSpawn = new EntityPriestAfrican.EntityCustom(world);
				if (entityToSpawn != null) {
					entityToSpawn.setLocationAndAngles((entity.posX), (entity.posY), (entity.posZ), world.rand.nextFloat() * 360F, 0.0F);
					world.spawnEntity(entityToSpawn);
				}
			}
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, (int) 100, (int) 1, (false), (false)));
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getMinecraftServer() != null) {
					_ent.world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
						@Override
						public String getName() {
							return "";
						}

						@Override
						public boolean canUseCommand(int permission, String command) {
							return true;
						}

						@Override
						public World getEntityWorld() {
							return _ent.world;
						}

						@Override
						public MinecraftServer getServer() {
							return _ent.world.getMinecraftServer();
						}

						@Override
						public boolean sendCommandFeedback() {
							return false;
						}

						@Override
						public BlockPos getPosition() {
							return _ent.getPosition();
						}

						@Override
						public Vec3d getPositionVector() {
							return new Vec3d(_ent.posX, _ent.posY, _ent.posZ);
						}

						@Override
						public Entity getCommandSenderEntity() {
							return _ent;
						}
					}, "tp @s ~ 500 ~");
				}
			}
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getMinecraftServer() != null) {
					_ent.world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
						@Override
						public String getName() {
							return "";
						}

						@Override
						public boolean canUseCommand(int permission, String command) {
							return true;
						}

						@Override
						public World getEntityWorld() {
							return _ent.world;
						}

						@Override
						public MinecraftServer getServer() {
							return _ent.world.getMinecraftServer();
						}

						@Override
						public boolean sendCommandFeedback() {
							return false;
						}

						@Override
						public BlockPos getPosition() {
							return _ent.getPosition();
						}

						@Override
						public Vec3d getPositionVector() {
							return new Vec3d(_ent.posX, _ent.posY, _ent.posZ);
						}

						@Override
						public Entity getCommandSenderEntity() {
							return _ent;
						}
					}, "kill @s");
				}
			}
		} else if (((random) < (5.0 / 6.0))) {
			if (!world.isRemote) {
				Entity entityToSpawn = new EntityBlacksmithAfrican.EntityCustom(world);
				if (entityToSpawn != null) {
					entityToSpawn.setLocationAndAngles((entity.posX), (entity.posY), (entity.posZ), world.rand.nextFloat() * 360F, 0.0F);
					world.spawnEntity(entityToSpawn);
				}
			}
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, (int) 100, (int) 1, (false), (false)));
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getMinecraftServer() != null) {
					_ent.world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
						@Override
						public String getName() {
							return "";
						}

						@Override
						public boolean canUseCommand(int permission, String command) {
							return true;
						}

						@Override
						public World getEntityWorld() {
							return _ent.world;
						}

						@Override
						public MinecraftServer getServer() {
							return _ent.world.getMinecraftServer();
						}

						@Override
						public boolean sendCommandFeedback() {
							return false;
						}

						@Override
						public BlockPos getPosition() {
							return _ent.getPosition();
						}

						@Override
						public Vec3d getPositionVector() {
							return new Vec3d(_ent.posX, _ent.posY, _ent.posZ);
						}

						@Override
						public Entity getCommandSenderEntity() {
							return _ent;
						}
					}, "tp @s ~ 500 ~");
				}
			}
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getMinecraftServer() != null) {
					_ent.world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
						@Override
						public String getName() {
							return "";
						}

						@Override
						public boolean canUseCommand(int permission, String command) {
							return true;
						}

						@Override
						public World getEntityWorld() {
							return _ent.world;
						}

						@Override
						public MinecraftServer getServer() {
							return _ent.world.getMinecraftServer();
						}

						@Override
						public boolean sendCommandFeedback() {
							return false;
						}

						@Override
						public BlockPos getPosition() {
							return _ent.getPosition();
						}

						@Override
						public Vec3d getPositionVector() {
							return new Vec3d(_ent.posX, _ent.posY, _ent.posZ);
						}

						@Override
						public Entity getCommandSenderEntity() {
							return _ent;
						}
					}, "kill @s");
				}
			}
		} else if (((random) < (6.0 / 6.0))) {
			if (!world.isRemote) {
				Entity entityToSpawn = new EntityLibrarianAfrican.EntityCustom(world);
				if (entityToSpawn != null) {
					entityToSpawn.setLocationAndAngles((entity.posX), (entity.posY), (entity.posZ), world.rand.nextFloat() * 360F, 0.0F);
					world.spawnEntity(entityToSpawn);
				}
			}
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, (int) 100, (int) 1, (false), (false)));
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getMinecraftServer() != null) {
					_ent.world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
						@Override
						public String getName() {
							return "";
						}

						@Override
						public boolean canUseCommand(int permission, String command) {
							return true;
						}

						@Override
						public World getEntityWorld() {
							return _ent.world;
						}

						@Override
						public MinecraftServer getServer() {
							return _ent.world.getMinecraftServer();
						}

						@Override
						public boolean sendCommandFeedback() {
							return false;
						}

						@Override
						public BlockPos getPosition() {
							return _ent.getPosition();
						}

						@Override
						public Vec3d getPositionVector() {
							return new Vec3d(_ent.posX, _ent.posY, _ent.posZ);
						}

						@Override
						public Entity getCommandSenderEntity() {
							return _ent;
						}
					}, "tp @s ~ 500 ~");
				}
			}
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getMinecraftServer() != null) {
					_ent.world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
						@Override
						public String getName() {
							return "";
						}

						@Override
						public boolean canUseCommand(int permission, String command) {
							return true;
						}

						@Override
						public World getEntityWorld() {
							return _ent.world;
						}

						@Override
						public MinecraftServer getServer() {
							return _ent.world.getMinecraftServer();
						}

						@Override
						public boolean sendCommandFeedback() {
							return false;
						}

						@Override
						public BlockPos getPosition() {
							return _ent.getPosition();
						}

						@Override
						public Vec3d getPositionVector() {
							return new Vec3d(_ent.posX, _ent.posY, _ent.posZ);
						}

						@Override
						public Entity getCommandSenderEntity() {
							return _ent;
						}
					}, "kill @s");
				}
			}
		}
	}
}
