
package gordanramsey.loves.babyeating.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import gordanramsey.loves.babyeating.ElementsBabyeatingMod;

@ElementsBabyeatingMod.ModElement.Tag
public class ItemTheWaterlessNation extends ElementsBabyeatingMod.ModElement {
	@GameRegistry.ObjectHolder("babyeating:the_waterless_nation")
	public static final Item block = null;
	public ItemTheWaterlessNation(ElementsBabyeatingMod instance) {
		super(instance, 73);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("babyeating:the_waterless_nation", "inventory"));
	}
	public static class MusicDiscItemCustom extends ItemRecord {
		public MusicDiscItemCustom() {
			super("the_waterless_nation", ElementsBabyeatingMod.sounds.get(new ResourceLocation("babyeating:thewaterlessnation")));
			setUnlocalizedName("the_waterless_nation");
			setRegistryName("the_waterless_nation");
			setCreativeTab(CreativeTabs.MISC);
		}
	}
}
