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