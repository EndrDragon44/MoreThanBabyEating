// Made with Blockbench 5.1.3
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports

public static class ModelafricanVillager extends ModelBase {
	private final ModelRenderer head;
	private final ModelRenderer neck_r1;
	private final ModelRenderer head_r1;
	private final ModelRenderer head_r2;
	private final ModelRenderer head_r3;
	private final ModelRenderer head_r4;
	private final ModelRenderer arms;
	private final ModelRenderer RightLeg;
	private final ModelRenderer body;
	private final ModelRenderer LeftLeg;

	public ModelafricanVillager() {
		textureWidth = 128;
		textureHeight = 128;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, -0.25F);
		head.cubeList.add(new ModelBox(head, 25, 14, -4.0F, -10.0F, -3.25F, 8, 6, 4, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 50, 7, -2.0F, -4.0F, -3.25F, 4, 3, 4, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 51, 23, -0.5F, -4.0F, -4.35F, 1, 3, 1, 0.0F, false));

		neck_r1 = new ModelRenderer(this);
		neck_r1.setRotationPoint(2.0F, -1.0F, 0.0F);
		head.addChild(neck_r1);
		setRotationAngle(neck_r1, 0.0F, 0.0F, -1.5708F);
		neck_r1.cubeList.add(new ModelBox(neck_r1, 50, 29, -2.0F, -3.0F, -1.0F, 4, 2, 2, 0.0F, false));

		head_r1 = new ModelRenderer(this);
		head_r1.setRotationPoint(0.0F, -3.0F, -0.25F);
		head.addChild(head_r1);
		setRotationAngle(head_r1, 0.0F, -0.7854F, 0.0F);
		head_r1.cubeList.add(new ModelBox(head_r1, 34, 47, -2.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F, false));

		head_r2 = new ModelRenderer(this);
		head_r2.setRotationPoint(0.0F, -4.0F, -0.25F);
		head.addChild(head_r2);
		setRotationAngle(head_r2, 0.0F, 0.0F, -0.7854F);
		head_r2.cubeList.add(new ModelBox(head_r2, 0, 46, -2.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F, false));

		head_r3 = new ModelRenderer(this);
		head_r3.setRotationPoint(0.0F, -7.8F, 3.15F);
		head.addChild(head_r3);
		setRotationAngle(head_r3, -2.0071F, 0.0F, 0.0F);
		head_r3.cubeList.add(new ModelBox(head_r3, 1, 15, -4.0F, -0.7873F, -1.0314F, 8, 4, 3, 0.0F, false));

		head_r4 = new ModelRenderer(this);
		head_r4.setRotationPoint(0.0F, -5.9F, 1.75F);
		head.addChild(head_r4);
		setRotationAngle(head_r4, -0.1745F, 0.0F, 0.0F);
		head_r4.cubeList.add(new ModelBox(head_r4, 2, 16, -4.0F, -3.0F, 0.0F, 8, 7, 2, 0.0F, false));

		arms = new ModelRenderer(this);
		arms.setRotationPoint(0.0F, 2.0F, 0.0F);
		setRotationAngle(arms, -0.7854F, 0.0F, 0.0F);
		arms.cubeList.add(new ModelBox(arms, 25, 25, -4.0F, 2.0F, -2.0F, 8, 4, 4, 0.0F, false));
		arms.cubeList.add(new ModelBox(arms, 29, 0, -8.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F, false));
		arms.cubeList.add(new ModelBox(arms, 34, 34, 4.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F, false));

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-2.0F, 12.0F, 0.0F);
		RightLeg.cubeList.add(new ModelBox(RightLeg, 0, 29, -2.0F, 0.0F, -1.4F, 4, 12, 4, 0.0F, false));

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 0, 0, -4.0F, -24.0F, -3.0F, 8, 7, 6, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 50, 15, -2.0F, -15.0F, -1.0F, 4, 3, 3, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 46, 0, -3.0F, -17.0F, -1.5F, 6, 2, 4, 0.0F, false));

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(2.0F, 12.0F, 0.0F);
		LeftLeg.cubeList.add(new ModelBox(LeftLeg, 17, 34, -2.0F, 0.0F, -1.4F, 4, 12, 4, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		head.render(f5);
		arms.render(f5);
		RightLeg.render(f5);
		body.render(f5);
		LeftLeg.render(f5);
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
		this.LeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.RightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}