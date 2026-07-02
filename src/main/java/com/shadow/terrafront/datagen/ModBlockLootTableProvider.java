package com.shadow.terrafront.datagen;

import com.shadow.terrafront.block.ModBlocks;
import com.shadow.terrafront.item.ModItems;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.InvertedLootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.List;
import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        LootItemCondition.Builder hasSilkTouch = MatchTool.toolMatches(
                ItemPredicate.Builder.item().withSubPredicate(
                        ItemSubPredicates.ENCHANTMENTS,
                        ItemEnchantmentsPredicate.enchantments(
                                List.of(new EnchantmentPredicate(
                                        this.registries.lookupOrThrow(Registries.ENCHANTMENT)
                                                .getOrThrow(Enchantments.SILK_TOUCH),
                                        MinMaxBounds.Ints.atLeast(1)
                                ))
                        )
                )
        );

        add(ModBlocks.DARK_ORE.get(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .when(hasSilkTouch)
                                .add(LootItem.lootTableItem(ModBlocks.DARK_ORE.get()))
                        )
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .when(InvertedLootItemCondition.invert(hasSilkTouch))
                                .add(LootItem.lootTableItem(ModItems.RHODIUM.get()).setWeight(40))
                                .add(LootItem.lootTableItem(ModItems.ARSENIC.get()).setWeight(40))
                                .add(LootItem.lootTableItem(ModItems.CHROME.get()).setWeight(20))
                        )
        );
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
