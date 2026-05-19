package gordanramsey.loves.babyeating.procedure;

import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import java.util.Map;

import gordanramsey.loves.babyeating.potion.PotionBabyformula;
import gordanramsey.loves.babyeating.ElementsBabyeatingMod;

@ElementsBabyeatingMod.ModElement.Tag
public class ProcedureMomsSlipperLivingEntityIsHitWithTool extends ElementsBabyeatingMod.ModElement {
	public ProcedureMomsSlipperLivingEntityIsHitWithTool(ElementsBabyeatingMod instance) {
		super(instance, 78);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MomsSlipperLivingEntityIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.fallDistance = (float) (0);
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, (int) 60, (int) 1, (true), (false)));
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(PotionBabyformula.potion, (int) 60, (int) 1, (true), (false)));
	}
}
