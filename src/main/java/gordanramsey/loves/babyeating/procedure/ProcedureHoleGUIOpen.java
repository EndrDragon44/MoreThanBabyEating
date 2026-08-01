package gordanramsey.loves.babyeating.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.Container;
import net.minecraft.init.Items;
import net.minecraft.init.Blocks;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.block.state.IBlockState;

import java.util.function.Supplier;
import java.util.Map;

import gordanramsey.loves.babyeating.item.ItemUnderwearslingshot;
import gordanramsey.loves.babyeating.item.ItemSuperGlue;
import gordanramsey.loves.babyeating.item.ItemSpermdrill;
import gordanramsey.loves.babyeating.item.ItemSpermBar;
import gordanramsey.loves.babyeating.item.ItemMomsbelt;
import gordanramsey.loves.babyeating.item.ItemMomsSlipper;
import gordanramsey.loves.babyeating.item.ItemDurableDung;
import gordanramsey.loves.babyeating.ElementsBabyeatingMod;

@ElementsBabyeatingMod.ModElement.Tag
public class ProcedureHoleGUIOpen extends ElementsBabyeatingMod.ModElement {
	public ProcedureHoleGUIOpen(ElementsBabyeatingMod instance) {
		super(instance, 108);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure HoleGUIOpen!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure HoleGUIOpen!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure HoleGUIOpen!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure HoleGUIOpen!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure HoleGUIOpen!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		String itemID = "";
		double digsNeededNBT = 0;
		double RNG = 0;
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
			digsNeededNBT = (double) (new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "digsNeeded"));
		} else {
			digsNeededNBT = (double) (new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "digsNeeded"));
		}
		itemID = (String) (new Object() {
			public String getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getString(tag);
				return "";
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "item"));
		if ((((itemID)).equals("minecraft:dirt"))) {
			itemStack = new ItemStack(Blocks.DIRT, (int) (1), 0);
		} else if ((((itemID)).equals("minecraft:beetroot"))) {
			itemStack = new ItemStack(Items.BEETROOT, (int) (1));
		} else if ((((itemID)).equals("minecraft:cactus"))) {
			itemStack = new ItemStack(Blocks.CACTUS, (int) (1));
		} else if ((((itemID)).equals("minecraft:carrot"))) {
			itemStack = new ItemStack(Items.CARROT, (int) (1));
		} else if ((((itemID)).equals("minecraft:egg"))) {
			itemStack = new ItemStack(Items.EGG, (int) (1));
		} else if ((((itemID)).equals("minecraft:feather"))) {
			itemStack = new ItemStack(Items.FEATHER, (int) (1));
		} else if ((((itemID)).equals("minecraft:fish"))) {
			itemStack = new ItemStack(Items.FISH, (int) (1), 0);
		} else if ((((itemID)).equals("minecraft:mushroom_stew"))) {
			itemStack = new ItemStack(Items.MUSHROOM_STEW, (int) (1));
		} else if ((((itemID)).equals("minecraft:nether_wart"))) {
			itemStack = new ItemStack(Items.NETHER_WART, (int) (1));
		} else if ((((itemID)).equals("minecraft:poisonous_potato"))) {
			itemStack = new ItemStack(Items.POISONOUS_POTATO, (int) (1));
		} else if ((((itemID)).equals("minecraft:potato"))) {
			itemStack = new ItemStack(Items.POISONOUS_POTATO, (int) (1));
		} else if ((((itemID)).equals("minecraft:reeds"))) {
			itemStack = new ItemStack(Blocks.REEDS, (int) (1));
		} else if ((((itemID)).equals("minecraft:rotten_flesh"))) {
			itemStack = new ItemStack(Items.ROTTEN_FLESH, (int) (1));
		} else if ((((itemID)).equals("babyeating:sperm_bar"))) {
			itemStack = new ItemStack(ItemSpermBar.block, (int) (1));
		} else if ((((itemID)).equals("babyeating:spermdrill"))) {
			itemStack = new ItemStack(ItemSpermdrill.block, (int) (1));
		} else if ((((itemID)).equals("babyeating:super_glue"))) {
			itemStack = new ItemStack(ItemSuperGlue.block, (int) (1));
		} else if ((((itemID)).equals("babyeating:dadsbelt"))) {
			itemStack = new ItemStack(ItemMomsbelt.block, (int) (1));
		} else if ((((itemID)).equals("babyeating:durable_dung"))) {
			itemStack = new ItemStack(ItemDurableDung.block, (int) (1));
		} else if ((((itemID)).equals("babyeating:moms_slipper"))) {
			itemStack = new ItemStack(ItemMomsSlipper.block, (int) (1));
		} else if ((((itemID)).equals("babyeating:underwearslingshot"))) {
			itemStack = new ItemStack(ItemUnderwearslingshot.block, (int) (1));
		}
		if (entity instanceof EntityPlayerMP) {
			Container _current = ((EntityPlayerMP) entity).openContainer;
			if (_current instanceof Supplier) {
				Object invobj = ((Supplier) _current).get();
				if (invobj instanceof Map) {
					((Slot) ((Map) invobj).get((int) (0))).putStack(ItemStack.EMPTY);
					_current.detectAndSendChanges();
				}
			}
		}
	}
}
