package gordanramsey.loves.babyeating.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.NonNullList;
import net.minecraft.util.EnumFacing;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockBush;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

import gordanramsey.loves.babyeating.procedure.ProcedureSpermcropUpdateTick;
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
		elements.blocks.add(() -> new BlockCustom());
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("babyeating:spermcrop", "inventory"));
	}

	public static class BlockCustom extends BlockBush {

		//  1–4 stages (your system)
		public static final PropertyInteger STAGE = PropertyInteger.create("stage", 1, 4);

		public BlockCustom() {
			setSoundType(SoundType.SLIME);
			setCreativeTab(CreativeTabs.FOOD);
			setHardness(0F);
			setResistance(0F);
			setLightLevel(0F);
			setUnlocalizedName("spermcrop");
			setRegistryName("spermcrop");

			this.setDefaultState(this.blockState.getBaseState().withProperty(STAGE, 1));
			setTickRandomly(true);
		}

		// =========================
		// BLOCKSTATE
		// =========================

		@Override
		protected BlockStateContainer createBlockState() {
			return new BlockStateContainer(this, STAGE);
		}

		@Override
		public int getMetaFromState(IBlockState state) {
			return state.getValue(STAGE) - 1;
		}

		@Override
		public IBlockState getStateFromMeta(int meta) {
			return this.getDefaultState().withProperty(STAGE, meta + 1);
		}

		// =========================
		// BASIC
		// =========================

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
		public MapColor getMapColor(IBlockState state, IBlockAccess blockAccess, BlockPos pos) {
			return MapColor.SNOW;
		}

		@Override
		public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos,
				IBlockState state, int fortune) {
			drops.add(new ItemStack(ItemSperm.block, 7));
		}

		// =========================
		//  CORE LINK TO YOUR PROCEDURE
		// =========================

		@Override
		public void updateTick(World world, BlockPos pos, IBlockState state, Random random) {

			// Run YOUR logic
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", pos.getX());
				$_dependencies.put("y", pos.getY());
				$_dependencies.put("z", pos.getZ());
				$_dependencies.put("world", world);
				ProcedureSpermcropUpdateTick.executeProcedure($_dependencies);
			}

			//  READ WHAT YOUR PROCEDURE DECIDED
			TileEntity te = world.getTileEntity(pos);
			if (te == null) return;

			String cropState = te.getTileData().getString("cropState");

			int newStage = 1;

			if ("S1".equals(cropState)) newStage = 1;
			else if ("S2".equals(cropState)) newStage = 2;
			else if ("S3".equals(cropState)) newStage = 3;
			else if ("done".equals(cropState)) newStage = 4;

			//  APPLY STAGE ? THIS CHANGES TEXTURE
			if (state.getValue(STAGE) != newStage) {
				world.setBlockState(pos, state.withProperty(STAGE, newStage), 2);

				// optional: keep your debug string in sync
				te.getTileData().setString("currentStageTexture", "Stage" + newStage);
			}
		}
	}
}