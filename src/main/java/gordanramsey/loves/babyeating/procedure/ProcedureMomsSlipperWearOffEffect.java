package gordanramsey.loves.babyeating.procedure;

import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import java.util.Map;

import gordanramsey.loves.babyeating.ElementsBabyeatingMod;

@ElementsBabyeatingMod.ModElement.Tag
public class ProcedureMomsSlipperWearOffEffect extends ElementsBabyeatingMod.ModElement {
	public ProcedureMomsSlipperWearOffEffect(ElementsBabyeatingMod instance) {
		super(instance, 79);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MomsSlipperWearOffEffect!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, (int) 1, (int) 2, (true), (false)));
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, (int) 1, (int) 4, (true), (false)));
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, (int) 1, (int) 3, (true), (false)));
	}
}
