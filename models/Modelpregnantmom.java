// Made with Blockbench 5.1.3
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports

public static class Modelpregnantmom extends ModelBase {
	private final ModelRenderer legs;
	private final ModelRenderer lLeg;
	private final ModelRenderer rLeg;
	private final ModelRenderer arms;
	private final ModelRenderer rArm;
	private final ModelRenderer lArm;
	private final ModelRenderer torso;
	private final ModelRenderer cube_r1;
	private final ModelRenderer head;

	public Modelpregnantmom() {
		textureWidth = 64;
		textureHeight = 64;

		legs = new ModelRenderer(this);
		legs.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(legs, -3.1416F, 0.0F, 3.1416F);

		lLeg = new ModelRenderer(this);
		lLeg.setRotationPoint(0.0F, -11.0F, 2.0F);
		legs.addChild(lLeg);
		lLeg.cubeList.add(new ModelBox(lLeg, 26, 26, -2.0F, 0.0F, -1.5F, 2, 9, 2, 0.0F, false));
		lLeg.cubeList.add(new ModelBox(lLeg, 22, 30, -2.0F, 9.0F, -1.5F, 2, 2, 3, 0.0F, false));

		rLeg = new ModelRenderer(this);
		rLeg.setRotationPoint(0.0F, -11.0F, 2.0F);
		legs.addChild(rLeg);
		rLeg.cubeList.add(new ModelBox(rLeg, 21, 30, 0.0F, 9.0F, -1.5F, 2, 2, 3, 0.0F, false));
		rLeg.cubeList.add(new ModelBox(rLeg, 18, 26, 0.0F, 0.0F, -1.5F, 2, 9, 2, 0.0F, false));

		arms = new ModelRenderer(this);
		arms.setRotationPoint(0.0F, 20.0F, 0.0F);
		setRotationAngle(arms, -3.1416F, 0.0F, 3.1416F);

		rArm = new ModelRenderer(this);
		rArm.setRotationPoint(2.0F, -16.0F, 1.0F);
		arms.addChild(rArm);
		rArm.cubeList.add(new ModelBox(rArm, 0, 29, 0.0F, -1.0F, -0.5F, 2, 6, 2, 0.0F, false));

		lArm = new ModelRenderer(this);
		lArm.setRotationPoint(-2.0F, -16.0F, 1.0F);
		arms.addChild(lArm);
		lArm.cubeList.add(new ModelBox(lArm, 8, 29, -2.0F, -1.0F, -0.5F, 2, 6, 2, 0.0F, false));

		torso = new ModelRenderer(this);
		torso.setRotationPoint(0.0F, 10.0F, 0.0F);
		setRotationAngle(torso, -3.1416F, 0.0F, 3.1416F);
		torso.cubeList.add(new ModelBox(torso, 0, 40, -3.0F, 1.0F, -2.5F, 6, 2, 8, 0.0F, false));
		torso.cubeList.add(new ModelBox(torso, 0, 8, -2.0F, -3.0F, -2.0F, 4, 5, 6, 0.0F, false));
		torso.cubeList.add(new ModelBox(torso, 0, 8, -2.0F, -3.0F, -1.0F, 4, 5, 6, 0.0F, false));
		torso.cubeList.add(new ModelBox(torso, 1, 9, -2.0F, -7.0F, -1.75F, 4, 4, 5, 0.0F, false));

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, -2.7F, 3.0F);
		torso.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.7854F, 0.0F, 0.0F);
		cube_r1.cubeList.add(new ModelBox(cube_r1, 3, 11, -2.0F, -3.0F, -3.0F, 4, 3, 3, 0.0F, false));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 3.0F, -1.25F);
		setRotationAngle(head, 0.0F, 0.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 24, 0, -2.0F, -4.0F, -2.0F, 4, 4, 4, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 18, -2.0F, -7.0F, -1.0F, 4, 6, 5, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 20, 8, -3.0F, -5.0F, -0.9F, 6, 4, 3, 0.0F, false));
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
		this.rLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.rArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
	}
}