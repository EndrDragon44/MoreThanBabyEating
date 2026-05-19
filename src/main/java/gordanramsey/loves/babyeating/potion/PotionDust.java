
package gordanramsey.loves.babyeating.potion;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.Potion;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.Minecraft;
import net.minecraft.init.MobEffects;



import java.util.Map;
import java.util.HashMap;

import gordanramsey.loves.babyeating.procedure.ProcedureMomsSlipperLivingEntityIsHitWithTool;
import gordanramsey.loves.babyeating.procedure.ProcedureMomsSlipperWearOffEffect;
import gordanramsey.loves.babyeating.ElementsBabyeatingMod;

@ElementsBabyeatingMod.ModElement.Tag
public class PotionDust extends ElementsBabyeatingMod.ModElement {
	@GameRegistry.ObjectHolder("babyeating:dust")
	public static final Potion potion = null;
	public PotionDust(ElementsBabyeatingMod instance) {
		super(instance, 78);
	}

	@Override
	public void initElements() {
		elements.potions.add(() -> new PotionCustom());
	}
	public static class PotionCustom extends Potion {
		private final ResourceLocation potionIcon;
		public PotionCustom() {
			super(false, -6710887);
			setRegistryName("dust");
			setPotionName("effect.dust");
			potionIcon = new ResourceLocation("babyeating:textures/mob_effect/dust.png");
		}

		@Override
		public boolean isInstant() {
			return true;
		}

		@Override
		public boolean shouldRenderInvText(PotionEffect effect) {
			return true;
		}

		@Override
		public boolean shouldRenderHUD(PotionEffect effect) {
			return true;
		}

		@Override
		public void affectEntity(Entity source, Entity indirectSource, EntityLivingBase entity, int amplifier, double health) {
			World world = entity.world;
			int x = (int) entity.posX;
			int y = (int) entity.posY;
			int z = (int) entity.posZ;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureMomsSlipperLivingEntityIsHitWithTool.executeProcedure($_dependencies);
			}
		}

		@Override
		public void removeAttributesModifiersFromEntity(EntityLivingBase entity, AbstractAttributeMap attributeMapIn, int amplifier) {
			super.removeAttributesModifiersFromEntity(entity, attributeMapIn, amplifier);
			World world = entity.world;
			int x = (int) entity.posX;
			int y = (int) entity.posY;
			int z = (int) entity.posZ;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				if (entity == null) {
					System.err.println("Failed to load dependency entity for procedure MomsSlipperWearOffEffect!");
					return;
				}
				
				if (entity instanceof EntityLivingBase)
					((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, (int) 1, (int) 2, (true), (false)));
				if (entity instanceof EntityLivingBase)
					((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, (int) 1, (int) 4, (true), (false)));
				if (entity instanceof EntityLivingBase)
					((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, (int) 1, (int) 3, (true), (false)));

			}
		}

		@SideOnly(Side.CLIENT)
		@Override
		public void renderInventoryEffect(int x, int y, PotionEffect effect, Minecraft mc) {
			if (mc.currentScreen != null) {
				mc.getTextureManager().bindTexture(potionIcon);
				Gui.drawModalRectWithCustomSizedTexture(x + 6, y + 7, 0, 0, 18, 18, 18, 18);
			}
		}

		@SideOnly(Side.CLIENT)
		@Override
		public void renderHUDEffect(int x, int y, PotionEffect effect, Minecraft mc, float alpha) {
			mc.getTextureManager().bindTexture(potionIcon);
			Gui.drawModalRectWithCustomSizedTexture(x + 3, y + 3, 0, 0, 18, 18, 18, 18);
		}

		@Override
		public boolean isReady(int duration, int amplifier) {
			return true;
		}
	}
}
