package com.shadow.terrafront.item;

import com.shadow.terrafront.TerraFrontMod;
import com.shadow.terrafront.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TerraFrontMod.MODID);

    public static final Supplier<CreativeModeTab> TERRAFRONT_RARE_ITEMS = CREATIVE_MODE_TAB.register("terrafront_rare_items",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MYSTICAL_ACORN.get()))
                    .title(Component.translatable("creativetab.terrafront.rare_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.MYSTICAL_ACORN.get());
                        output.accept(ModBlocks.DARK_ORE.get());
                        output.accept(ModItems.RHODIUM.get());
                        output.accept(ModItems.ARSENIC.get());
                        output.accept(ModItems.CHROME.get());
                    }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
