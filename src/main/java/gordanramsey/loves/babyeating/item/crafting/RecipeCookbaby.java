
package gordanramsey.loves.babyeating.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import gordanramsey.loves.babyeating.item.ItemUncookedBaby;
import gordanramsey.loves.babyeating.item.ItemCookedBaby;
import gordanramsey.loves.babyeating.ElementsBabyeatingMod;

@ElementsBabyeatingMod.ModElement.Tag
public class RecipeCookbaby extends ElementsBabyeatingMod.ModElement {
	public RecipeCookbaby(ElementsBabyeatingMod instance) {
		super(instance, 8);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(ItemUncookedBaby.block, (int) (1)), new ItemStack(ItemCookedBaby.block, (int) (1)), 1F);
	}
}
