package gordanramsey.loves.babyeating.procedure;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.Entity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import java.util.Map;
import java.util.Iterator;

import gordanramsey.loves.babyeating.item.ItemMomsbelt;
import gordanramsey.loves.babyeating.item.ItemCookedBaby;
import gordanramsey.loves.babyeating.ElementsBabyeatingMod;

@ElementsBabyeatingMod.ModElement.Tag
public class ProcedureDeegDies extends ElementsBabyeatingMod.ModElement {
	public ProcedureDeegDies(ElementsBabyeatingMod instance) {
		super(instance, 85);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure DeegDies!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure DeegDies!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure DeegDies!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure DeegDies!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure DeegDies!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		ItemStack itemToDrop = ItemStack.EMPTY;
		double random = 0;
		random = (double) Math.random();
		if (entity instanceof EntityPlayerMP) {
			Advancement _adv = ((MinecraftServer) ((EntityPlayerMP) entity).mcServer).getAdvancementManager()
					.getAdvancement(new ResourceLocation("babyeating:kill_deegan"));
			AdvancementProgress _ap = ((EntityPlayerMP) entity).getAdvancements().getProgress(_adv);
			if (!_ap.isDone()) {
				Iterator _iterator = _ap.getRemaningCriteria().iterator();
				while (_iterator.hasNext()) {
					String _criterion = (String) _iterator.next();
					((EntityPlayerMP) entity).getAdvancements().grantCriterion(_adv, _criterion);
				}
			}
		}
		if (((random) < 0.1)) {
			random = (double) Math.random();
			if (((random) > 0.5)) {
				itemToDrop = new ItemStack(ItemCookedBaby.block, (int) (1));
				random = (double) Math.random();
				if (((random) > 0.5)) {
					((itemToDrop)).grow((int) 1);
				}
			} else if (((random) < 0.5)) {
				itemToDrop = new ItemStack(ItemMomsbelt.block, (int) (1));
				random = (double) Math.random();
				if (((random) > 0.5)) {
					((itemToDrop)).grow((int) 1);
				}
			}
			if (!world.isRemote) {
				EntityItem entityToSpawn = new EntityItem(world, x, y, z, (itemToDrop));
				entityToSpawn.setPickupDelay(10);
				world.spawnEntity(entityToSpawn);
			}
		}
	}
}
