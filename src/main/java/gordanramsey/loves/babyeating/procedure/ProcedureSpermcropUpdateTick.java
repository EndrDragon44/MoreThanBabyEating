package gordanramsey.loves.babyeating.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.state.IBlockState;

import java.util.Map;

import gordanramsey.loves.babyeating.ElementsBabyeatingMod;

@ElementsBabyeatingMod.ModElement.Tag
public class ProcedureSpermcropUpdateTick extends ElementsBabyeatingMod.ModElement {
	public ProcedureSpermcropUpdateTick(ElementsBabyeatingMod instance) {
		super(instance, 98);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure SpermcropUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure SpermcropUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure SpermcropUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure SpermcropUpdateTick!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		double cropTargetAge = 0;
		double cropAge = 0;
		String cropState = "";
		String currentStageTexture = "";
		cropAge = (double) (new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "cropAge"));
		cropTargetAge = (double) (new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "cropTarget"));
		cropState = (String) (new Object() {
			public String getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getString(tag);
				return "";
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "cropState"));
		currentStageTexture = (String) (new Object() {
			public String getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getString(tag);
				return "";
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "currentStageTexture"));
		if (((0 <= (cropTargetAge)) == ((cropTargetAge) <= 93180))) {
			cropTargetAge = (double) (84480 + ((Math.random() * 17401) - 8700));
			cropAge = (double) 0;
			cropState = (String) "S1";
		} else if (((0 <= (cropAge)) && ((cropAge) <= (cropTargetAge)))) {
			if (((cropAge) <= ((cropTargetAge) * 0.25))) {
				cropState = (String) "S1";
			} else if (((cropAge) <= ((cropTargetAge) * 0.5))) {
				cropState = (String) "S2";
			} else if (((cropAge) <= ((cropTargetAge) * 0.75))) {
				cropState = (String) "S3";
			} else if (((cropAge) <= ((cropTargetAge) * 1))) {
				cropState = (String) "done";
			}
		} else if ((!((0 <= (cropAge)) && ((cropAge) <= (cropTargetAge))))) {
			cropTargetAge = (double) (84480 + ((Math.random() * 17401) - 8700));
			cropAge = (double) 0;
			cropState = (String) "S1";
		}
		if ((((cropState)).equals("done"))) {
			if ((!(((cropState)).equals("S4")))) {/* Change Texture */
				System.out.println("Sperm Crop Changing texture to Stage 4 - Harvest Stage");
			}
		} else if ((!(((cropState)).equals("done")))) {
			if ((((currentStageTexture)).equals("Stage3"))) {
				if ((!(((cropState)).equals("S3")))) {
					System.out.println("Sperm Crop Changing texture to Stage 3");/* Change Texture */
				}
			} else if ((((currentStageTexture)).equals("Stage2"))) {
				if ((!(((cropState)).equals("S2")))) {
					System.out.println("Sperm Crop Changing texture to Stage 2");/* Change Texture */
				}
			} else if ((((currentStageTexture)).equals("Stage1"))) {
				if ((!(((cropState)).equals("S1")))) {
					System.out.println("Sperm Crop Changing texture to Stage 1");/* Change Texture */
				}
			} else {
				System.out.println("Sperm Crop Changing texture to Stage 1 as failsafe.");/* Change Texture */
			}
		}
		if (!world.isRemote) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			IBlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().setDouble("cropAge", (cropAge));
			world.notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		if (!world.isRemote) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			IBlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().setDouble("cropTarget", (cropTargetAge));
			world.notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		if (!world.isRemote) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			IBlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().setString("cropState", (cropState));
			world.notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		if (!world.isRemote) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			IBlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().setString("currentStageTexture", (currentStageTexture));
			world.notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
	}
}
