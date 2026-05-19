
package gordanramsey.loves.babyeating.entity;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import net.minecraft.world.World;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.BossInfo;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;

import java.util.Map;
import java.util.HashMap;

import gordanramsey.loves.babyeating.procedure.ProcedureFitInSmallerGapDEEGAN;
import gordanramsey.loves.babyeating.procedure.ProcedureDeegDies;
import gordanramsey.loves.babyeating.ElementsBabyeatingMod;

@ElementsBabyeatingMod.ModElement.Tag
public class EntityDeeganMainBoss extends ElementsBabyeatingMod.ModElement {
	public static final int ENTITYID = 22;
	public static final int ENTITYID_RANGED = 23;
	public EntityDeeganMainBoss(ElementsBabyeatingMod instance) {
		super(instance, 80);
	}

	@Override
	public void initElements() {
		elements.entities
				.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("babyeating", "deegan_main_boss"), ENTITYID)
						.name("deegan_main_boss").tracker(12, 3, true).egg(-12582912, -7505664).build());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new Modeldeegan_slaveowner(), 0.7f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("babyeating:textures/deegnuts.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob {
		public EntityCustom(World world) {
			super(world);
			setSize(0.7f, 2.3125f);
			experienceValue = 60;
			this.isImmuneToFire = false;
			setNoAI(!true);
			enablePersistence();
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAIWanderAvoidWater(this, 0.7));
			this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true, true));
			this.tasks.addTask(3, new EntityAIAttackMelee(this, 1.01, false));
			this.targetTasks.addTask(4, new EntityAIHurtByTarget(this, true));
			this.tasks.addTask(5, new EntityAIOpenDoor(this, true));
			this.tasks.addTask(6, new EntityAIBreakDoor(this));
			this.targetTasks.addTask(7, new EntityAINearestAttackableTarget(this, EntityBaby.EntityCustom.class, true, true));
			this.targetTasks.addTask(8, new EntityAINearestAttackableTarget(this, EntityAfricaVillager.EntityCustom.class, true, true));
			this.targetTasks.addTask(9, new EntityAINearestAttackableTarget(this, EntityNitwitAfrican.EntityCustom.class, true, true));
			this.targetTasks.addTask(10, new EntityAINearestAttackableTarget(this, EntityFarmerAfrican.EntityCustom.class, true, true));
			this.targetTasks.addTask(11, new EntityAINearestAttackableTarget(this, EntityButcherAfrican.EntityCustom.class, true, true));
			this.targetTasks.addTask(12, new EntityAINearestAttackableTarget(this, EntityPriestAfrican.EntityCustom.class, true, true));
			this.targetTasks.addTask(13, new EntityAINearestAttackableTarget(this, EntityBlacksmithAfrican.EntityCustom.class, true, true));
			this.targetTasks.addTask(14, new EntityAINearestAttackableTarget(this, EntityLibrarianAfrican.EntityCustom.class, true, true));
			this.targetTasks.addTask(15, new EntityAINearestAttackableTarget(this, EntityEnderman.class, true, true));
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.ILLAGER;
		}

		@Override
		protected boolean canDespawn() {
			return false;
		}

		@Override
		protected Item getDropItem() {
			return null;
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("babyeating:deeg-live"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("babyeating:deeg-hit"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("babyeating:deeg-die"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.CACTUS)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		public void onDeath(DamageSource source) {
			super.onDeath(source);
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			Entity entity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				ProcedureDeegDies.executeProcedure($_dependencies);
			}
		}

		@Override
		public void onEntityUpdate() {
			super.onEntityUpdate();
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			Entity entity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				ProcedureFitInSmallerGapDEEGAN.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(10D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(750D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6D);
		}

		@Override
		public boolean isNonBoss() {
			return false;
		}
		private final BossInfoServer bossInfo = new BossInfoServer(this.getDisplayName(), BossInfo.Color.PINK, BossInfo.Overlay.NOTCHED_6);
		@Override
		public void addTrackingPlayer(EntityPlayerMP player) {
			super.addTrackingPlayer(player);
			this.bossInfo.addPlayer(player);
		}

		@Override
		public void removeTrackingPlayer(EntityPlayerMP player) {
			super.removeTrackingPlayer(player);
			this.bossInfo.removePlayer(player);
		}

		@Override
		public void onUpdate() {
			super.onUpdate();
			this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
		}
	}

	// Made with Blockbench 5.1.3
	// Exported for Minecraft version 1.7 - 1.12
	// Paste this class into your mod and generate all required imports
	public static class Modeldeegan_slaveowner extends ModelBase {
		private final ModelRenderer head;
		private final ModelRenderer sideburn_r1;
		private final ModelRenderer sideburn_r2;
		private final ModelRenderer hattop_r1;
		private final ModelRenderer head_r1;
		private final ModelRenderer hat_r1;
		private final ModelRenderer hat_r2;
		private final ModelRenderer body;
		private final ModelRenderer cube_r1;
		private final ModelRenderer lArm;
		private final ModelRenderer cube_r2;
		private final ModelRenderer rArm;
		private final ModelRenderer cube_r3;
		private final ModelRenderer lLeg;
		private final ModelRenderer cube_r4;
		private final ModelRenderer rLeg;
		private final ModelRenderer cube_r5;
		public Modeldeegan_slaveowner() {
			textureWidth = 64;
			textureHeight = 64;
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, -0.75F, 0.75F);
			head.cubeList.add(new ModelBox(head, 0, 13, -1.5F, -7.0F, -3.0F, 3, 7, 6, 0.0F, false));
			sideburn_r1 = new ModelRenderer(this);
			sideburn_r1.setRotationPoint(-0.75F, -2.65F, -0.5F);
			head.addChild(sideburn_r1);
			setRotationAngle(sideburn_r1, -0.1585F, -0.0735F, -0.4305F);
			sideburn_r1.cubeList.add(new ModelBox(sideburn_r1, 20, 46, 0.0F, -4.0F, -3.0F, 2, 1, 6, 0.0F, false));
			sideburn_r2 = new ModelRenderer(this);
			sideburn_r2.setRotationPoint(-1.5F, -3.4F, -0.5F);
			head.addChild(sideburn_r2);
			setRotationAngle(sideburn_r2, -0.1585F, -0.0735F, 0.4305F);
			sideburn_r2.cubeList.add(new ModelBox(sideburn_r2, 42, 45, 0.0F, -4.0F, -3.0F, 2, 1, 6, 0.0F, false));
			hattop_r1 = new ModelRenderer(this);
			hattop_r1.setRotationPoint(-0.5F, -10.35F, 1.5F);
			head.addChild(hattop_r1);
			setRotationAngle(hattop_r1, -0.2184F, 0.0426F, -0.0094F);
			hattop_r1.cubeList.add(new ModelBox(hattop_r1, 32, 8, -0.5F, -1.4F, -1.0F, 2, 3, 2, 0.0F, false));
			head_r1 = new ModelRenderer(this);
			head_r1.setRotationPoint(-0.5F, -4.35F, -2.25F);
			head.addChild(head_r1);
			setRotationAngle(head_r1, -0.2182F, 0.0F, 0.0F);
			head_r1.cubeList.add(new ModelBox(head_r1, 24, 8, -0.5F, -1.4F, -1.0F, 2, 3, 2, 0.0F, false));
			hat_r1 = new ModelRenderer(this);
			hat_r1.setRotationPoint(0.0F, -7.85F, 0.5F);
			head.addChild(hat_r1);
			setRotationAngle(hat_r1, -0.1752F, -0.0859F, 0.0152F);
			hat_r1.cubeList.add(new ModelBox(hat_r1, 30, 29, -1.5F, -2.4F, -3.0F, 3, 4, 6, 0.0F, false));
			hat_r2 = new ModelRenderer(this);
			hat_r2.setRotationPoint(0.0F, -7.85F, 0.5F);
			head.addChild(hat_r2);
			setRotationAngle(hat_r2, -0.1747F, 0.043F, -0.0076F);
			hat_r2.cubeList.add(new ModelBox(hat_r2, 18, 13, -2.0F, 0.6F, -3.5F, 4, 1, 7, 0.0F, false));
			body = new ModelRenderer(this);
			body.setRotationPoint(-20.0F, 24.0F, 12.0F);
			body.cubeList.add(new ModelBox(body, 0, 0, 16.0F, -20.0F, -14.0F, 8, 9, 4, 0.0F, false));
			body.cubeList.add(new ModelBox(body, 24, 0, 16.5F, -25.0F, -13.0F, 7, 5, 3, 0.0F, false));
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(18.5F, -20.0F, -13.0F);
			body.addChild(cube_r1);
			setRotationAngle(cube_r1, -0.1309F, 0.0F, 0.0F);
			cube_r1.cubeList.add(new ModelBox(cube_r1, 30, 21, -2.0F, -7.0F, 2.0F, 7, 5, 3, 0.0F, false));
			lArm = new ModelRenderer(this);
			lArm.setRotationPoint(4.0F, 1.0F, 0.5F);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(-0.5F, -1.25F, 0.0F);
			lArm.addChild(cube_r2);
			setRotationAngle(cube_r2, -0.0436F, 0.0F, -0.0873F);
			cube_r2.cubeList.add(new ModelBox(cube_r2, 0, 26, -0.2156F, -0.8686F, -1.6013F, 3, 14, 3, 0.0F, false));
			rArm = new ModelRenderer(this);
			rArm.setRotationPoint(-3.0F, 1.0F, 0.5F);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(0.0F, -1.25F, 0.0F);
			rArm.addChild(cube_r3);
			setRotationAngle(cube_r3, -0.0436F, 0.0F, 0.0873F);
			cube_r3.cubeList.add(new ModelBox(cube_r3, 18, 21, -3.2042F, -0.7816F, -1.5975F, 3, 14, 3, 0.0F, false));
			lLeg = new ModelRenderer(this);
			lLeg.setRotationPoint(1.5F, 13.0F, 0.0F);
			lLeg.cubeList.add(new ModelBox(lLeg, 12, 38, -1.25F, 9.0F, -5.0F, 3, 2, 6, 0.0F, false));
			lLeg.cubeList.add(new ModelBox(lLeg, 40, 8, -1.25F, -1.0F, -1.5F, 3, 10, 3, 0.0F, false));
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(0.75F, 11.1F, 2.0F);
			lLeg.addChild(cube_r4);
			setRotationAngle(cube_r4, 0.2618F, 0.0F, 0.0F);
			cube_r4.cubeList.add(new ModelBox(cube_r4, 12, 27, -2.0F, -4.0F, -3.0F, 3, 1, 0, 0.0F, false));
			rLeg = new ModelRenderer(this);
			rLeg.setRotationPoint(-1.0F, 13.0F, 0.0F);
			rLeg.cubeList.add(new ModelBox(rLeg, 30, 39, -2.25F, 9.0F, -5.0F, 3, 2, 6, 0.0F, false));
			rLeg.cubeList.add(new ModelBox(rLeg, 0, 43, -2.25F, -1.0F, -1.5F, 3, 10, 3, 0.0F, false));
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(-0.25F, 11.1F, 2.0F);
			rLeg.addChild(cube_r5);
			setRotationAngle(cube_r5, 0.2618F, 0.0F, 0.0F);
			cube_r5.cubeList.add(new ModelBox(cube_r5, 12, 27, -2.0F, -4.0F, -3.0F, 3, 1, 0, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			head.render(f5);
			body.render(f5);
			lArm.render(f5);
			rArm.render(f5);
			lLeg.render(f5);
			rLeg.render(f5);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
			super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
			this.lArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.rLeg.rotateAngleY = MathHelper.cos(f * 0.6662F) * f1;
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.lLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.rArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		}
	}
}
