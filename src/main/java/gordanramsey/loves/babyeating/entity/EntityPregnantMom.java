
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
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
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
public class EntityPregnantMom extends ElementsBabyeatingMod.ModElement {
	public static final int ENTITYID = 3;
	public static final int ENTITYID_RANGED = 4;
	public EntityPregnantMom(ElementsBabyeatingMod instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		elements.entities
				.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("babyeating", "pregnant_mom"), ENTITYID)
						.name("pregnant_mom").tracker(64, 3, true).egg(-5677, -9826899).build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = allbiomes(Biome.REGISTRY);
		EntityRegistry.addSpawn(EntityCustom.class, 5, 1, 2, EnumCreatureType.AMBIENT, spawnBiomes);
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
			return new RenderLiving(renderManager, new Modelpregnantmom(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("babyeating:textures/pregmom.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityCreature {
		public EntityCustom(World world) {
			super(world);
			setSize(1.4f, 0.9f);
			experienceValue = 0;
			this.isImmuneToFire = false;
			setNoAI(!true);
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAIWander(this, 1));
			this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, true));
			this.tasks.addTask(3, new EntityAILookIdle(this));
			this.tasks.addTask(4, new EntityAISwimming(this));
			this.tasks.addTask(5, new EntityAIAvoidEntity(this, EntityPedophilr.EntityCustom.class, (float) 6, 1, 1.2));
			this.targetTasks.addTask(6, new EntityAINearestAttackableTarget(this, EntityPedophilr.EntityCustom.class, true, true));
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
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("babyeating:momlives"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("babyeating:momhurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("babyeating:momdies"));
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
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3D);
		}
	}

	// Made with Blockbench 4.12.5
	// Exported for Minecraft version 1.7 - 1.12
	// Paste this class into your mod and generate all required imports
	public static class Modelpregnantmom extends ModelBase {
		private final ModelRenderer legs;
		private final ModelRenderer lLeg;
		private final ModelRenderer rLeg;
		private final ModelRenderer arms;
		private final ModelRenderer lArm;
		private final ModelRenderer rArm;
		private final ModelRenderer torso;
		private final ModelRenderer cube_r1;
		private final ModelRenderer head;
		public Modelpregnantmom() {
			textureWidth = 64;
			textureHeight = 64;
			legs = new ModelRenderer(this);
			legs.setRotationPoint(0.0F, 24.0F, 0.0F);
			lLeg = new ModelRenderer(this);
			lLeg.setRotationPoint(-1.0F, -7.0F, 0.0F);
			legs.addChild(lLeg);
			lLeg.cubeList.add(new ModelBox(lLeg, 26, 26, -1.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F, false));
			lLeg.cubeList.add(new ModelBox(lLeg, 22, 30, -1.0F, 5.0F, -1.0F, 2, 2, 3, 0.0F, false));
			rLeg = new ModelRenderer(this);
			rLeg.setRotationPoint(1.0F, -7.0F, 0.0F);
			legs.addChild(rLeg);
			rLeg.cubeList.add(new ModelBox(rLeg, 21, 30, -1.0F, 5.0F, -1.0F, 2, 2, 3, 0.0F, false));
			rLeg.cubeList.add(new ModelBox(rLeg, 18, 26, -1.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F, false));
			arms = new ModelRenderer(this);
			arms.setRotationPoint(0.0F, 24.0F, 0.0F);
			lArm = new ModelRenderer(this);
			lArm.setRotationPoint(2.0F, -14.0F, 0.0F);
			arms.addChild(lArm);
			lArm.cubeList.add(new ModelBox(lArm, 0, 29, 0.0F, -1.0F, -1.0F, 2, 6, 2, 0.0F, false));
			rArm = new ModelRenderer(this);
			rArm.setRotationPoint(-2.0F, -14.0F, 0.0F);
			arms.addChild(rArm);
			rArm.cubeList.add(new ModelBox(rArm, 8, 29, -2.0F, -1.0F, -1.0F, 2, 6, 2, 0.0F, false));
			torso = new ModelRenderer(this);
			torso.setRotationPoint(0.0F, 14.0F, 0.0F);
			torso.cubeList.add(new ModelBox(torso, 0, 0, -3.0F, 1.0F, -3.0F, 6, 2, 6, 0.0F, false));
			torso.cubeList.add(new ModelBox(torso, 0, 8, -2.0F, -2.0F, -2.0F, 4, 4, 6, 0.0F, false));
			torso.cubeList.add(new ModelBox(torso, 18, 18, -2.0F, -5.0F, -2.0F, 4, 3, 5, 0.0F, false));
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, -2.0F, 3.0F);
			torso.addChild(cube_r1);
			setRotationAngle(cube_r1, -0.7854F, 0.0F, 0.0F);
			cube_r1.cubeList.add(new ModelBox(cube_r1, 34, 26, -2.0F, -2.0F, -2.0F, 4, 2, 2, 0.0F, false));
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 9.0F, 0.0F);
			head.cubeList.add(new ModelBox(head, 24, 0, -2.0F, -4.0F, -2.0F, 4, 4, 4, 0.0F, false));
			head.cubeList.add(new ModelBox(head, 0, 18, -2.0F, -7.0F, -4.0F, 4, 6, 5, 0.0F, false));
			head.cubeList.add(new ModelBox(head, 20, 8, -3.0F, -5.0F, -2.0F, 6, 4, 3, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			legs.render(f5);
			arms.render(f5);
			torso.render(f5);
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
			this.lArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.rLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.rArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		}
	}
}
