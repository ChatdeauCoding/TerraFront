package com.shadow.terrafront.entity;

import com.shadow.terrafront.missiles.MissileT4;
import com.shadow.terrafront.renderer.MissileRenderer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@EventBusSubscriber(modid = "terrafront")
public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, "terrafront");


    public static final DeferredHolder<EntityType<?>, EntityType<MissileEntity>> MISSILE =
            ENTITIES.register("missile", () -> EntityType.Builder.of(MissileEntity::new, MobCategory.MISC)
                    .sized(0.5F, 2.0F) // Sa hitbox (largeur, hauteur)
                    .build("missile"));

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        // Tu dis au jeu : pour cette entité, utilise ce renderer
        event.registerEntityRenderer(MISSILE.get(), MissileRenderer::new);
    }

    @SubscribeEvent
    public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        // On dit à Minecraft : "Hé, pour fabriquer le modèle MissileT4, utilise les cubes qu'on a définis dans sa méthode createLayerBody()"
        event.registerLayerDefinition(MissileT4.LAYER_LOCATION, MissileT4::createBodyLayer);
    }
}
