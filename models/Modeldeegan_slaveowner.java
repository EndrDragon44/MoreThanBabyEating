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