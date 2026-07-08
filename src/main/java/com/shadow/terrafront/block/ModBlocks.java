package com.shadow.terrafront.block;

import com.shadow.terrafront.TerraFrontMod;
import com.shadow.terrafront.item.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(TerraFrontMod.MODID);

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, "terrafront");


    public static final DeferredBlock<Block> DARK_ORE = registerBlock("dark_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE).explosionResistance(3.0f)));

    public static final DeferredBlock<Block> LAUNCHER_PLATFORM = registerBlock("launcher_platform",
            () -> new MissileLauncherBlock(BlockBehaviour.Properties.of()
                    .sound(SoundType.WOOL)
                    .strength(3.0f)));



    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block ){
        DeferredBlock<T> deferredBlock = BLOCKS.register(name, block);
        registerBlockItem(name, deferredBlock);
        return deferredBlock;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));

    }
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MissileLauncherBlockEntity>> LAUNCHER_BE_TYPE =
            BLOCK_ENTITIES.register("launcher_platform", () ->
                    BlockEntityType.Builder.of(MissileLauncherBlockEntity::new, LAUNCHER_PLATFORM.get()).build(null));

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
