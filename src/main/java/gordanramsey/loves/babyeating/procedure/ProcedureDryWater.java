package gordanramsey.loves.babyeating.procedure;

import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.EnumHand;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import java.util.Map;

import gordanramsey.loves.babyeating.world.WorldAfrica;
import gordanramsey.loves.babyeating.ElementsBabyeatingMod;

@ElementsBabyeatingMod.ModElement.Tag
public class ProcedureDryWater extends ElementsBabyeatingMod.ModElement {
	public ProcedureDryWater(ElementsBabyeatingMod instance) {
		super(instance, 63);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure DryWater!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure DryWater!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure DryWater!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure DryWater!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure DryWater!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((entity.dimension) == (WorldAfrica.DIMID))) {
			if ((((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Items.WATER_BUCKET, (int) (1)).getItem())) {
				world.playSound((EntityPlayer) null, x, y, z, (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY
						.getObject(new ResourceLocation("entity.generic.extinguish_fire")), SoundCategory.NEUTRAL, (float) 1, (float) 0.82);
				if (entity instanceof EntityLivingBase) {
					ItemStack _setstack = new ItemStack(Items.BUCKET, (int) (1));
					_setstack.setCount(1);
					((EntityLivingBase) entity).setHeldItem(EnumHand.MAIN_HAND, _setstack);
					if (entity instanceof EntityPlayerMP)
						((EntityPlayerMP) entity).inventory.markDirty();
				}
				if (entity instanceof EntityPlayer && !entity.world.isRemote) {
					((EntityPlayer) entity).sendStatusMessage(new TextComponentString(
							"Water evaporate in held buckets! They are made of heat conductive, uninsulated metal after all."), (true));
				}
			} else if ((((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemOffhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Items.WATER_BUCKET, (int) (1)).getItem())) {
				world.playSound((EntityPlayer) null, x, y, z, (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY
						.getObject(new ResourceLocation("entity.generic.extinguish_fire")), SoundCategory.NEUTRAL, (float) 1, (float) 0.82);
				if (entity instanceof EntityLivingBase) {
					ItemStack _setstack = new ItemStack(Items.BUCKET, (int) (1));
					_setstack.setCount(1);
					((EntityLivingBase) entity).setHeldItem(EnumHand.OFF_HAND, _setstack);
					if (entity instanceof EntityPlayerMP)
						((EntityPlayerMP) entity).inventory.markDirty();
				}
				if (entity instanceof EntityPlayer && !entity.world.isRemote) {
					((EntityPlayer) entity).sendStatusMessage(new TextComponentString(
							"Water evaporate in held buckets! They are made of heat conductive, uninsulated metal after all."), (true));
				}
			}
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			int i = (int) entity.posX;
			int j = (int) entity.posY;
			int k = (int) entity.posZ;
			java.util.HashMap<String, Object> dependencies = new java.util.HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
	}
}
