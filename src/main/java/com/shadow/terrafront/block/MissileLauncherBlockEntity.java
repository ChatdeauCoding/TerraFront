package com.shadow.terrafront.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class MissileLauncherBlockEntity extends BlockEntity {

    private BlockPos targetPos = BlockPos.ZERO;

    public MissileLauncherBlockEntity(BlockPos pos, BlockState state) {
        // En passant par le registre directement, on évite le crash si le .get() est appelé trop tôt
        super(ModBlocks.LAUNCHER_BE_TYPE.get(), pos, state);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.putInt("targetPosX", targetPos.getX());
        tag.putInt("targetPosY", targetPos.getY());
        tag.putInt("targetPosZ", targetPos.getZ());
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        int x = tag.getInt("targetPosX");
        int y = tag.getInt("targetPosY");
        int z = tag.getInt("targetPosZ");
        this.targetPos = new BlockPos(x, y, z);
    }

    public BlockPos getTargetPos() {
        return this.targetPos;
    }

    public void setTargetPos(BlockPos pos) {
        this.targetPos = pos;
        this.setChanged();
    }

}
