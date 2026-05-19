package gordanramsey.loves.babyeating.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.init.Blocks;

import java.util.Map;

import gordanramsey.loves.babyeating.ElementsBabyeatingMod;

@ElementsBabyeatingMod.ModElement.Tag
public class ProcedureVillageSpawnMarkerAdditionalGenerationCondition extends ElementsBabyeatingMod.ModElement {
	public ProcedureVillageSpawnMarkerAdditionalGenerationCondition(ElementsBabyeatingMod instance) {
		super(instance, 70);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure VillageSpawnMarkerAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure VillageSpawnMarkerAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure VillageSpawnMarkerAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure VillageSpawnMarkerAdditionalGenerationCondition!");
			return false;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		boolean returnval = false;
		if (((world.canSeeSky(new BlockPos((int) x, (int) y, (int) z))) && ((!(((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)))
				.getBlock() == Blocks.WATER.getDefaultState().getBlock())
				&& ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock())))
				&& (!(world.isAirBlock(new BlockPos((int) x, (int) (y - 1), (int) z))))))) {
			returnval = (boolean) (true);
		} else {
			returnval = (boolean) (false);
		}
		return (returnval);
	}
}
