package com.shadow.terrafront.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.shadow.terrafront.entity.MissileEntity;
import com.shadow.terrafront.missiles.MissileT4;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class MissileRenderer extends EntityRenderer<MissileEntity> {

    private final MissileT4 model;

    public MissileRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new MissileT4(context.bakeLayer(MissileT4.LAYER_LOCATION));
    }

    @Override
    public ResourceLocation getTextureLocation(MissileEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("terrafront", "textures/entity/missile_t4.png");
    }

    @Override
    public void render(MissileEntity p_entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        poseStack.pushPose();

        // 1. On le centre correctement sur l'entité

        // 2. Comme le modèle Blockbench est dessiné à l'envers ou décalé,
        // on le laisse à 0.0D ou on l'ajuste légèrement s'il s'enfonce dans le sol.
        poseStack.translate(0.0D, 1.5D, 0.0D);
        poseStack.mulPose(Axis.ZP.rotationDegrees(180.0F));

        var texture = this.getTextureLocation(p_entity);
        var vertexConsumer = bufferSource.getBuffer(this.model.renderType(texture));

        // Le dernier paramètre (-1 ou Color.WHITE) gère la teinte. On passe 1.0F partout pour la couleur normale.
        this.model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, -1);

        poseStack.popPose();
        super.render(p_entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
