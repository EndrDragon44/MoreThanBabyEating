package gordanramsey.loves.babyeating.procedure;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import java.util.Map;

import gordanramsey.loves.babyeating.ElementsBabyeatingMod;

@ElementsBabyeatingMod.ModElement.Tag
public class ProcedureFertiliadEggRightClicked extends ElementsBabyeatingMod.ModElement {
	public ProcedureFertiliadEggRightClicked(ElementsBabyeatingMod instance) {
		super(instance, 64);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure FertiliadEggRightClicked!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure FertiliadEggRightClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double age = 0;
		if (entity instanceof EntityPlayer && !entity.world.isRemote) {
			((EntityPlayer) entity).sendStatusMessage(new TextComponentString((("Status: ") + "" + ("Your egg is ") + ""
					+ (((itemstack).hasTagCompound() ? (itemstack).getTagCompound().getDouble("eggAge") : -1)) + "" + ("ticks (") + ""
					+ ((Math.round(((itemstack).hasTagCompound() ? (itemstack).getTagCompound().getDouble("eggAge") : -1)) / 24000)) + ""
					+ (" days) of 216000 ticks (9 days)"))), (true));
		}
		age = (double) ((itemstack).hasTagCompound() ? (itemstack).getTagCompound().getDouble("eggAge") : -1);
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).getCooldownTracker().setCooldown(((itemstack)).getItem(), (int) 100);
		System.err.println("[NOT ERROR] " + entity.getDisplayName() + "'s Egg age: " + age + " of 216000 ticks old"); // for
																														// the
																														// external
																														// log
																														// and
																														// console
	}

	@SubscribeEvent
	public void onPickup(EntityItemPickupEvent event) {
		EntityPlayer entity = event.getEntityPlayer();
		int i = (int) entity.posX;
		int j = (int) entity.posY;
		int k = (int) entity.posZ;
		World world = entity.world;
		java.util.HashMap<String, Object> dependencies = new java.util.HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
	}
}
