package gordanramsey.loves.babyeating.procedure;

import net.minecraft.util.text.TextComponentString;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import java.util.Map;

import gordanramsey.loves.babyeating.ElementsBabyeatingMod;

@ElementsBabyeatingMod.ModElement.Tag
public class ProcedureBabyformulaPotionStartedapplied extends ElementsBabyeatingMod.ModElement {
	public ProcedureBabyformulaPotionStartedapplied(ElementsBabyeatingMod instance) {
		super(instance, 12);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure BabyformulaPotionStartedapplied!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).getFoodStats().setFoodLevel((int) 5);
		if (entity instanceof EntityPlayer && !entity.world.isRemote) {
			((EntityPlayer) entity).sendStatusMessage(new TextComponentString("You drink the milk bottle, but something is off."), (true));
		}
		if (entity instanceof EntityPlayer && !entity.world.isRemote) {
			((EntityPlayer) entity).sendStatusMessage(new TextComponentString((("<") + "" + ((entity.getDisplayName().getUnformattedText())) + ""
					+ (" (in thoughts)> This isn't mommy's milk! Makes me wanna puke..."))), (true));
		}
	}
}
