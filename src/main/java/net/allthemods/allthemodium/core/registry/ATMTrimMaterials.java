package net.allthemods.allthemodium.core.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.trim.TrimMaterial;

import net.allthemods.allthemodium.api.ATM;

public final class ATMTrimMaterials {
    public static final ResourceKey<TrimMaterial> ALLTHEMODIUM = ATM.key(Registries.TRIM_MATERIAL, "allthemodium");
    public static final ResourceKey<TrimMaterial> VIBRANIUM = ATM.key(Registries.TRIM_MATERIAL, "vibranium");
    public static final ResourceKey<TrimMaterial> UNOBTAINIUM = ATM.key(Registries.TRIM_MATERIAL, "unobtainium");
    
    // Palette textures live at assets/allthemodium/textures/palettes/trim/<name>.png
    public static final Identifier ALLTHEMODIUM_PALETTE = ATM.id("trim/allthemodium");
    public static final Identifier ALLTHEMODIUM_DARKER_PALETTE = ATM.id("trim/allthemodium_darker");
    public static final Identifier VIBRANIUM_PALETTE = ATM.id("trim/vibranium");
    public static final Identifier UNOBTAINIUM_PALETTE = ATM.id("trim/unobtainium");
    
    private ATMTrimMaterials() {
    }
}
