// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports

public static class Modelinfant extends ModelBase {
	private final ModelRenderer baby;
	private final ModelRenderer head;
	private final ModelRenderer torso;
	private final ModelRenderer arms;
	private final ModelRenderer lArm;
	private final ModelRenderer rArm;
	private final ModelRenderer legs;
	private final ModelRenderer lLeg;
	private final ModelRenderer rLeg;

	public Modelinfant() {
		textureWidth = 64;
		textureHeight = 64;

		baby = new ModelRenderer(this);
		baby.setRotationPoint(0.0F, 24.0F, 0.0F);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		baby.addChild(head);
		head.cubeList.add(new ModelBox(head, 0, 0, -3.0F, -17.0F, -3.0F, 6, 5, 6, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 18, 11, -3.0F, -19.0F, -3.0F, 6, 1, 6, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 24, 0, -4.0F, -18.0F, 1.0F, 8, 3, 3, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 32, -4.0F, -18.0F, -4.0F, 8, 4, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 18, 35, -2.0F, -18.0F, -4.0F, 6, 5, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 37, -3.0F, -18.0F, 3.0F, 6, 5, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 14, 41, 0.0F, -18.0F, 3.0F, 3, 6, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 24, 6, -4.0F, -18.0F, -3.0F, 8, 3, 2, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 34, 27, -4.0F, -18.0F, -1.0F, 8, 2, 2, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 11, 3.0F, -18.0F, -4.0F, 1, 6, 8, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 34, 31, -4.0F, -15.0F, 2.0F, 8, 1, 2, 0.0F, false));

		torso = new ModelRenderer(this);
		torso.setRotationPoint(0.0F, 0.0F, 0.0F);
		baby.addChild(torso);
		torso.cubeList.add(new ModelBox(torso, 0, 25, -3.0F, -10.0F, -2.0F, 5, 3, 4, 0.0F, false));
		torso.cubeList.add(new ModelBox(torso, 34, 34, -2.0F, -12.0F, -2.0F, 4, 2, 4, 0.0F, false));
		torso.cubeList.add(new ModelBox(torso, 18, 18, -2.0F, -7.0F, -3.0F, 4, 3, 6, 0.0F, false));
		torso.cubeList.add(new ModelBox(torso, 18, 27, -1.0F, -5.0F, -3.0F, 2, 2, 6, 0.0F, false));
		torso.cubeList.add(new ModelBox(torso, 38, 18, -2.0F, -4.0F, -1.0F, 4, 1, 2, 0.0F, false));

		arms = new ModelRenderer(this);
		arms.setRotationPoint(0.0F, 0.0F, 0.0F);
		baby.addChild(arms);

		lArm = new ModelRenderer(this);
		lArm.setRotationPoint(0.0F, -12.0F, 0.0F);
		arms.addChild(lArm);
		lArm.cubeList.add(new ModelBox(lArm, 56, 0, 0.0F, 0.0F, -4.0F, 2, 5, 2, 0.0F, false));

		rArm = new ModelRenderer(this);
		rArm.setRotationPoint(1.0F, -12.0F, 0.0F);
		arms.addChild(rArm);
		rArm.cubeList.add(new ModelBox(rArm, 56, 0, -1.0F, 0.0F, 2.0F, 2, 5, 2, 0.0F, false));

		legs = new ModelRenderer(this);
		legs.setRotationPoint(6.0F, 0.0F, 0.0F);
		baby.addChild(legs);

		lLeg = new ModelRenderer(this);
		lLeg.setRotationPoint(1.0F, 0.0F, 1.0F);
		legs.addChild(lLeg);
		setRotationAngle(lLeg, 0.0F, -1.5708F, 0.0F);
		lLeg.cubeList.add(new ModelBox(lLeg, 32, 40, -1.0F, -6.0F, 6.0F, 2, 6, 2, 0.0F, false));
		lLeg.cubeList.add(new ModelBox(lLeg, 6, 43, -1.0F, -1.0F, 8.0F, 2, 1, 1, 0.0F, false));

		rLeg = new ModelRenderer(this);
		rLeg.setRotationPoint(1.0F, 0.0F, -1.0F);
		legs.addChild(rLeg);
		setRotationAngle(rLeg, 0.0F, -1.5708F, 0.0F);
		rLeg.cubeList.add(new ModelBox(rLeg, 40, 40, -1.0F, -6.0F, 6.0F, 2, 6, 2, 0.0F, false));
		rLeg.cubeList.add(new ModelBox(rLeg, 44, 6, -1.0F, -1.0F, 8.0F, 2, 1, 1, 0.0F, false));
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
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.lLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.lArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.rLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.rArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
	}
}