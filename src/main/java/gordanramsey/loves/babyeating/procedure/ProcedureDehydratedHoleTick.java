package gordanramsey.loves.babyeating.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.block.state.IBlockState;

import java.util.Map;

import gordanramsey.loves.babyeating.ElementsBabyeatingMod;

@ElementsBabyeatingMod.ModElement.Tag
public class ProcedureDehydratedHoleTick extends ElementsBabyeatingMod.ModElement {
	public ProcedureDehydratedHoleTick(ElementsBabyeatingMod instance) {
		super(instance, 106);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure DehydratedHoleTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure DehydratedHoleTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure DehydratedHoleTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure DehydratedHoleTick!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		double RNG = 0;
		String itemID = "";
		ItemStack itemStack = ItemStack.EMPTY;
		if ((!((new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "digsNeeded")) > 0))) {
			if (!world.isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				IBlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().setDouble("digsNeeded", Math.ceil((Math.random() * 10)));
				world.notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		} else {
			if (((((new Object() {
				public String getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getString(tag);
					return "";
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "item"))).equals("")) || (((new Object() {
				public String getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getString(tag);
					return "";
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "item"))).equals("minecraft:air")))) {
				RNG = (double) Math.random();
				if (((RNG) > 0.95)) {
					itemID = (String) "minecraft:dirt";
				} else if (((RNG) > 0.9)) {
					itemID = (String) "minecraft:beetroot";
				} else if (((RNG) > 0.85)) {
					itemID = (String) "minecraft:cactus";
				} else if (((RNG) > 0.8)) {
					itemID = (String) "minecraft:carrot";
				} else if (((RNG) > 0.75)) {
					itemID = (String) "minecraft:egg";
				} else if (((RNG) > 0.7)) {
					itemID = (String) "minecraft:feather";
				} else if (((RNG) > 0.65)) {
					itemID = (String) "minecraft:fish";
				} else if (((RNG) > 0.6)) {
					itemID = (String) "minecraft:mushroom_stew";
				} else if (((RNG) > 0.55)) {
					itemID = (String) "minecraft:nether_wart";
				} else if (((RNG) > 0.5)) {
					itemID = (String) "minecraft:poisonous_potato";
				} else if (((RNG) > 0.45)) {
					itemID = (String) "minecraft:potato";
				} else if (((RNG) > 0.4)) {
					itemID = (String) "minecraft:reeds";
				} else if (((RNG) > 0.35)) {
					itemID = (String) "minecraft:rotten_flesh";
				} else if (((RNG) > 0.3)) {
					itemID = (String) "babyeating:sperm_bar";
				} else if (((RNG) > 0.25)) {
					itemID = (String) "babyeating:spermdrill";
				} else if (((RNG) > 0.2)) {
					itemID = (String) "babyeating:super_glue";
				} else if (((RNG) > 0.15)) {
					itemID = (String) "babyeating:dadsbelt";
				} else if (((RNG) > 0.1)) {
					itemID = (String) "babyeating:durable_dung";
				} else if (((RNG) > 0.05)) {
					itemID = (String) "babyeating:moms_slipper";
				} else if (((RNG) > 0)) {
					itemID = (String) "babyeating:underwearslingshot";
				}
				if (!world.isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					IBlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().setString("item", (itemID));
					world.notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
		}
	}
}
