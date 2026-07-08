package com.shadow.terrafront.missiles;// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class MissileT4<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("terrafront", "missiletier4"), "main");	private final ModelPart bb_main;

	public MissileT4(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -24.0F, -5.0F, 10.0F, 24.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(56, 33).addBox(-8.0F, -16.0F, 6.0F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(56, 51).addBox(-8.0F, -16.0F, -8.0F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(64, 10).addBox(6.0F, -16.0F, -8.0F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(64, 28).addBox(6.0F, -16.0F, 6.0F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(24, 49).addBox(4.0F, -20.0F, 4.0F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(32, 49).addBox(-6.0F, -20.0F, 4.0F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(40, 49).addBox(-6.0F, -20.0F, -6.0F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(48, 49).addBox(4.0F, -20.0F, -6.0F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 34).addBox(-3.0F, -54.0F, -3.0F, 6.0F, 30.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(40, 0).addBox(-4.0F, -56.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(24, 34).addBox(-4.0F, -51.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(40, 10).addBox(-3.0F, -58.0F, -3.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(64, 46).addBox(-2.0F, -61.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(18, 71).addBox(-1.0F, -64.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(64, 60).addBox(-2.0F, -65.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(64, 54).addBox(-2.0F, -67.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(56, 69).addBox(-5.0F, -60.0F, -1.0F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(34, 71).addBox(-4.0F, -63.0F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(68, 71).addBox(-3.0F, -65.0F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(26, 71).addBox(-1.0F, -70.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = bb_main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(12, 70).addBox(-5.0F, 1.0F, -2.0F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(46, 71).addBox(-4.0F, -2.0F, -2.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(72, 10).addBox(-3.0F, -4.0F, -2.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -61.0F, -1.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r2 = bb_main.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(72, 5).addBox(-2.0F, -4.0F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(6, 70).addBox(-4.0F, 1.0F, -1.0F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -61.0F, -1.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r3 = bb_main.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(62, 71).addBox(-4.0F, -2.0F, 0.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -61.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r4 = bb_main.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 70).addBox(-1.0F, 1.0F, -1.0F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(40, 71).addBox(0.0F, -2.0F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(72, 0).addBox(1.0F, -4.0F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -61.0F, 4.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r5 = bb_main.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(64, 65).addBox(-4.0F, -6.0F, -2.0F, 5.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, -46.0F, 1.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition cube_r6 = bb_main.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(40, 26).addBox(-4.0F, -6.0F, -2.0F, 8.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -46.0F, 0.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition cube_r7 = bb_main.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(40, 19).addBox(-4.0F, -6.0F, -2.0F, 8.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -43.0F, 0.0F, 0.0F, 0.0F, 1.5708F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
		bb_main.render(poseStack, buffer, packedLight, packedOverlay, color);
	}
}