
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
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;

import java.util.Iterator;
import java.util.ArrayList;

import gordanramsey.loves.babyeating.ElementsBabyeatingMod;

@ElementsBabyeatingMod.ModElement.Tag
public class EntitySethMinion extends ElementsBabyeatingMod.ModElement {
	public static final int ENTITYID = 24;
	public static final int ENTITYID_RANGED = 25;
	public EntitySethMinion(ElementsBabyeatingMod instance) {
		super(instance, 82);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class)
				.id(new ResourceLocation("babyeating", "seth_minion"), ENTITYID).name("seth_minion").tracker(64, 3, true).build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = allbiomes(Biome.REGISTRY);
		EntityRegistry.addSpawn(EntityCustom.class, 20, 4, 4, EnumCreatureType.MONSTER, spawnBiomes);
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
			return new RenderLiving(renderManager, new ModelsethBossMinion(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("babyeating:textures/sethminion.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob {
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
			this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.2, false));
			this.tasks.addTask(2, new EntityAIWander(this, 1));
			this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, false));
			this.tasks.addTask(4, new EntityAILookIdle(this));
			this.tasks.addTask(5, new EntityAISwimming(this));
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.UNDEFINED;
		}

		@Override
		protected Item getDropItem() {
			return null;
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.generic.death"));
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

	// Made with Blockbench 5.1.3
	// Exported for Minecraft version 1.7 - 1.12
	// Paste this class into your mod and generate all required imports
	public static class ModelsethBossMinion extends ModelBase {
		private final ModelRenderer head;
		private final ModelRenderer glasses_r1;
		private final ModelRenderer drool;
		private final ModelRenderer torso;
		private final ModelRenderer ass;
		private final ModelRenderer cube_r1;
		private final ModelRenderer lArm;
		private final ModelRenderer cube_r2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer cube_r4;
		private final ModelRenderer rArm;
		private final ModelRenderer cube_r5;
		private final ModelRenderer cube_r6;
		private final ModelRenderer cube_r7;
		private final ModelRenderer lLeg;
		private final ModelRenderer footReveal_r1;
		private final ModelRenderer ties_r1;
		private final ModelRenderer rLeg;
		private final ModelRenderer ties_r2;
		public ModelsethBossMinion() {
			textureWidth = 64;
			textureHeight = 64;
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, -1.0F, 0.0F);
			head.cubeList.add(new ModelBox(head, 0, 10, -2.0F, -4.75F, -3.0F, 4, 5, 6, 0.0F, false));
			glasses_r1 = new ModelRenderer(this);
			glasses_r1.setRotationPoint(0.225F, -1.25F, -0.025F);
			head.addChild(glasses_r1);
			setRotationAngle(glasses_r1, 0.2618F, 0.0F, 0.3054F);
			glasses_r1.cubeList.add(new ModelBox(glasses_r1, 20, 21, -3.0F, -2.0F, -3.0F, 5, 2, 4, 0.0F, false));
			drool = new ModelRenderer(this);
			drool.setRotationPoint(-0.75F, 0.0F, -3.0F);
			head.addChild(drool);
			drool.cubeList.add(new ModelBox(drool, 0, 49, -0.25F, -0.075F, 0.025F, 0, 4, 0, 0.0F, false));
			torso = new ModelRenderer(this);
			torso.setRotationPoint(0.0F, 8.0F, 0.25F);
			torso.cubeList.add(new ModelBox(torso, 20, 10, -3.0F, -2.0F, -2.0F, 6, 7, 4, 0.0F, false));
			torso.cubeList.add(new ModelBox(torso, 24, 0, -2.0F, -8.0F, -1.75F, 4, 7, 3, 0.0F, false));
			torso.cubeList.add(new ModelBox(torso, 0, 21, -3.5F, -8.0F, -1.75F, 7, 2, 3, 0.0F, false));
			torso.cubeList.add(new ModelBox(torso, 0, 26, -3.0F, -6.0F, -1.75F, 6, 1, 3, 0.0F, false));
			torso.cubeList.add(new ModelBox(torso, 38, 29, -1.0F, -10.0F, -1.25F, 2, 2, 2, 0.0F, false));
			ass = new ModelRenderer(this);
			ass.setRotationPoint(0.0F, 3.0F, 1.0F);
			torso.addChild(ass);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, 0.0F, -4.0F);
			ass.addChild(cube_r1);
			setRotationAngle(cube_r1, -0.3927F, 0.0F, 0.0F);
			cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 0, -3.0F, -4.0F, 1.0F, 6, 4, 6, 0.0F, false));
			lArm = new ModelRenderer(this);
			lArm.setRotationPoint(4.0F, 1.0F, 0.25F);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.95F, 1.0F, -0.75F);
			lArm.addChild(cube_r2);
			setRotationAngle(cube_r2, 3.1416F, 0.0F, 0.0F);
			cube_r2.cubeList.add(new ModelBox(cube_r2, 26, 33, -1.0F, -10.0F, -1.0F, 1, 10, 1, 0.0F, false));
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(0.5F, 0.5F, -0.75F);
			lArm.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.0F, 1.5708F, -3.1416F);
			cube_r3.cubeList.add(new ModelBox(cube_r3, 0, 36, -2.0F, -2.0F, -2.0F, 3, 2, 3, 0.0F, false));
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(0.5F, -1.5F, -0.75F);
			lArm.addChild(cube_r4);
			setRotationAngle(cube_r4, 0.0F, 1.5708F, -3.1416F);
			cube_r4.cubeList.add(new ModelBox(cube_r4, 38, 25, -2.0F, -2.0F, -1.0F, 3, 2, 2, 0.0F, false));
			rArm = new ModelRenderer(this);
			rArm.setRotationPoint(-4.0F, 1.0F, 0.25F);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(-0.975F, 1.0F, 0.25F);
			rArm.addChild(cube_r5);
			setRotationAngle(cube_r5, 0.0F, 0.0F, -3.1416F);
			cube_r5.cubeList.add(new ModelBox(cube_r5, 32, 27, -1.0F, -10.0F, -1.0F, 1, 10, 1, 0.0F, false));
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(-0.5F, 0.5F, 0.25F);
			rArm.addChild(cube_r6);
			setRotationAngle(cube_r6, 0.0F, -1.5708F, 3.1416F);
			cube_r6.cubeList.add(new ModelBox(cube_r6, 14, 33, -2.0F, -2.0F, -2.0F, 3, 2, 3, 0.0F, false));
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(-0.5F, -1.5F, 0.25F);
			rArm.addChild(cube_r7);
			setRotationAngle(cube_r7, 0.0F, -1.5708F, 3.1416F);
			cube_r7.cubeList.add(new ModelBox(cube_r7, 38, 0, -2.0F, -2.0F, -1.0F, 3, 2, 2, 0.0F, false));
			lLeg = new ModelRenderer(this);
			lLeg.setRotationPoint(-1.5F, 12.0F, 0.0F);
			lLeg.cubeList.add(new ModelBox(lLeg, 18, 27, -1.5F, 10.0F, -3.0F, 3, 2, 4, 0.0F, false));
			lLeg.cubeList.add(new ModelBox(lLeg, 38, 4, -1.5F, 8.0F, -1.0F, 3, 2, 2, 0.0F, false));
			lLeg.cubeList.add(new ModelBox(lLeg, 12, 38, -1.0F, 1.0F, -0.5F, 2, 11, 1, 0.0F, false));
			footReveal_r1 = new ModelRenderer(this);
			footReveal_r1.setRotationPoint(-0.5F, 11.55F, -1.9F);
			lLeg.addChild(footReveal_r1);
			setRotationAngle(footReveal_r1, 1.5708F, 0.0F, 0.0F);
			footReveal_r1.cubeList.add(new ModelBox(footReveal_r1, 4, 43, -1.0F, -1.0F, 0.0F, 3, 3, 0, 0.0F, false));
			ties_r1 = new ModelRenderer(this);
			ties_r1.setRotationPoint(0.0F, 10.5F, -1.9F);
			lLeg.addChild(ties_r1);
			setRotationAngle(ties_r1, 0.48F, 0.0F, 0.0F);
			ties_r1.cubeList.add(new ModelBox(ties_r1, 14, 30, -1.0F, -2.0F, 1.0F, 2, 2, 0, 0.0F, false));
			rLeg = new ModelRenderer(this);
			rLeg.setRotationPoint(1.5F, 12.0F, 0.0F);
			rLeg.cubeList.add(new ModelBox(rLeg, 0, 30, -1.5F, 10.0F, -3.0F, 3, 2, 4, 0.0F, false));
			rLeg.cubeList.add(new ModelBox(rLeg, 38, 21, -1.5F, 8.0F, -1.0F, 3, 2, 2, 0.0F, false));
			rLeg.cubeList.add(new ModelBox(rLeg, 18, 38, -1.0F, 1.0F, -0.5F, 2, 7, 1, 0.0F, false));
			ties_r2 = new ModelRenderer(this);
			ties_r2.setRotationPoint(0.0F, 10.5F, -1.9F);
			rLeg.addChild(ties_r2);
			setRotationAngle(ties_r2, 0.48F, 0.0F, 0.0F);
			ties_r2.cubeList.add(new ModelBox(ties_r2, 38, 8, -1.0F, -2.0F, 1.0F, 2, 2, 0, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			head.render(f5);
			torso.render(f5);
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
			this.ass.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.lArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.drool.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.rLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.lLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.rArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		}
	}
}
