package net.allthemods.allthemodium.data.provider.loot;

import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

import net.allthemods.allthemodium.core.registry.ATMEntities;
import net.allthemods.allthemodium.core.registry.ATMItems;

public class ATMEntityLoot extends EntityLootSubProvider {
    
    public ATMEntityLoot(LootTableSubProvider.Context output) {
        super(FeatureFlags.DEFAULT_FLAGS, FeatureFlagSet.of(), output);
    }
    
    @Override
    public void generate() {
        this.add(
                ATMEntities.PIGLICH.get(),
                LootTable.lootTable().withPool(
                        LootPool.lootPool()
                                .setRolls(ContextIntProviders.exactly(1))
                                .add(LootItem.lootTableItem(ATMItems.PIGLICH_HEART.get())
                                        .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)))
                                )
                )
        );
    }
}
