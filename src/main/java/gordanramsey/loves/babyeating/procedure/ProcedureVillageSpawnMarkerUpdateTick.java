package gordanramsey.loves.babyeating.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;

import java.util.Map;
import java.util.HashMap;

import gordanramsey.loves.babyeating.ElementsBabyeatingMod;

@ElementsBabyeatingMod.ModElement.Tag
public class ProcedureVillageSpawnMarkerUpdateTick extends ElementsBabyeatingMod.ModElement {
	public ProcedureVillageSpawnMarkerUpdateTick(ElementsBabyeatingMod instance) {
		super(instance, 69);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure VillageSpawnMarkerUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure VillageSpawnMarkerUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure VillageSpawnMarkerUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure VillageSpawnMarkerUpdateTick!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		System.out.println("Village Spawn Marker: I exist. Checking for NBT...");
		if (((new Object() {
			public boolean getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "InteractiveMode")) == (true))) {
			System.out.println("Village Spawn Marker: I have {InteractiveMode} set to True. Ceasing.");
		} else {
			System.out.println("Village Spawn Marker: I do not have {InteractiveMode} NBT, or it is set to false. Spawning village.");
			world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("world", world);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				ProcedureSpawnDungeon.executeProcedure($_dependencies);
			}
		}
	}
}
