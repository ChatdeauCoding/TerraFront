package com.shadow.terrafront.item;

import com.shadow.terrafront.TerraFrontMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TerraFrontMod.MODID);

    public static final DeferredItem<Item> MYSTICAL_ACORN = ITEMS.register("mystical_acorn",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RHODIUM = ITEMS.register("rhodium",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ARSENIC = ITEMS.register("arsenic",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CHROME = ITEMS.register("chrome",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TIER4_ITEM = ITEMS.register("missile_t4_item",
            () -> new Item(new Item.Properties().stacksTo(1)));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
