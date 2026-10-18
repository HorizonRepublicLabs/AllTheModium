package net.allthemods.allthemodium.data;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.data.event.GatherDataRegistryEntriesEvent;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.core.registries.Registries;

import net.allthemods.allthemodium.api.ATM;
import net.allthemods.allthemodium.data.provider.ATMDataMapProvider;
import net.allthemods.allthemodium.data.provider.ATMEnchantments;
import net.allthemods.allthemodium.data.provider.ATMEquipmentAssetProvider;
import net.allthemods.allthemodium.data.provider.ATMLanguageProvider;
import net.allthemods.allthemodium.data.provider.ATMMaterialsProvider;
import net.allthemods.allthemodium.data.provider.ATMModelProvider;
import net.allthemods.allthemodium.data.provider.ATMRecipeProvider;
import net.allthemods.allthemodium.data.provider.loot.ATMBlockLoot;
import net.allthemods.allthemodium.data.provider.loot.ATMChestLoot;
import net.allthemods.allthemodium.data.provider.loot.ATMEntityLoot;
import net.allthemods.allthemodium.data.provider.tags.ATMBiomeTagsProvider;
import net.allthemods.allthemodium.data.provider.tags.ATMBlockTagsProvider;
import net.allthemods.allthemodium.data.provider.tags.ATMItemTagsProvider;
import net.allthemods.allthemodium.data.worldgen.ATMBiomeModifier;
import net.allthemods.allthemodium.data.worldgen.ATMBiomes;
import net.allthemods.allthemodium.data.worldgen.ATMConfiguredFeatures;
import net.allthemods.allthemodium.data.worldgen.ATMDimensions;
import net.allthemods.allthemodium.data.worldgen.ATMPlacedFeatures;
import net.allthemods.allthemodium.data.worldgen.ATMStructureSets;
import net.allthemods.allthemodium.data.worldgen.ATMStructures;
import net.allthemods.allthemodium.data.worldgen.ATMTemplatePools;

@EventBusSubscriber(modid = ATM.MOD_ID)
public class ATMDataGenerator {
    
    @SubscribeEvent
    public static void gatherRegistries(final GatherDataRegistryEntriesEvent event) {
        event.gatherFor(ATM.MOD_ID)
                .add(Registries.ENCHANTMENT, ATMEnchantments::bootstrap)
                .add(Registries.DIMENSION_TYPE, ATMDimensions::bootstrap)
                .add(Registries.BIOME, ATMBiomes::bootstrap)
                .add(Registries.FEATURE, ATMConfiguredFeatures::bootstrap)
                .add(Registries.PLACED_FEATURE, ATMPlacedFeatures::bootstrap)
                .add(Registries.TEMPLATE_POOL, ATMTemplatePools::bootstrap)
                .add(Registries.STRUCTURE, ATMStructures::bootstrap)
                .add(Registries.STRUCTURE_SET, ATMStructureSets::bootstrap)
                .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ATMBiomeModifier::bootstrap)
                .recipe(ATMRecipeProvider::new)
                .lootTable(
                        new LootTableProvider.SubProviderEntry(ATMChestLoot::new, LootContextParamSets.CHEST),
                        new LootTableProvider.SubProviderEntry(ATMEntityLoot::new, LootContextParamSets.ENTITY),
                        new LootTableProvider.SubProviderEntry(ATMBlockLoot::new, LootContextParamSets.BLOCK)
                );
    }
    
    @SubscribeEvent
    public static void gatherClientData(final GatherDataEvent.Client event) {
        if (!ATM.MOD_ID.equalsIgnoreCase(event.getModContainer().getModId())) return;
        
        event.createProvider(ATMModelProvider::new);
        event.createProvider(ATMEquipmentAssetProvider::new);
        event.createProvider(ATMLanguageProvider::new);
        event.createProvider(ATMBiomeTagsProvider::new);
        event.createProvider(ATMBlockTagsProvider::new);
        event.createProvider(ATMItemTagsProvider::new);
        event.createProvider(ATMDataMapProvider::new);

        if (ModList.get().isLoaded("silentgear")) ATMMaterialsProvider.register(event);
    }
}
