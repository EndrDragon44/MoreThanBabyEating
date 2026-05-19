package gordanramsey.loves.babyeating.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;

import java.util.Map;
import java.util.HashMap;

import gordanramsey.loves.babyeating.ElementsBabyeatingMod;

@ElementsBabyeatingMod.ModElement.Tag
public class ProcedureVillageSpawnMarkerOnBlockRightClicked extends ElementsBabyeatingMod.ModElement {
	public ProcedureVillageSpawnMarkerOnBlockRightClicked(ElementsBabyeatingMod instance) {
		super(instance, 68);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure VillageSpawnMarkerOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure VillageSpawnMarkerOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure VillageSpawnMarkerOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure VillageSpawnMarkerOnBlockRightClicked!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		System.out.println("Village Spawn Marker: Player right-clicked! Spawning village...");
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			$_dependencies.put("world", world);
			$_dependencies.put("x", x);
			$_dependencies.put("y", y);
			$_dependencies.put("z", z);
			ProcedureSpawnDungeon.executeProcedure($_dependencies);
		}
		world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
	}
}
