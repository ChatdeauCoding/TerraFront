package com.shadow.terrafront.datagen;

import com.shadow.terrafront.TerraFrontMod;
import com.shadow.terrafront.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TerraFrontMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.MYSTICAL_ACORN.get());
        basicItem(ModItems.RHODIUM.get());
        basicItem(ModItems.ARSENIC.get());
        basicItem(ModItems.CHROME.get());
        basicItem(ModItems.TIER4_ITEM.get());
    }
}
