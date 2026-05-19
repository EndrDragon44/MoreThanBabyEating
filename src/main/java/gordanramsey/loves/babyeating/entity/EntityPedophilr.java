
package gordanramsey.loves.babyeating.entity;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.item.Item;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;

import java.util.Iterator;
import java.util.ArrayList;

import gordanramsey.loves.babyeating.ElementsBabyeatingMod;

@ElementsBabyeatingMod.ModElement.Tag
public class EntityPedophilr extends ElementsBabyeatingMod.ModElement {
	public static final int ENTITYID = 5;
	public static final int ENTITYID_RANGED = 6;
	public EntityPedophilr(ElementsBabyeatingMod instance) {
		super(instance, 16);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class)
				.id(new ResourceLocation("babyeating", "pedophile"), ENTITYID).name("pedophile").tracker(64, 3, true).egg(-6697729, -26113).build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = allbiomes(Biome.REGISTRY);
		EntityRegistry.addSpawn(EntityCustom.class, 1, 1, 1, EnumCreatureType.AMBIENT, spawnBiomes);
	}

	private Biome[] allbiomes(net.minecraft.util.registry.RegistryNamespaced<ResourceLocation, Biome> in) {
		Iterator<Biome> itr = in.iterator();
		ArrayList<Biome> ls = new ArrayList<Biome>();
		while (itr.hasNext())
			ls.add(itr.next());
		return ls.toArray(new Biome[ls.size()]);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new Modelpedo(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("babyeating:textures/newtexturepants.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityCreature {
		public EntityCustom(World world) {
			super(world);
			setSize(0.6f, 1.8f);
			experienceValue = 0;
			this.isImmuneToFire = false;
			setNoAI(!true);
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.5, true));
			this.tasks.addTask(2, new EntityAIWander(this, 1));
			this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
			this.tasks.addTask(4, new EntityAIPanic(this, 1));
			this.tasks.addTask(5, new EntityAILookIdle(this));
			this.tasks.addTask(6, new EntityAISwimming(this));
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.ILLAGER;
		}

		@Override
		protected Item getDropItem() {
			return null;
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("babyeating:pedolaughs"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("babyeating:pedohurts"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("babyeating:pedodeaths"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3D);
		}
	}

	// Made with Blockbench 5.1.3
	// Exported for Minecraft version 1.7 - 1.12
	// Paste this class into your mod and generate all required imports
	public static class Modelpedo extends ModelBase {
		private final ModelRenderer rLeg;
		private final ModelRenderer cube_r1;
		private final ModelRenderer lLeg;
		private final ModelRenderer torso;
		private final ModelRenderer torso_r1;
		private final ModelRenderer larm;
		private final ModelRenderer lArm_r1;
		private final ModelRenderer rArm;
		private final ModelRenderer rArm_r1;
		private final ModelRenderer head;
		private final ModelRenderer cube_r2;
		private final ModelRenderer cube_r3;
		public Modelpedo() {
			textureWidth = 32;
			textureHeight = 32;
			rLeg = new ModelRenderer(this);
			rLeg.setRotationPoint(-1.0F, 14.0F, -1.0F);
			setRotationAngle(rLeg, 0.0F, 0.0F, 0.0F);
			rLeg.cubeList.add(new ModelBox(rLeg, 20, 13, -1.0F, 9.0F, -4.0F, 2, 1, 3, 0.0F, false));
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, 0.0F, -2.0F);
			rLeg.addChild(cube_r1);
			setRotationAngle(cube_r1, -3.1416F, 0.0F, -3.1416F);
			cube_r1.cubeList.add(new ModelBox(cube_r1, 26, 0, -1.0F, -4.0F, -1.0F, 2, 13, 1, 0.0F, false));
			lLeg = new ModelRenderer(this);
			lLeg.setRotationPoint(1.0F, 14.0F, 0.0F);
			setRotationAngle(lLeg, 0.0F, 0.0F, 0.0F);
			lLeg.cubeList.add(new ModelBox(lLeg, 20, 18, -1.0F, 9.0F, -5.0F, 2, 1, 3, 0.0F, false));
			lLeg.cubeList.add(new ModelBox(lLeg, 0, 17, -1.0F, -4.0F, -3.0F, 2, 13, 1, 0.0F, false));
			torso = new ModelRenderer(this);
			torso.setRotationPoint(0.0F, 13.0F, -1.0F);
			setRotationAngle(torso, 0.0F, 0.0F, 0.0F);
			torso.cubeList.add(new ModelBox(torso, 0, 10, -2.0F, -7.0F, -4.0F, 4, 4, 2, 0.0F, false));
			torso.cubeList.add(new ModelBox(torso, 12, 24, -1.0F, -3.8F, -3.0F, 2, 1, 1, 0.0F, false));
			torso_r1 = new ModelRenderer(this);
			torso_r1.setRotationPoint(0.0F, -4.0F, -1.0F);
			torso.addChild(torso_r1);
			setRotationAngle(torso_r1, -3.1416F, 0.0F, -3.1416F);
			torso_r1.cubeList.add(new ModelBox(torso_r1, 0, 0, -2.0F, -5.0F, -1.0F, 4, 6, 2, 0.0F, false));
			larm = new ModelRenderer(this);
			larm.setRotationPoint(-2.0F, 5.0F, 0.0F);
			setRotationAngle(larm, 0.0F, 0.0F, 0.0F);
			lArm_r1 = new ModelRenderer(this);
			lArm_r1.setRotationPoint(9.0F, 0.0F, -2.0F);
			larm.addChild(lArm_r1);
			setRotationAngle(lArm_r1, -3.1416F, 0.0F, 3.1416F);
			lArm_r1.cubeList.add(new ModelBox(lArm_r1, 7, 17, 4.0F, -1.0F, -0.5F, 1, 8, 1, 0.0F, false));
			rArm = new ModelRenderer(this);
			rArm.setRotationPoint(2.0F, 5.0F, 0.0F);
			setRotationAngle(rArm, 0.0F, 0.0F, 0.0F);
			rArm_r1 = new ModelRenderer(this);
			rArm_r1.setRotationPoint(1.0F, 0.0F, -2.0F);
			rArm.addChild(rArm_r1);
			setRotationAngle(rArm_r1, -3.1416F, 0.0F, 3.1416F);
			rArm_r1.cubeList.add(new ModelBox(rArm_r1, 20, 23, 5.0F, -1.0F, -0.5F, 1, 8, 1, 0.0F, false));
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 4.0F, 0.0F);
			setRotationAngle(head, 0.0F, 0.0F, 0.0F);
			head.cubeList.add(new ModelBox(head, 13, 0, -2.0F, -6.9F, -2.7F, 4, 5, 2, 0.0F, false));
			head.cubeList.add(new ModelBox(head, 25, 23, -1.0F, -2.0F, -2.45F, 2, 2, 1, 0.0F, false));
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.0F, -2.5F, -1.7F);
			head.addChild(cube_r2);
			setRotationAngle(cube_r2, -3.1416F, 0.0F, 3.1416F);
			cube_r2.cubeList.add(new ModelBox(cube_r2, 13, 7, -1.0F, -3.0F, 1.0F, 2, 1, 4, 0.0F, false));
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(0.5F, -1.4F, -1.0F);
			head.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.6109F, 0.0F, 0.0F);
			cube_r3.cubeList.add(new ModelBox(cube_r3, 0, 0, -1.0F, -1.0F, -1.0F, 1, 1, 0, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			rLeg.render(f5);
			lLeg.render(f5);
			torso.render(f5);
			larm.render(f5);
			rArm.render(f5);
			head.render(f5);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
			super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
			this.lLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.larm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.rLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.rArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		}
	}
}
