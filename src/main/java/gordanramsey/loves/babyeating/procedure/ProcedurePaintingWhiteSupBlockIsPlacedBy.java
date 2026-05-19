package gordanramsey.loves.babyeating.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.IProperty;
import net.minecraft.init.Blocks;
import net.minecraft.util.text.TextComponentString;

import java.util.*;

import gordanramsey.loves.babyeating.ElementsBabyeatingMod;

@ElementsBabyeatingMod.ModElement.Tag
public class ProcedurePaintingWhiteSupBlockIsPlacedBy extends ElementsBabyeatingMod.ModElement {

    public ProcedurePaintingWhiteSupBlockIsPlacedBy(ElementsBabyeatingMod instance) {
        super(instance, 89);
    }

    private static final List<String> IMAGE_PRIORITY = Arrays.asList(
            "monkeymug",
            "kfcfight",
            "deegflag",
            "default"
    );

    private static final Random RAND = new Random();

    public static void executeProcedure(Map<String, Object> dependencies) {
        if (dependencies.get("x") == null || dependencies.get("y") == null || dependencies.get("z") == null || dependencies.get("world") == null) {
            System.err.println("Painting procedure: missing dependencies");
            return;
        }

        int x = (int) dependencies.get("x");
        int y = (int) dependencies.get("y");
        int z = (int) dependencies.get("z");
        World world = (World) dependencies.get("world");

        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);

        if (te == null) return;

        IBlockState state = world.getBlockState(pos);

        // -----------------------------
        // 1. Determine facing direction
        // -----------------------------
        EnumFacing facing = EnumFacing.NORTH;

        for (IProperty<?> prop : state.getProperties().keySet()) {
            if (prop instanceof PropertyDirection && prop.getName().equals("facing")) {
                try {
                    facing = (EnumFacing) state.getValue((PropertyDirection) prop);
                } catch (Exception ignored) {}
            }
        }

        BlockPos supportPos = pos.offset(facing.getOpposite());
        boolean supported = world.getBlockState(supportPos).isSideSolid(world, supportPos, facing);

        // -----------------------------
        // 2. Support failure handling
        // -----------------------------
        double failTicks = te.getTileData().getDouble("SupportFailTicks");

        if (!supported) {
            failTicks++;
            te.getTileData().setDouble("SupportFailTicks", failTicks);

            if (failTicks >= 20) {
                if (!world.isRemote) {
                    world.destroyBlock(pos, true);
                }
                return;
            }
        } else {
            te.getTileData().setDouble("SupportFailTicks", 0);
        }

        // -----------------------------
        // 3. Texture selection logic
        // -----------------------------
        String current = te.getTileData().getString("shownImage");

        if (current == null || current.isEmpty()) {
            current = pickImageFallback(world, pos, te);
        }

        te.getTileData().setString("shownImage", current);
    }

    private static String pickImageFallback(World world, BlockPos pos, TileEntity te) {

        List<String> pool = new ArrayList<>(IMAGE_PRIORITY);

        // shuffle so we don't always bias same order
        Collections.shuffle(pool, RAND);

        for (String id : pool) {
            if (isValidMapping(id)) {
                return id;
            } else {
                System.err.println("Painting: invalid texture mapping '" + id + "', skipping...");
            }
        }

        // absolute fallback (only if everything fails)
        if (isValidMapping("default")) {
            return "default";
        }

        // catastrophic failure state
        System.err.println("Painting: ALL texture mappings failed, forcing empty state");
        return "";
    }

    private static boolean isValidMapping(String id) {
        // In real MCreator setups you'd validate against your JSON registry.
        return id != null && !id.isEmpty();
    }
}