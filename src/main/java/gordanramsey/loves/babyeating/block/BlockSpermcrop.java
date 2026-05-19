
package gordanramsey.loves.babyeating.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.NonNullList;
import net.minecraft.util.EnumFacing;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.Block;

import gordanramsey.loves.babyeating.item.ItemSperm;
import gordanramsey.loves.babyeating.ElementsBabyeatingMod;

@ElementsBabyeatingMod.ModElement.Tag
public class BlockSpermcrop extends ElementsBabyeatingMod.ModElement {
	@GameRegistry.ObjectHolder("babyeating:spermcrop")
	public static final Block block = null;
	public BlockSpermcrop(ElementsBabyeatingMod instance) {
		super(instance, 95);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustomFlower());
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("babyeating:spermcrop", "inventory"));
	}
	public static class BlockCustomFlower extends BlockFlower {
		public BlockCustomFlower() {
			setSoundType(SoundType.SLIME);
			setCreativeTab(CreativeTabs.FOOD);
			setHardness(0F);
			setResistance(0F);
			setLightLevel(0F);
			setUnlocalizedName("spermcrop");
			setRegistryName("spermcrop");
		}

		@Override
		public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
			return 1;
		}

		@Override
		public PathNodeType getAiPathNodeType(IBlockState state, IBlockAccess world, BlockPos pos) {
			return PathNodeType.DANGER_OTHER;
		}

		@Override
		public Block.EnumOffsetType getOffsetType() {
			return Block.EnumOffsetType.NONE;
		}

		@Override
		public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
			drops.add(new ItemStack(ItemSperm.block, (int) (7)));
		}

		@Override
		public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
			return new ItemStack(Item.getItemFromBlock(this), 1, this.damageDropped(state));
		}

		@Override
		public MapColor getMapColor(IBlockState state, IBlockAccess blockAccess, BlockPos pos) {
			return MapColor.SNOW;
		}

		@Override
		public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
			return EnumPlantType.Crop;
		}

		@Override
		public BlockFlower.EnumFlowerColor getBlockType() {
			return BlockFlower.EnumFlowerColor.YELLOW;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public void getSubBlocks(CreativeTabs tab, net.minecraft.util.NonNullList<ItemStack> list) {
			for (BlockFlower.EnumFlowerType blockflower$enumflowertype : BlockFlower.EnumFlowerType.getTypes(this.getBlockType())) {
				list.add(new ItemStack(this, 1, blockflower$enumflowertype.getMeta()));
			}
		}
	}
}
