
package gordanramsey.loves.babyeating.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

import gordanramsey.loves.babyeating.ElementsBabyeatingMod;

@ElementsBabyeatingMod.ModElement.Tag
public class BlockPlacenta extends ElementsBabyeatingMod.ModElement {
	@GameRegistry.ObjectHolder("babyeating:placenta")
	public static final Block block = null;
	@GameRegistry.ObjectHolder("babyeating:placenta")
	public static final Item item = null;
	private Fluid fluid;
	public BlockPlacenta(ElementsBabyeatingMod instance) {
		super(instance, 10);
		fluid = new Fluid("placenta", new ResourceLocation("babyeating:blocks/placenta_still"),
				new ResourceLocation("babyeating:blocks/placenta_flow")).setLuminosity(0).setDensity(1000).setViscosity(1000).setGaseous(false);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockFluidClassic(fluid, Material.WATER) {
		}.setUnlocalizedName("placenta").setRegistryName("placenta"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName("placenta"));
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		FluidRegistry.registerFluid(fluid);
		FluidRegistry.addBucketForFluid(fluid);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		ModelBakery.registerItemVariants(item);
		ModelLoader.setCustomMeshDefinition(item, new ItemMeshDefinition() {
			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack) {
				return new ModelResourceLocation("babyeating:placenta", "placenta");
			}
		});
		ModelLoader.setCustomStateMapper(block, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return new ModelResourceLocation("babyeating:placenta", "placenta");
			}
		});
	}
}
