package com.shadow.terrafront.block;

import com.mojang.serialization.MapCodec;
import com.shadow.terrafront.entity.MissileEntity;
import com.shadow.terrafront.entity.ModEntities;
import com.shadow.terrafront.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MissileLauncherBlock extends BaseEntityBlock {
    public static final MapCodec<MissileLauncherBlock> CODEC = simpleCodec(MissileLauncherBlock::new);

    public MissileLauncherBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL; // Permet de voir le modèle JSON ou de texture du bloc
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        // Associe le bloc à son "cerveau" BlockEntity
        return new MissileLauncherBlockEntity(pos, state);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (!level.isClientSide) {
            // On vérifie ce que le joueur a dans sa main principale (Main Droite)
            ItemStack itemInHand = player.getItemInHand(InteractionHand.MAIN_HAND);

            // 1. Est-ce que le joueur tient le missile T4 ?
            if (itemInHand.is(ModItems.TIER4_ITEM.get())) {

                if (level.getBlockEntity(pos) instanceof MissileLauncherBlockEntity) {
                    BlockPos spawnPos = pos.above();

                    // On fait spawner le missile 3D
                    MissileEntity missile = new MissileEntity(ModEntities.MISSILE.get(), level);
                    missile.moveTo(spawnPos.getX() + 0.5D, spawnPos.getY(), spawnPos.getZ() + 0.5D, 0.0F, 0.0F);
                    level.addFreshEntity(missile);

                    // On consomme le missile de la main du joueur (sauf s'il est en créatif)
                    if (!player.isCreative()) {
                        itemInHand.shrink(1);
                    }

                    player.sendSystemMessage(Component.literal("🚀 Missile Tier 4 chargé avec succès !"));
                    return InteractionResult.SUCCESS;
                }

            } else {
                // 2. Le joueur a cliqué les mains vides ou avec un autre objet
                player.sendSystemMessage(Component.literal("❌ Vous devez tenir un Missile dans votre main pour charger la plateforme !"));
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        // Si le bloc change complètement de type (par exemple, s'il est détruit)
        if (!state.is(newState.getBlock())) {
            if (!level.isClientSide) {

                // 1. On définit une zone de recherche (la boîte de collision) 1 bloc au-dessus
                BlockPos abovePos = pos.above();
                AABB searchBox = new AABB(abovePos);

                // 2. On cherche toutes les entités de type MissileEntity dans cette zone
                List<MissileEntity> missiles = level.getEntitiesOfClass(MissileEntity.class, searchBox);

                for (MissileEntity missile : missiles) {
                    // 3. On fait drop l'item du missile au sol à l'endroit de l'entité
                    ItemStack dropStack = new ItemStack(ModItems.TIER4_ITEM.get());
                    ItemEntity itemEntity = new ItemEntity(level, missile.getX(), missile.getY(), missile.getZ(), dropStack);
                    level.addFreshEntity(itemEntity);

                    // 4. On supprime le missile 3D du monde
                    missile.discard();
                }
            }

            // Très important : appelle la logique de base (qui détruit aussi la BlockEntity proprement)
            super.onRemove(state, level, pos, newState, isMoving);
        }
    }
}