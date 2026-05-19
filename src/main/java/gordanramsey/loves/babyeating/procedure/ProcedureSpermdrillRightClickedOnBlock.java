package gordanramsey.loves.babyeating.procedure;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Blocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.Entity;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;

import java.util.Random;
import java.util.Map;

import gordanramsey.loves.babyeating.item.ItemSperm;
import gordanramsey.loves.babyeating.block.BlockSpermore;
import gordanramsey.loves.babyeating.ElementsBabyeatingMod;

@ElementsBabyeatingMod.ModElement.Tag
public class ProcedureSpermdrillRightClickedOnBlock extends ElementsBabyeatingMod.ModElement {
	public ProcedureSpermdrillRightClickedOnBlock(ElementsBabyeatingMod instance) {
		super(instance, 19);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SpermdrillRightClickedOnBlock!");
			return false;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure SpermdrillRightClickedOnBlock!");
			return false;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure SpermdrillRightClickedOnBlock!");
			return false;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure SpermdrillRightClickedOnBlock!");
			return false;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure SpermdrillRightClickedOnBlock!");
			return false;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure SpermdrillRightClickedOnBlock!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == BlockSpermore.block.getDefaultState().getBlock())) {
			{
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				IBlockState _bs = Blocks.STONE.getStateFromMeta(0);
				IBlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getProperties().entrySet()) {
					IProperty _property = entry.getKey();
					if (_bs.getPropertyKeys().contains(_property))
						_bs = _bs.withProperty(_property, (Comparable) entry.getValue());
				}
				TileEntity _te = world.getTileEntity(_bp);
				NBTTagCompound _bnbt = null;
				if (_te != null) {
					_bnbt = _te.writeToNBT(new NBTTagCompound());
					_te.invalidate();
				}
				world.setBlockState(_bp, _bs, 3);
				if (_bnbt != null) {
					_te = world.getTileEntity(_bp);
					if (_te != null) {
						try {
							_te.readFromNBT(_bnbt);
						} catch (Exception ignored) {
						}
					}
				}
			}
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemSperm.block, (int) (1));
				_setstack.setCount(4);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
			world.playSound((EntityPlayer) null, x, y, z, (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY
					.getObject(new ResourceLocation("babyeating:drillcollectsound")), SoundCategory.NEUTRAL, (float) 1, (float) 1);
			if (!world.isRemote) {
				world.spawnEntity(new EntityXPOrb(world, x, y, z, (int) ((Math.random() * 16) + 12)));
			}
			{
				ItemStack _ist = (itemstack);
				if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
					_ist.shrink(1);
					_ist.setItemDamage(0);
				}
			}
		}
		return (!((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == BlockSpermore.block.getDefaultState().getBlock()));
	}
}
