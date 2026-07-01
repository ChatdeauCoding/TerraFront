package com.shadow.terrafront.block;

import com.shadow.terrafront.TerraFrontMod;
import com.shadow.terrafront.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(TerraFrontMod.MODID);


    public static final DeferredBlock<Block> DARK_ORE = registerBlock("dark_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE).explosionResistance(3.0f)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block ){
        DeferredBlock<T> deferredBlock = BLOCKS.register(name, block);
        registerBlockItem(name, deferredBlock);
        return deferredBlock;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
