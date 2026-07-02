package com.shadow.terrafront.datagen;

import com.shadow.terrafront.TerraFrontMod;
import com.shadow.terrafront.item.ModItems;
import com.shadow.terrafront.loot.AddItemModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, TerraFrontMod.MODID);
    }

    @Override
    protected void start() {

        this.add("mystical_acorn_to_acacia_log",
                new AddItemModifier(new LootItemCondition[]{
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.ACACIA_LOG).build(),
                        LootItemRandomChanceCondition.randomChance(0.0001f).build()
                }, ModItems.MYSTICAL_ACORN.get()));

        this.add("mystical_acorn_to_birch_log",
                new AddItemModifier(new LootItemCondition[]{
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.BIRCH_LOG).build(),
                        LootItemRandomChanceCondition.randomChance(0.0001f).build()
                }, ModItems.MYSTICAL_ACORN.get()));

        this.add("mystical_acorn_to_dark_oak_log",
                new AddItemModifier(new LootItemCondition[]{
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DARK_OAK_LOG).build(),
                        LootItemRandomChanceCondition.randomChance(0.0001f).build()
                }, ModItems.MYSTICAL_ACORN.get()));

        this.add("mystical_acorn_to_spruce_log",
                new AddItemModifier(new LootItemCondition[]{
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.SPRUCE_LOG).build(),
                        LootItemRandomChanceCondition.randomChance(0.0001f).build()
                }, ModItems.MYSTICAL_ACORN.get()));
        this.add("mystical_acorn_to_oak_log",
                new AddItemModifier(new LootItemCondition[]{
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.OAK_LOG).build(),
                        LootItemRandomChanceCondition.randomChance(0.0001f).build()
                }, ModItems.MYSTICAL_ACORN.get()));

        this.add("mystical_acorn_to_cherry_log",
                new AddItemModifier(new LootItemCondition[]{
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.CHERRY_LOG).build(),
                        LootItemRandomChanceCondition.randomChance(0.0001f).build()
                }, ModItems.MYSTICAL_ACORN.get()));
        this.add("mystical_acorn_to_mangrove_log",
                new AddItemModifier(new LootItemCondition[]{
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.MANGROVE_LOG).build(),
                        LootItemRandomChanceCondition.randomChance(0.0001f).build()
                }, ModItems.MYSTICAL_ACORN.get()));

        this.add("mystical_acorn_to_jungle_log",
                new AddItemModifier(new LootItemCondition[]{
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.JUNGLE_LOG).build(),
                        LootItemRandomChanceCondition.randomChance(0.0001f).build()
                }, ModItems.MYSTICAL_ACORN.get()));

        this.add("mystical_acorn_to_crimson_stem",
                new AddItemModifier(new LootItemCondition[]{
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.CRIMSON_STEM).build(),
                        LootItemRandomChanceCondition.randomChance(0.0001f).build()
                }, ModItems.MYSTICAL_ACORN.get()));

        this.add("mystical_acorn_to_warped_stem",
                new AddItemModifier(new LootItemCondition[]{
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.WARPED_STEM).build(),
                        LootItemRandomChanceCondition.randomChance(0.0001f).build()
                }, ModItems.MYSTICAL_ACORN.get()));


    }
}
