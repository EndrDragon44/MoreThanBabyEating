
package gordanramsey.loves.babyeating.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import gordanramsey.loves.babyeating.item.ItemStrongerClay;
import gordanramsey.loves.babyeating.item.ItemSpermBar;
import gordanramsey.loves.babyeating.ElementsBabyeatingMod;

@ElementsBabyeatingMod.ModElement.Tag
public class RecipeSpermbariess extends ElementsBabyeatingMod.ModElement {
	public RecipeSpermbariess(ElementsBabyeatingMod instance) {
		super(instance, 29);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(ItemStrongerClay.block, (int) (1)), new ItemStack(ItemSpermBar.block, (int) (1)), 1F);
	}
}
