// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports

public static class Modelpedo extends ModelBase {
	private final ModelRenderer rLeg;
	private final ModelRenderer lLeg;
	private final ModelRenderer torso;
	private final ModelRenderer larm;
	private final ModelRenderer rArm;
	private final ModelRenderer head;

	public Modelpedo() {
		textureWidth = 32;
		textureHeight = 32;

		rLeg = new ModelRenderer(this);
		rLeg.setRotationPoint(1.0F, 14.0F, 1.0F);
		rLeg.cubeList.add(new ModelBox(rLeg, 13, 13, -1.0F, 0.0F, -1.0F, 2, 9, 1, 0.0F, false));
		rLeg.cubeList.add(new ModelBox(rLeg, 20, 13, -1.0F, 9.0F, -1.0F, 2, 1, 3, 0.0F, false));

		lLeg = new ModelRenderer(this);
		lLeg.setRotationPoint(-1.0F, 14.0F, 0.0F);
		lLeg.cubeList.add(new ModelBox(lLeg, 20, 18, -1.0F, 9.0F, 0.0F, 2, 1, 3, 0.0F, false));
		lLeg.cubeList.add(new ModelBox(lLeg, 0, 17, -1.0F, 0.0F, 0.0F, 2, 9, 1, 0.0F, false));

		torso = new ModelRenderer(this);
		torso.setRotationPoint(0.0F, 17.0F, 1.0F);
		torso.cubeList.add(new ModelBox(torso, 0, 0, -2.0F, -9.0F, -2.0F, 4, 6, 2, 0.0F, false));
		torso.cubeList.add(new ModelBox(torso, 0, 10, -2.0F, -7.0F, 0.0F, 4, 4, 2, 0.0F, false));
		torso.cubeList.add(new ModelBox(torso, 12, 24, -1.0F, -3.8F, 0.0F, 2, 1, 1, 0.0F, false));

		larm = new ModelRenderer(this);
		larm.setRotationPoint(-2.0F, 9.0F, 0.0F);
		larm.cubeList.add(new ModelBox(larm, 7, 17, -1.0F, -1.0F, -0.5F, 1, 8, 1, 0.0F, false));

		rArm = new ModelRenderer(this);
		rArm.setRotationPoint(2.0F, 9.0F, 0.0F);
		rArm.cubeList.add(new ModelBox(rArm, 20, 23, 0.0F, -1.0F, -0.5F, 1, 8, 1, 0.0F, false));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 8.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 13, 0, -2.0F, -4.4F, -1.2F, 4, 4, 2, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 13, 7, -1.0F, -3.0F, 0.8F, 2, 1, 4, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 25, 23, -1.0F, -1.0F, -0.8F, 2, 1, 1, 0.0F, false));
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
		this.lLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.larm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.rLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.rArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
	}
}