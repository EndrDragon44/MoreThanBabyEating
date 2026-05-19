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