package gordanramsey.loves.babyeating.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSender;

import java.util.Map;

import gordanramsey.loves.babyeating.ElementsBabyeatingMod;

@ElementsBabyeatingMod.ModElement.Tag
public class ProcedureFertiliadEggItemInInventoryTick extends ElementsBabyeatingMod.ModElement {
	public ProcedureFertiliadEggItemInInventoryTick(ElementsBabyeatingMod instance) {
		super(instance, 62);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure FertiliadEggItemInInventoryTick!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure FertiliadEggItemInInventoryTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");

		// deps ^^ ======== logic vv
		{
			ItemStack _stack = (itemstack);
			if (!_stack.hasTagCompound())
				_stack.setTagCompound(new NBTTagCompound());

			if (!_stack.getTagCompound().hasKey("eggAge")) {
				_stack.getTagCompound().setDouble("eggAge", 0);
			}
		}

		// =========================
		// LOOP (runs every tick)
		// =========================
		{
			ItemStack _stack = (itemstack);
			double age = _stack.getTagCompound().getDouble("eggAge");
			age = age + 1;
			_stack.getTagCompound().setDouble("eggAge", age);

			// System.err.println("[NOT ERROR] " + entity.getDisplayName() + "'s Egg age: " + age + " of 216000 ticks old");
			
			// =========================
			// CHECK
			// =========================
			if (age >= 216000) { // 9 Minecraft days

				// remove original item
				itemstack.shrink(1);

				// run command ONCE
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getMinecraftServer() != null) {
					_ent.world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
						@Override public String getName() { return ""; }
						@Override public boolean canUseCommand(int permission, String command) { return true; }
						@Override public World getEntityWorld() { return _ent.world; }
						@Override public MinecraftServer getServer() { return _ent.world.getMinecraftServer(); }
						@Override public boolean sendCommandFeedback() { return false; }
						@Override public BlockPos getPosition() { return _ent.getPosition(); }
						@Override public Vec3d getPositionVector() { return new Vec3d(_ent.posX, _ent.posY, _ent.posZ); }
						@Override public Entity getCommandSenderEntity() { return _ent; }
					}, (("give @s minecraft:spawn_egg 1 0 {EntityTag:{id:\"babyeating:baby\"},display:{Name:\"§r§f") + ((entity.getDisplayName().getUnformattedText())) + ("'s baby}}")));
				}
				if (!_ent.world.isRemote && _ent.world.getMinecraftServer() != null) {
					_ent.world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
						@Override public String getName() { return ""; }
						@Override public boolean canUseCommand(int permission, String command) { return true; }
						@Override public World getEntityWorld() { return _ent.world; }
						@Override public MinecraftServer getServer() { return _ent.world.getMinecraftServer(); }
						@Override public boolean sendCommandFeedback() { return false; }
						@Override public BlockPos getPosition() { return _ent.getPosition(); }
						@Override public Vec3d getPositionVector() { return new Vec3d(_ent.posX, _ent.posY, _ent.posZ); }
						@Override public Entity getCommandSenderEntity() { return _ent; }
					}, "tellraw @s {\"text\":\"Your new baby is in your inventory, all ready to spawn! You can name them in an anvil before you spawn them.\"}");
				}
			}
		}
	}
}