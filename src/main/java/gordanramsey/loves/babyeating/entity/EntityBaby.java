
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
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIEatGrass;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;

import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;
import java.util.ArrayList;

import gordanramsey.loves.babyeating.procedure.ProcedureBabyEntityDies;
import gordanramsey.loves.babyeating.item.ItemUncookedBaby;
import gordanramsey.loves.babyeating.ElementsBabyeatingMod;

@ElementsBabyeatingMod.ModElement.Tag
public class EntityBaby extends ElementsBabyeatingMod.ModElement {
	public static final int ENTITYID = 1;
	public static final int ENTITYID_RANGED = 2;
	public EntityBaby(ElementsBabyeatingMod instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("babyeating", "baby"), ENTITYID)
				.name("baby").tracker(64, 3, true).egg(-1, -10053121).build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = allbiomes(Biome.REGISTRY);
		EntityRegistry.addSpawn(EntityCustom.class, 1, 1, 1, EnumCreatureType.CREATURE, spawnBiomes);
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
			return new RenderLiving(renderManager, new Modelinfant(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("babyeating:textures/infant.png");
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
			this.tasks.addTask(1, new EntityAIWanderAvoidWater(this, 1));
			this.tasks.addTask(2, new EntityAIEatGrass(this));
			this.tasks.addTask(3, new EntityAISwimming(this));
			this.tasks.addTask(4, new EntityAILookIdle(this));
			this.tasks.addTask(5, new EntityAIPanic(this, 2.8));
			this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPregnantMom.EntityCustom.class, (float) 18));
			this.tasks.addTask(7, new EntityAIMoveIndoors(this));
			this.tasks.addTask(8, new EntityAIBreakDoor(this));
			this.tasks.addTask(9, new EntityAITempt(this, 1, new ItemStack(Items.MILK_BUCKET, (int) (1)).getItem(), false));
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.ILLAGER;
		}

		@Override
		protected Item getDropItem() {
			return new ItemStack(ItemUncookedBaby.block, (int) (1)).getItem();
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY
					.getObject(new ResourceLocation("babyeating:happybabysounds"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("babyeating:babycry"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("babyeating:babydeath"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
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
				ProcedureBabyEntityDies.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.1D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0D);
		}
	}

	// Made with Blockbench 5.1.3
	// Exported for Minecraft version 1.7 - 1.12
	// Paste this class into your mod and generate all required imports
	public static class Modelinfant extends ModelBase {
		private final ModelRenderer baby;
		private final ModelRenderer head;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer torso;
		private final ModelRenderer cube_r3;
		private final ModelRenderer cube_r4;
		private final ModelRenderer cube_r5;
		private final ModelRenderer cube_r6;
		private final ModelRenderer arms;
		private final ModelRenderer lArm;
		private final ModelRenderer cube_r7;
		private final ModelRenderer rArm;
		private final ModelRenderer cube_r8;
		private final ModelRenderer legs;
		private final ModelRenderer lLeg;
		private final ModelRenderer toe_r1;
		private final ModelRenderer rLeg;
		private final ModelRenderer toe_r2;
		public Modelinfant() {
			textureWidth = 64;
			textureHeight = 64;
			baby = new ModelRenderer(this);
			baby.setRotationPoint(0.0F, 24.0F, 0.0F);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 0.0F, 0.0F);
			baby.addChild(head);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, -18.0F, 0.0F);
			head.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.0F, -1.5708F, 0.0F);
			cube_r1.cubeList.add(new ModelBox(cube_r1, 34, 31, -4.0F, 3.0F, 2.0F, 8, 1, 2, 0.0F, false));
			cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 11, 3.0F, 0.0F, -4.0F, 1, 6, 8, 0.0F, false));
			cube_r1.cubeList.add(new ModelBox(cube_r1, 34, 27, -4.0F, 0.0F, -1.0F, 8, 2, 2, 0.0F, false));
			cube_r1.cubeList.add(new ModelBox(cube_r1, 24, 6, -4.0F, 0.0F, -3.0F, 8, 3, 2, 0.0F, false));
			cube_r1.cubeList.add(new ModelBox(cube_r1, 14, 41, 0.0F, 0.0F, 3.0F, 3, 6, 1, 0.0F, false));
			cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 37, -3.0F, 0.0F, 3.0F, 6, 5, 1, 0.0F, false));
			cube_r1.cubeList.add(new ModelBox(cube_r1, 18, 35, -2.0F, 0.0F, -4.0F, 6, 5, 1, 0.0F, false));
			cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 32, -4.0F, 0.0F, -4.0F, 8, 4, 1, 0.0F, false));
			cube_r1.cubeList.add(new ModelBox(cube_r1, 24, 0, -4.0F, 0.0F, 1.0F, 8, 3, 3, 0.0F, false));
			cube_r1.cubeList.add(new ModelBox(cube_r1, 18, 11, -3.0F, -1.0F, -3.0F, 6, 1, 6, 0.0F, false));
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.0F, -12.0F, 0.0F);
			head.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.0F, -1.5708F, 0.0F);
			cube_r2.cubeList.add(new ModelBox(cube_r2, 0, 0, -3.0F, -5.0F, -3.0F, 6, 5, 6, 0.0F, false));
			torso = new ModelRenderer(this);
			torso.setRotationPoint(0.0F, 0.0F, 0.0F);
			baby.addChild(torso);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(0.0F, -3.0F, 0.0F);
			torso.addChild(cube_r3);
			setRotationAngle(cube_r3, -3.1416F, -1.5708F, 3.1416F);
			cube_r3.cubeList.add(new ModelBox(cube_r3, 38, 18, -2.0F, -1.0F, -1.0F, 4, 1, 2, 0.0F, false));
			cube_r3.cubeList.add(new ModelBox(cube_r3, 18, 27, -1.0F, -2.0F, -3.0F, 2, 2, 6, 0.0F, false));
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(0.0F, -4.0F, 0.0F);
			torso.addChild(cube_r4);
			setRotationAngle(cube_r4, -3.1416F, -1.5708F, 3.1416F);
			cube_r4.cubeList.add(new ModelBox(cube_r4, 18, 18, -2.0F, -3.0F, -3.0F, 4, 3, 6, 0.0F, false));
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(0.0F, -10.0F, 0.0F);
			torso.addChild(cube_r5);
			setRotationAngle(cube_r5, 0.0F, -1.5708F, 0.0F);
			cube_r5.cubeList.add(new ModelBox(cube_r5, 34, 34, -2.0F, -2.0F, -2.0F, 4, 2, 4, 0.0F, false));
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(0.0F, -8.0F, 0.0F);
			torso.addChild(cube_r6);
			setRotationAngle(cube_r6, 0.0F, -1.5708F, 0.0F);
			cube_r6.cubeList.add(new ModelBox(cube_r6, 0, 25, -3.0F, -2.0F, -2.0F, 5, 3, 4, 0.0F, false));
			arms = new ModelRenderer(this);
			arms.setRotationPoint(0.0F, 0.0F, 0.0F);
			baby.addChild(arms);
			lArm = new ModelRenderer(this);
			lArm.setRotationPoint(0.0F, -11.0F, -3.0F);
			arms.addChild(lArm);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(0.0F, 1.0F, 3.0F);
			lArm.addChild(cube_r7);
			setRotationAngle(cube_r7, 0.0F, -1.5708F, 0.0F);
			cube_r7.cubeList.add(new ModelBox(cube_r7, 56, 0, -1.0F, -2.0F, -4.0F, 2, 5, 2, 0.0F, false));
			rArm = new ModelRenderer(this);
			rArm.setRotationPoint(1.0F, -11.0F, 3.0F);
			arms.addChild(rArm);
			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(-1.0F, 1.0F, -3.0F);
			rArm.addChild(cube_r8);
			setRotationAngle(cube_r8, 0.0F, -1.5708F, 0.0F);
			cube_r8.cubeList.add(new ModelBox(cube_r8, 56, 0, -1.0F, -2.0F, 2.0F, 2, 5, 2, 0.0F, false));
			legs = new ModelRenderer(this);
			legs.setRotationPoint(6.0F, 0.0F, 0.0F);
			baby.addChild(legs);
			lLeg = new ModelRenderer(this);
			lLeg.setRotationPoint(1.0F, 0.0F, 1.0F);
			legs.addChild(lLeg);
			setRotationAngle(lLeg, 0.0F, -1.5708F, 0.0F);
			toe_r1 = new ModelRenderer(this);
			toe_r1.setRotationPoint(-1.0F, 0.0F, 7.0F);
			lLeg.addChild(toe_r1);
			setRotationAngle(toe_r1, 0.0F, -1.5708F, 0.0F);
			toe_r1.cubeList.add(new ModelBox(toe_r1, 6, 43, -2.0F, -1.0F, 1.0F, 2, 1, 1, 0.0F, false));
			toe_r1.cubeList.add(new ModelBox(toe_r1, 32, 40, -2.0F, -6.0F, -1.0F, 2, 6, 2, 0.0F, false));
			rLeg = new ModelRenderer(this);
			rLeg.setRotationPoint(1.0F, -4.0F, -1.0F);
			legs.addChild(rLeg);
			setRotationAngle(rLeg, 0.0F, -1.5708F, 0.0F);
			toe_r2 = new ModelRenderer(this);
			toe_r2.setRotationPoint(-1.0F, 4.0F, 9.0F);
			rLeg.addChild(toe_r2);
			setRotationAngle(toe_r2, 0.0F, -1.5708F, 0.0F);
			toe_r2.cubeList.add(new ModelBox(toe_r2, 44, 6, -2.0F, -1.0F, -1.0F, 2, 1, 1, 0.0F, false));
			toe_r2.cubeList.add(new ModelBox(toe_r2, 40, 40, -2.0F, -6.0F, -3.0F, 2, 6, 2, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			baby.render(f5);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
			super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
			this.lArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.rLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.lLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.rArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		}
	}
}
