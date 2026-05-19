
package gordanramsey.loves.babyeating.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemFood;
import net.minecraft.item.Item;
import net.minecraft.item.EnumAction;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import gordanramsey.loves.babyeating.ElementsBabyeatingMod;

@ElementsBabyeatingMod.ModElement.Tag
public class ItemSpermBerries extends ElementsBabyeatingMod.ModElement {
	@GameRegistry.ObjectHolder("babyeating:sperm_berries")
	public static final Item block = null;
	public ItemSpermBerries(ElementsBabyeatingMod instance) {
		super(instance, 96);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemFoodCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("babyeating:sperm_berries", "inventory"));
	}
	public static class ItemFoodCustom extends ItemFood {
		public ItemFoodCustom() {
			super(5, 2f, true);
			setUnlocalizedName("sperm_berries");
			setRegistryName("sperm_berries");
			setCreativeTab(CreativeTabs.FOOD);
			setMaxStackSize(16);
		}

		@Override
		public int getMaxItemUseDuration(ItemStack stack) {
			return 50;
		}

		@Override
		public EnumAction getItemUseAction(ItemStack par1ItemStack) {
			return EnumAction.EAT;
		}
	}
}
