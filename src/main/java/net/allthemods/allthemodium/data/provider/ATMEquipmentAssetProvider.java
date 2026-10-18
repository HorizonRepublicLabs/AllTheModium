package net.allthemods.allthemodium.data.provider;

import net.minecraft.client.data.models.EquipmentAssetProvider;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;

import net.allthemods.allthemodium.api.ATM;
import net.allthemods.allthemodium.core.registry.ATMArmorMaterials;
import net.allthemods.allthemodium.core.registry.ATMTrimMaterials;

import java.util.function.BiConsumer;

public class ATMEquipmentAssetProvider extends EquipmentAssetProvider {
    public ATMEquipmentAssetProvider(PackOutput output) {
        super(output);
    }
    
    @Override
    protected void registerModels(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> output) {
        output.accept(
                ATMArmorMaterials.ALLTHEMODIUM_ASSET,
                EquipmentClientInfo.builder()
                        .addMainHumanoidLayer(ATM.id("allthemodium_base"), false)
                        .addHumanoidLayers(ATM.id("allthemodium"))
                        .replaceTrimPalette(ATMTrimMaterials.ALLTHEMODIUM, ATMTrimMaterials.ALLTHEMODIUM_DARKER_PALETTE)
                        .build()
        );
        output.accept(ATMArmorMaterials.VIBRANIUM_ASSET, EquipmentClientInfo.builder().addHumanoidLayers(ATM.id("vibranium")).build());
        output.accept(ATMArmorMaterials.UNOBTAINIUM_ASSET, EquipmentClientInfo.builder().addHumanoidLayers(ATM.id("unobtainium")).build());
    }
}
