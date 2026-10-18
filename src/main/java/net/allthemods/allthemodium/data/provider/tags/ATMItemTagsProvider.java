package net.allthemods.allthemodium.data.provider.tags;

import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockItemTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

import net.allthemods.allthemodium.api.ATM;
import net.allthemods.allthemodium.core.registry.ATMBlocks;
import net.allthemods.allthemodium.core.registry.ATMFluids;
import net.allthemods.allthemodium.core.registry.ATMItems;
import net.allthemods.allthemodium.core.registry.ATMTags;

import java.util.concurrent.CompletableFuture;

public class ATMItemTagsProvider extends ItemTagsProvider {
    
    public ATMItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, ATM.MOD_ID);
    }
    
    @Override
    protected void addTags(HolderLookup.Provider registries) {
        this.tag(ItemTags.PLANKS)
                .add(
                        key(ATMBlocks.ANCIENT_PLANKS.get().asItem()),
                        key(ATMBlocks.SOUL_PLANKS.get().asItem()),
                        key(ATMBlocks.DEMONIC_PLANKS.get().asItem()));
        this.tag(ATMTags.Items.ANCIENT_PLANKS).add(key(ATMBlocks.ANCIENT_PLANKS.get().asItem()));
        this.tag(ATMTags.Items.SOUL_PLANKS).add(key(ATMBlocks.SOUL_PLANKS.get().asItem()));
        this.tag(ATMTags.Items.DEMONIC_PLANKS).add(key(ATMBlocks.DEMONIC_PLANKS.get().asItem()));
        
        this.tag(ItemTags.LOGS)
                .add(
                        key(ATMBlocks.ANCIENT_LOG_0.get().asItem()),
                        key(ATMBlocks.ANCIENT_LOG_1.get().asItem()),
                        key(ATMBlocks.ANCIENT_LOG_2.get().asItem()),
                        key(ATMBlocks.STRIPPED_ANCIENT_LOG.get().asItem()),
                        key(ATMBlocks.SOUL_LOG_0.get().asItem()),
                        key(ATMBlocks.SOUL_LOG_1.get().asItem()),
                        key(ATMBlocks.SOUL_LOG_2.get().asItem()),
                        key(ATMBlocks.STRIPPED_SOUL_LOG.get().asItem()),
                        key(ATMBlocks.DEMONIC_LOG.get().asItem()),
                        key(ATMBlocks.STRIPPED_DEMONIC_LOG.get().asItem()));
        
        this.tag(ItemTags.SAPLINGS)
                .add(
                        key(ATMBlocks.ANCIENT_SAPLING.get().asItem()),
                        key(ATMBlocks.SOUL_SAPLING.get().asItem()),
                        key(ATMBlocks.DEMONIC_SAPLING.get().asItem()));
        this.tag(ItemTags.LEAVES)
                .add(
                        key(ATMBlocks.ANCIENT_LEAVES.get().asItem()),
                        key(ATMBlocks.ANCIENT_LEAVES_BOTTOM.get().asItem()),
                        key(ATMBlocks.SOUL_LEAVES.get().asItem()),
                        key(ATMBlocks.SOUL_LEAVES_BOTTOM.get().asItem()),
                        key(ATMBlocks.DEMONIC_LEAVES.get().asItem()),
                        key(ATMBlocks.DEMONIC_LEAVES_BOTTOM.get().asItem()));
        
        this.tag(ItemTags.WOODEN_SLABS)
                .add(
                        key(ATMBlocks.ANCIENT_SLAB.get().asItem()),
                        key(ATMBlocks.SOUL_SLAB.get().asItem()),
                        key(ATMBlocks.DEMONIC_SLAB.get().asItem()));
        this.tag(BlockItemTags.SLABS.item())
                .add(
                        key(ATMBlocks.ANCIENT_SLAB.get().asItem()),
                        key(ATMBlocks.SOUL_SLAB.get().asItem()),
                        key(ATMBlocks.DEMONIC_SLAB.get().asItem()),
                        key(ATMBlocks.ANCIENT_STONE_SLAB.get().asItem()),
                        key(ATMBlocks.SMOOTH_ANCIENT_STONE_SLAB.get().asItem()),
                        key(ATMBlocks.MOSSY_ANCIENT_STONE_SLAB.get().asItem()),
                        key(ATMBlocks.ANCIENT_STONE_BRICK_SLAB.get().asItem()),
                        key(ATMBlocks.CHISELED_ANCIENT_STONE_BRICK_SLAB.get().asItem()),
                        key(ATMBlocks.CRACKED_ANCIENT_STONE_BRICK_SLAB.get().asItem()),
                        key(ATMBlocks.POLISHED_ANCIENT_STONE_SLAB.get().asItem()));
        
        this.tag(ItemTags.WOODEN_STAIRS)
                .add(
                        key(ATMBlocks.ANCIENT_STAIRS.get().asItem()),
                        key(ATMBlocks.SOUL_STAIRS.get().asItem()),
                        key(ATMBlocks.DEMONIC_STAIRS.get().asItem()));
        this.tag(BlockItemTags.STAIRS.item())
                .add(
                        key(ATMBlocks.ANCIENT_STAIRS.get().asItem()),
                        key(ATMBlocks.SOUL_STAIRS.get().asItem()),
                        key(ATMBlocks.DEMONIC_STAIRS.get().asItem()),
                        key(ATMBlocks.ANCIENT_STONE_STAIRS.get().asItem()),
                        key(ATMBlocks.SMOOTH_ANCIENT_STONE_STAIRS.get().asItem()),
                        key(ATMBlocks.MOSSY_ANCIENT_STONE_STAIRS.get().asItem()),
                        key(ATMBlocks.ANCIENT_STONE_BRICK_STAIRS.get().asItem()),
                        key(ATMBlocks.CHISELED_ANCIENT_STONE_BRICK_STAIRS.get().asItem()),
                        key(ATMBlocks.CRACKED_ANCIENT_STONE_BRICK_STAIRS.get().asItem()),
                        key(ATMBlocks.POLISHED_ANCIENT_STONE_STAIRS.get().asItem()));
        
        this.tag(ItemTags.WOODEN_FENCES)
                .add(
                        key(ATMBlocks.ANCIENT_FENCE.get().asItem()),
                        key(ATMBlocks.SOUL_FENCE.get().asItem()),
                        key(ATMBlocks.DEMONIC_FENCE.get().asItem()));
        this.tag(ItemTags.FENCE_GATES)
                .add(
                        key(ATMBlocks.ANCIENT_FENCE_GATE.get().asItem()),
                        key(ATMBlocks.SOUL_FENCE_GATE.get().asItem()),
                        key(ATMBlocks.DEMONIC_FENCE_GATE.get().asItem()));
        
        this.tag(ItemTags.WOODEN_DOORS)
                .add(
                        key(ATMBlocks.ANCIENT_DOOR.get().asItem()),
                        key(ATMBlocks.SOUL_DOOR.get().asItem()),
                        key(ATMBlocks.DEMONIC_DOOR.get().asItem()));
        this.tag(ItemTags.WOODEN_TRAPDOORS)
                .add(
                        key(ATMBlocks.ANCIENT_TRAPDOOR.get().asItem()),
                        key(ATMBlocks.SOUL_TRAPDOOR.get().asItem()),
                        key(ATMBlocks.DEMONIC_TRAPDOOR.get().asItem()));
        this.tag(ItemTags.WALLS)
                .add(
                        key(ATMBlocks.ANCIENT_STONE_WALL.get().asItem()),
                        key(ATMBlocks.SMOOTH_ANCIENT_STONE_WALL.get().asItem()),
                        key(ATMBlocks.MOSSY_ANCIENT_STONE_WALL.get().asItem()),
                        key(ATMBlocks.ANCIENT_STONE_BRICK_WALL.get().asItem()),
                        key(ATMBlocks.CHISELED_ANCIENT_STONE_BRICK_WALL.get().asItem()),
                        key(ATMBlocks.CRACKED_ANCIENT_STONE_BRICK_WALL.get().asItem()),
                        key(ATMBlocks.POLISHED_ANCIENT_STONE_WALL.get().asItem()));
        
        this.tag(ItemTags.DIRT)
                .add(
                        key(ATMBlocks.ANCIENT_DIRT.get().asItem()),
                        key(ATMBlocks.ANCIENT_GRASS.get().asItem()));
        this.tag(ItemTags.STONE_BRICKS)
                .add(
                        key(ATMBlocks.ANCIENT_STONE_BRICKS.get().asItem()),
                        key(ATMBlocks.CHISELED_ANCIENT_STONE_BRICKS.get().asItem()),
                        key(ATMBlocks.CRACKED_ANCIENT_STONE_BRICKS.get().asItem()));
        this.tag(ATMTags.Items.ANCIENT_STONE).add(key(ATMBlocks.ANCIENT_STONE.get().asItem()));
        this.tag(ATMTags.Items.SMOOTH_ANCIENT_STONE).add(key(ATMBlocks.SMOOTH_ANCIENT_STONE.get().asItem()));
        this.tag(ATMTags.Items.MOSSY_ANCIENT_STONE).add(key(ATMBlocks.MOSSY_ANCIENT_STONE.get().asItem()));
        this.tag(ATMTags.Items.POLISHED_ANCIENT_STONE).add(key(ATMBlocks.POLISHED_ANCIENT_STONE.get().asItem()));
        this.tag(ATMTags.Items.ANCIENT_STONE_BRICKS).add(key(ATMBlocks.ANCIENT_STONE_BRICKS.get().asItem()));
        this.tag(ATMTags.Items.CRACKED_ANCIENT_STONE_BRICKS).add(key(ATMBlocks.CRACKED_ANCIENT_STONE_BRICKS.get().asItem()));
        this.tag(ATMTags.Items.CHISELED_ANCIENT_STONE_BRICKS).add(key(ATMBlocks.CHISELED_ANCIENT_STONE_BRICKS.get().asItem()));
        
        this.tag(ItemTags.HEAD_ARMOR)
                .add(
                        key(ATMItems.ALLTHEMODIUM_HELMET.get()),
                        key(ATMItems.VIBRANIUM_HELMET.get()),
                        key(ATMItems.UNOBTAINIUM_HELMET.get()));
        this.tag(ItemTags.CHEST_ARMOR)
                .add(
                        key(ATMItems.ALLTHEMODIUM_CHESTPLATE.get()),
                        key(ATMItems.VIBRANIUM_CHESTPLATE.get()),
                        key(ATMItems.UNOBTAINIUM_CHESTPLATE.get()));
        this.tag(ItemTags.LEG_ARMOR)
                .add(
                        key(ATMItems.ALLTHEMODIUM_LEGGINGS.get()),
                        key(ATMItems.VIBRANIUM_LEGGINGS.get()),
                        key(ATMItems.UNOBTAINIUM_LEGGINGS.get()));
        this.tag(ItemTags.FOOT_ARMOR)
                .add(
                        key(ATMItems.ALLTHEMODIUM_BOOTS.get()),
                        key(ATMItems.VIBRANIUM_BOOTS.get()),
                        key(ATMItems.UNOBTAINIUM_BOOTS.get()));
        this.tag(ItemTags.HEAD_ARMOR_ENCHANTABLE)
                .add(
                        key(ATMItems.ALLTHEMODIUM_HELMET.get()),
                        key(ATMItems.VIBRANIUM_HELMET.get()),
                        key(ATMItems.UNOBTAINIUM_HELMET.get()));
        this.tag(ItemTags.CHEST_ARMOR_ENCHANTABLE)
                .add(
                        key(ATMItems.ALLTHEMODIUM_CHESTPLATE.get()),
                        key(ATMItems.VIBRANIUM_CHESTPLATE.get()),
                        key(ATMItems.UNOBTAINIUM_CHESTPLATE.get()));
        this.tag(ItemTags.LEG_ARMOR_ENCHANTABLE)
                .add(
                        key(ATMItems.ALLTHEMODIUM_LEGGINGS.get()),
                        key(ATMItems.VIBRANIUM_LEGGINGS.get()),
                        key(ATMItems.UNOBTAINIUM_LEGGINGS.get()));
        this.tag(ItemTags.FOOT_ARMOR_ENCHANTABLE)
                .add(
                        key(ATMItems.ALLTHEMODIUM_BOOTS.get()),
                        key(ATMItems.VIBRANIUM_BOOTS.get()),
                        key(ATMItems.UNOBTAINIUM_BOOTS.get()));
        this.tag(ItemTags.ARMOR_ENCHANTABLE)
                .add(
                        key(ATMItems.ALLTHEMODIUM_HELMET.get()), key(ATMItems.ALLTHEMODIUM_CHESTPLATE.get()), key(ATMItems.ALLTHEMODIUM_LEGGINGS.get()), key(ATMItems.ALLTHEMODIUM_BOOTS.get()),
                        key(ATMItems.VIBRANIUM_HELMET.get()), key(ATMItems.VIBRANIUM_CHESTPLATE.get()), key(ATMItems.VIBRANIUM_LEGGINGS.get()), key(ATMItems.VIBRANIUM_BOOTS.get()),
                        key(ATMItems.UNOBTAINIUM_HELMET.get()), key(ATMItems.UNOBTAINIUM_CHESTPLATE.get()), key(ATMItems.UNOBTAINIUM_LEGGINGS.get()), key(ATMItems.UNOBTAINIUM_BOOTS.get()));
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(
                        key(ATMItems.ALLTHEMODIUM_HELMET.get()), key(ATMItems.ALLTHEMODIUM_CHESTPLATE.get()), key(ATMItems.ALLTHEMODIUM_LEGGINGS.get()), key(ATMItems.ALLTHEMODIUM_BOOTS.get()),
                        key(ATMItems.VIBRANIUM_HELMET.get()), key(ATMItems.VIBRANIUM_CHESTPLATE.get()), key(ATMItems.VIBRANIUM_LEGGINGS.get()), key(ATMItems.VIBRANIUM_BOOTS.get()),
                        key(ATMItems.UNOBTAINIUM_HELMET.get()), key(ATMItems.UNOBTAINIUM_CHESTPLATE.get()), key(ATMItems.UNOBTAINIUM_LEGGINGS.get()), key(ATMItems.UNOBTAINIUM_BOOTS.get()));
        this.tag(ItemTags.EQUIPPABLE_ENCHANTABLE)
                .add(
                        key(ATMItems.ALLTHEMODIUM_HELMET.get()), key(ATMItems.ALLTHEMODIUM_CHESTPLATE.get()), key(ATMItems.ALLTHEMODIUM_LEGGINGS.get()), key(ATMItems.ALLTHEMODIUM_BOOTS.get()),
                        key(ATMItems.VIBRANIUM_HELMET.get()), key(ATMItems.VIBRANIUM_CHESTPLATE.get()), key(ATMItems.VIBRANIUM_LEGGINGS.get()), key(ATMItems.VIBRANIUM_BOOTS.get()),
                        key(ATMItems.UNOBTAINIUM_HELMET.get()), key(ATMItems.UNOBTAINIUM_CHESTPLATE.get()), key(ATMItems.UNOBTAINIUM_LEGGINGS.get()), key(ATMItems.UNOBTAINIUM_BOOTS.get()))
                .add(key(ATMItems.VIBRANIUM_SHIELD.get()));
        this.tag(ItemTags.DURABILITY_ENCHANTABLE)
                .add(
                        key(ATMItems.ALLTHEMODIUM_HELMET.get()), key(ATMItems.ALLTHEMODIUM_CHESTPLATE.get()), key(ATMItems.ALLTHEMODIUM_LEGGINGS.get()), key(ATMItems.ALLTHEMODIUM_BOOTS.get()),
                        key(ATMItems.VIBRANIUM_HELMET.get()), key(ATMItems.VIBRANIUM_CHESTPLATE.get()), key(ATMItems.VIBRANIUM_LEGGINGS.get()), key(ATMItems.VIBRANIUM_BOOTS.get()),
                        key(ATMItems.UNOBTAINIUM_HELMET.get()), key(ATMItems.UNOBTAINIUM_CHESTPLATE.get()), key(ATMItems.UNOBTAINIUM_LEGGINGS.get()), key(ATMItems.UNOBTAINIUM_BOOTS.get()),
                        key(ATMItems.ALLTHEMODIUM_SWORD.get()), key(ATMItems.ALLTHEMODIUM_PICKAXE.get()), key(ATMItems.ALLTHEMODIUM_AXE.get()), key(ATMItems.ALLTHEMODIUM_SHOVEL.get()), key(ATMItems.ALLTHEMODIUM_HOE.get()), key(ATMItems.ALLTHEMODIUM_MACE.get()), key(ATMItems.ALLTHEMODIUM_BOW.get()),
                        key(ATMItems.VIBRANIUM_SWORD.get()), key(ATMItems.VIBRANIUM_PICKAXE.get()), key(ATMItems.VIBRANIUM_AXE.get()), key(ATMItems.VIBRANIUM_SHOVEL.get()), key(ATMItems.VIBRANIUM_HOE.get()), key(ATMItems.VIBRANIUM_MACE.get()), key(ATMItems.VIBRANIUM_SHIELD.get()),
                        key(ATMItems.UNOBTAINIUM_SWORD.get()), key(ATMItems.UNOBTAINIUM_PICKAXE.get()), key(ATMItems.UNOBTAINIUM_AXE.get()), key(ATMItems.UNOBTAINIUM_SHOVEL.get()), key(ATMItems.UNOBTAINIUM_HOE.get()), key(ATMItems.UNOBTAINIUM_MACE.get()), key(ATMItems.UNOBTAINIUM_CROSSBOW.get()),
                        key(ATMItems.ALLOY_SWORD.get()), key(ATMItems.ALLOY_PICKAXE.get()), key(ATMItems.ALLOY_AXE.get()), key(ATMItems.ALLOY_SHOVEL.get()), key(ATMItems.ALLOY_PAXEL.get()), key(ATMItems.ALLOY_MACE.get()), key(ATMItems.ALLOY_TRIDENT.get()));
        this.tag(ItemTags.VANISHING_ENCHANTABLE)
                .add(key(ATMItems.ALLTHEMODIUM_HELMET.get()), key(ATMItems.ALLTHEMODIUM_CHESTPLATE.get()), key(ATMItems.ALLTHEMODIUM_LEGGINGS.get()), key(ATMItems.ALLTHEMODIUM_BOOTS.get()),
                        key(ATMItems.VIBRANIUM_HELMET.get()), key(ATMItems.VIBRANIUM_CHESTPLATE.get()), key(ATMItems.VIBRANIUM_LEGGINGS.get()), key(ATMItems.VIBRANIUM_BOOTS.get()),
                        key(ATMItems.UNOBTAINIUM_HELMET.get()), key(ATMItems.UNOBTAINIUM_CHESTPLATE.get()), key(ATMItems.UNOBTAINIUM_LEGGINGS.get()), key(ATMItems.UNOBTAINIUM_BOOTS.get()),
                        key(ATMItems.ALLTHEMODIUM_SWORD.get()), key(ATMItems.ALLTHEMODIUM_PICKAXE.get()), key(ATMItems.ALLTHEMODIUM_AXE.get()), key(ATMItems.ALLTHEMODIUM_SHOVEL.get()), key(ATMItems.ALLTHEMODIUM_HOE.get()), key(ATMItems.ALLTHEMODIUM_MACE.get()), key(ATMItems.ALLTHEMODIUM_BOW.get()),
                        key(ATMItems.VIBRANIUM_SWORD.get()), key(ATMItems.VIBRANIUM_PICKAXE.get()), key(ATMItems.VIBRANIUM_AXE.get()), key(ATMItems.VIBRANIUM_SHOVEL.get()), key(ATMItems.VIBRANIUM_HOE.get()), key(ATMItems.VIBRANIUM_MACE.get()), key(ATMItems.VIBRANIUM_SHIELD.get()),
                        key(ATMItems.UNOBTAINIUM_SWORD.get()), key(ATMItems.UNOBTAINIUM_PICKAXE.get()), key(ATMItems.UNOBTAINIUM_AXE.get()), key(ATMItems.UNOBTAINIUM_SHOVEL.get()), key(ATMItems.UNOBTAINIUM_HOE.get()), key(ATMItems.UNOBTAINIUM_MACE.get()), key(ATMItems.UNOBTAINIUM_CROSSBOW.get()),
                        key(ATMItems.ALLOY_SWORD.get()), key(ATMItems.ALLOY_PICKAXE.get()), key(ATMItems.ALLOY_AXE.get()), key(ATMItems.ALLOY_SHOVEL.get()), key(ATMItems.ALLOY_PAXEL.get()), key(ATMItems.ALLOY_MACE.get()), key(ATMItems.ALLOY_TRIDENT.get()));
        
        this.tag(ItemTags.SWORDS).add(key(ATMItems.ALLTHEMODIUM_SWORD.get()), key(ATMItems.VIBRANIUM_SWORD.get()), key(ATMItems.UNOBTAINIUM_SWORD.get()), key(ATMItems.ALLOY_SWORD.get())).add(key(ATMItems.ALLOY_PAXEL.get()));
        this.tag(ItemTags.AXES)
                .add(key(ATMItems.ALLTHEMODIUM_AXE.get()), key(ATMItems.VIBRANIUM_AXE.get()), key(ATMItems.UNOBTAINIUM_AXE.get()), key(ATMItems.ALLOY_AXE.get()))
                .add(key(ATMItems.ALLOY_PAXEL.get()));
        this.tag(ItemTags.PICKAXES)
                .add(key(ATMItems.ALLTHEMODIUM_PICKAXE.get()), key(ATMItems.VIBRANIUM_PICKAXE.get()), key(ATMItems.UNOBTAINIUM_PICKAXE.get()), key(ATMItems.ALLOY_PICKAXE.get()))
                .add(key(ATMItems.ALLOY_PAXEL.get()));
        this.tag(ItemTags.SHOVELS)
                .add(key(ATMItems.ALLTHEMODIUM_SHOVEL.get()), key(ATMItems.VIBRANIUM_SHOVEL.get()), key(ATMItems.UNOBTAINIUM_SHOVEL.get()), key(ATMItems.ALLOY_SHOVEL.get()))
                .add(key(ATMItems.ALLOY_PAXEL.get()));
        this.tag(ItemTags.HOES)
                .add(key(ATMItems.ALLTHEMODIUM_HOE.get()), key(ATMItems.VIBRANIUM_HOE.get()), key(ATMItems.UNOBTAINIUM_HOE.get()))
                .add(key(ATMItems.ALLOY_PAXEL.get()));
        this.tag(ItemTags.MACE_ENCHANTABLE)
                .add(key(ATMItems.ALLTHEMODIUM_MACE.get()), key(ATMItems.VIBRANIUM_MACE.get()), key(ATMItems.UNOBTAINIUM_MACE.get()), key(ATMItems.ALLOY_MACE.get()));
        this.tag(ItemTags.BREAKS_DECORATED_POTS)
                .add(key(ATMItems.ALLTHEMODIUM_MACE.get()), key(ATMItems.VIBRANIUM_MACE.get()), key(ATMItems.UNOBTAINIUM_MACE.get()), key(ATMItems.ALLOY_MACE.get()));
        
        this.tag(ItemTags.SHARP_WEAPON_ENCHANTABLE)
                .add(key(ATMItems.ALLTHEMODIUM_SWORD.get()), key(ATMItems.VIBRANIUM_SWORD.get()), key(ATMItems.UNOBTAINIUM_SWORD.get()), key(ATMItems.ALLOY_SWORD.get()))
                .add(key(ATMItems.ALLTHEMODIUM_AXE.get()), key(ATMItems.VIBRANIUM_AXE.get()), key(ATMItems.UNOBTAINIUM_AXE.get()), key(ATMItems.ALLOY_AXE.get()))
                .add(key(ATMItems.ALLOY_PAXEL.get()));
        this.tag(ItemTags.WEAPON_ENCHANTABLE)
                .add(key(ATMItems.ALLTHEMODIUM_SWORD.get()), key(ATMItems.VIBRANIUM_SWORD.get()), key(ATMItems.UNOBTAINIUM_SWORD.get()), key(ATMItems.ALLOY_SWORD.get()))
                .add(key(ATMItems.ALLTHEMODIUM_AXE.get()), key(ATMItems.VIBRANIUM_AXE.get()), key(ATMItems.UNOBTAINIUM_AXE.get()), key(ATMItems.ALLOY_AXE.get()))
                .add(key(ATMItems.ALLTHEMODIUM_MACE.get()), key(ATMItems.VIBRANIUM_MACE.get()), key(ATMItems.UNOBTAINIUM_MACE.get()), key(ATMItems.ALLOY_MACE.get()))
                .add(key(ATMItems.ALLOY_PAXEL.get()));
        this.tag(ItemTags.FIRE_ASPECT_ENCHANTABLE)
                .add(key(ATMItems.ALLTHEMODIUM_SWORD.get()), key(ATMItems.VIBRANIUM_SWORD.get()), key(ATMItems.UNOBTAINIUM_SWORD.get()), key(ATMItems.ALLOY_SWORD.get()))
                .add(key(ATMItems.ALLTHEMODIUM_AXE.get()), key(ATMItems.VIBRANIUM_AXE.get()), key(ATMItems.UNOBTAINIUM_AXE.get()), key(ATMItems.ALLOY_AXE.get()))
                .add(key(ATMItems.ALLTHEMODIUM_MACE.get()), key(ATMItems.VIBRANIUM_MACE.get()), key(ATMItems.UNOBTAINIUM_MACE.get()), key(ATMItems.ALLOY_MACE.get()))
                .add(key(ATMItems.ALLOY_PAXEL.get()));
        this.tag(ItemTags.MINING_ENCHANTABLE)
                .add(
                        key(ATMItems.ALLTHEMODIUM_PICKAXE.get()), key(ATMItems.VIBRANIUM_PICKAXE.get()), key(ATMItems.UNOBTAINIUM_PICKAXE.get()), key(ATMItems.ALLOY_PICKAXE.get()),
                        key(ATMItems.ALLTHEMODIUM_AXE.get()), key(ATMItems.VIBRANIUM_AXE.get()), key(ATMItems.UNOBTAINIUM_AXE.get()), key(ATMItems.ALLOY_AXE.get()),
                        key(ATMItems.ALLTHEMODIUM_SHOVEL.get()), key(ATMItems.VIBRANIUM_SHOVEL.get()), key(ATMItems.UNOBTAINIUM_SHOVEL.get()), key(ATMItems.ALLOY_SHOVEL.get()),
                        key(ATMItems.ALLTHEMODIUM_HOE.get()), key(ATMItems.VIBRANIUM_HOE.get()), key(ATMItems.UNOBTAINIUM_HOE.get()),
                        key(ATMItems.ALLOY_PAXEL.get()));
        this.tag(ItemTags.MINING_LOOT_ENCHANTABLE)
                .add(
                        key(ATMItems.ALLTHEMODIUM_PICKAXE.get()), key(ATMItems.VIBRANIUM_PICKAXE.get()), key(ATMItems.UNOBTAINIUM_PICKAXE.get()), key(ATMItems.ALLOY_PICKAXE.get()),
                        key(ATMItems.ALLTHEMODIUM_AXE.get()), key(ATMItems.VIBRANIUM_AXE.get()), key(ATMItems.UNOBTAINIUM_AXE.get()), key(ATMItems.ALLOY_AXE.get()),
                        key(ATMItems.ALLTHEMODIUM_SHOVEL.get()), key(ATMItems.VIBRANIUM_SHOVEL.get()), key(ATMItems.UNOBTAINIUM_SHOVEL.get()), key(ATMItems.ALLOY_SHOVEL.get()),
                        key(ATMItems.ALLTHEMODIUM_HOE.get()), key(ATMItems.VIBRANIUM_HOE.get()), key(ATMItems.UNOBTAINIUM_HOE.get()),
                        key(ATMItems.ALLOY_PAXEL.get()));
        this.tag(ItemTags.BOW_ENCHANTABLE).add(key(ATMItems.ALLTHEMODIUM_BOW.get()));
        this.tag(ItemTags.CROSSBOW_ENCHANTABLE).add(key(ATMItems.UNOBTAINIUM_CROSSBOW.get()));
        this.tag(ItemTags.TRIDENT_ENCHANTABLE).add(key(ATMItems.ALLOY_TRIDENT.get()));
        
        this.tag(Tags.Items.TOOLS)
                .add(
                        key(ATMItems.ALLTHEMODIUM_PICKAXE.get()), key(ATMItems.VIBRANIUM_PICKAXE.get()), key(ATMItems.UNOBTAINIUM_PICKAXE.get()), key(ATMItems.ALLOY_PICKAXE.get()),
                        key(ATMItems.ALLTHEMODIUM_AXE.get()), key(ATMItems.VIBRANIUM_AXE.get()), key(ATMItems.UNOBTAINIUM_AXE.get()), key(ATMItems.ALLOY_AXE.get()),
                        key(ATMItems.ALLTHEMODIUM_SHOVEL.get()), key(ATMItems.VIBRANIUM_SHOVEL.get()), key(ATMItems.UNOBTAINIUM_SHOVEL.get()), key(ATMItems.ALLOY_SHOVEL.get()),
                        key(ATMItems.ALLTHEMODIUM_HOE.get()), key(ATMItems.VIBRANIUM_HOE.get()), key(ATMItems.UNOBTAINIUM_HOE.get()),
                        key(ATMItems.ALLOY_PAXEL.get())
                )
                .add(key(ATMItems.ALLTHEMODIUM_SWORD.get()), key(ATMItems.VIBRANIUM_SWORD.get()), key(ATMItems.UNOBTAINIUM_SWORD.get()), key(ATMItems.ALLOY_SWORD.get()))
                .add(key(ATMItems.ALLTHEMODIUM_MACE.get()), key(ATMItems.VIBRANIUM_MACE.get()), key(ATMItems.UNOBTAINIUM_MACE.get()), key(ATMItems.ALLOY_MACE.get()))
                .add(key(ATMItems.ALLTHEMODIUM_BOW.get()), key(ATMItems.VIBRANIUM_SHIELD.get()), key(ATMItems.UNOBTAINIUM_CROSSBOW.get()), key(ATMItems.ALLOY_TRIDENT.get()))
                .add(key(ATMItems.ALLTHEMODIUM_BRUSH.get()), key(ATMItems.VIBRANIUM_BRUSH.get()), key(ATMItems.UNOBTAINIUM_BRUSH.get()));
        this.tag(Tags.Items.TOOLS_MACE).add(key(ATMItems.ALLTHEMODIUM_MACE.get()), key(ATMItems.VIBRANIUM_MACE.get()), key(ATMItems.UNOBTAINIUM_MACE.get()), key(ATMItems.ALLOY_MACE.get()));
        this.tag(Tags.Items.TOOLS_BRUSH).add(key(ATMItems.ALLTHEMODIUM_BRUSH.get()), key(ATMItems.VIBRANIUM_BRUSH.get()), key(ATMItems.UNOBTAINIUM_BRUSH.get()));
        this.tag(Tags.Items.TOOLS_BOW).add(key(ATMItems.ALLTHEMODIUM_BOW.get()));
        this.tag(Tags.Items.TOOLS_CROSSBOW).add(key(ATMItems.UNOBTAINIUM_CROSSBOW.get()));
        this.tag(Tags.Items.TOOLS_SHIELD).add(key(ATMItems.VIBRANIUM_SHIELD.get()));
        this.tag(Tags.Items.MELEE_WEAPON_TOOLS)
                .add(key(ATMItems.ALLTHEMODIUM_SWORD.get()), key(ATMItems.VIBRANIUM_SWORD.get()), key(ATMItems.UNOBTAINIUM_SWORD.get()), key(ATMItems.ALLOY_SWORD.get()))
                .add(key(ATMItems.ALLTHEMODIUM_AXE.get()), key(ATMItems.VIBRANIUM_AXE.get()), key(ATMItems.UNOBTAINIUM_AXE.get()), key(ATMItems.ALLOY_AXE.get()))
                .add(key(ATMItems.ALLTHEMODIUM_MACE.get()), key(ATMItems.VIBRANIUM_MACE.get()), key(ATMItems.UNOBTAINIUM_MACE.get()), key(ATMItems.ALLOY_MACE.get()))
                .add(key(ATMItems.ALLOY_PAXEL.get()));
        this.tag(Tags.Items.RANGED_WEAPON_TOOLS).add(key(ATMItems.ALLTHEMODIUM_BOW.get()), key(ATMItems.UNOBTAINIUM_CROSSBOW.get()));
        this.tag(Tags.Items.MINING_TOOL_TOOLS)
                .add(
                        key(ATMItems.ALLTHEMODIUM_PICKAXE.get()), key(ATMItems.VIBRANIUM_PICKAXE.get()), key(ATMItems.UNOBTAINIUM_PICKAXE.get()), key(ATMItems.ALLOY_PICKAXE.get()),
                        key(ATMItems.ALLTHEMODIUM_AXE.get()), key(ATMItems.VIBRANIUM_AXE.get()), key(ATMItems.UNOBTAINIUM_AXE.get()), key(ATMItems.ALLOY_AXE.get()),
                        key(ATMItems.ALLTHEMODIUM_SHOVEL.get()), key(ATMItems.VIBRANIUM_SHOVEL.get()), key(ATMItems.UNOBTAINIUM_SHOVEL.get()), key(ATMItems.ALLOY_SHOVEL.get()),
                        key(ATMItems.ALLTHEMODIUM_HOE.get()), key(ATMItems.VIBRANIUM_HOE.get()), key(ATMItems.UNOBTAINIUM_HOE.get()),
                        key(ATMItems.ALLOY_PAXEL.get()));
        this.tag(Tags.Items.ENCHANTABLES).add(
                key(ATMItems.ALLTHEMODIUM_HELMET.get()), key(ATMItems.ALLTHEMODIUM_CHESTPLATE.get()), key(ATMItems.ALLTHEMODIUM_LEGGINGS.get()), key(ATMItems.ALLTHEMODIUM_BOOTS.get()),
                key(ATMItems.VIBRANIUM_HELMET.get()), key(ATMItems.VIBRANIUM_CHESTPLATE.get()), key(ATMItems.VIBRANIUM_LEGGINGS.get()), key(ATMItems.VIBRANIUM_BOOTS.get()),
                key(ATMItems.UNOBTAINIUM_HELMET.get()), key(ATMItems.UNOBTAINIUM_CHESTPLATE.get()), key(ATMItems.UNOBTAINIUM_LEGGINGS.get()), key(ATMItems.UNOBTAINIUM_BOOTS.get()),
                key(ATMItems.ALLTHEMODIUM_SWORD.get()), key(ATMItems.ALLTHEMODIUM_PICKAXE.get()), key(ATMItems.ALLTHEMODIUM_AXE.get()), key(ATMItems.ALLTHEMODIUM_SHOVEL.get()), key(ATMItems.ALLTHEMODIUM_HOE.get()), key(ATMItems.ALLTHEMODIUM_MACE.get()), key(ATMItems.ALLTHEMODIUM_BOW.get()),
                key(ATMItems.VIBRANIUM_SWORD.get()), key(ATMItems.VIBRANIUM_PICKAXE.get()), key(ATMItems.VIBRANIUM_AXE.get()), key(ATMItems.VIBRANIUM_SHOVEL.get()), key(ATMItems.VIBRANIUM_HOE.get()), key(ATMItems.VIBRANIUM_MACE.get()), key(ATMItems.VIBRANIUM_SHIELD.get()),
                key(ATMItems.UNOBTAINIUM_SWORD.get()), key(ATMItems.UNOBTAINIUM_PICKAXE.get()), key(ATMItems.UNOBTAINIUM_AXE.get()), key(ATMItems.UNOBTAINIUM_SHOVEL.get()), key(ATMItems.UNOBTAINIUM_HOE.get()), key(ATMItems.UNOBTAINIUM_MACE.get()), key(ATMItems.UNOBTAINIUM_CROSSBOW.get()),
                key(ATMItems.ALLOY_SWORD.get()), key(ATMItems.ALLOY_PICKAXE.get()), key(ATMItems.ALLOY_AXE.get()), key(ATMItems.ALLOY_SHOVEL.get()), key(ATMItems.ALLOY_PAXEL.get()), key(ATMItems.ALLOY_MACE.get()), key(ATMItems.ALLOY_TRIDENT.get()));
        
        this.tag(ItemTags.CLUSTER_MAX_HARVESTABLES)
                .add(key(ATMItems.ALLTHEMODIUM_PICKAXE.get()), key(ATMItems.VIBRANIUM_PICKAXE.get()), key(ATMItems.UNOBTAINIUM_PICKAXE.get()), key(ATMItems.ALLOY_PICKAXE.get()))
                .add(key(ATMItems.ALLOY_PAXEL.get()));
        
        this.tag(ItemTags.TRIM_MATERIALS).add(key(ATMItems.ALLTHEMODIUM_INGOT.get()), key(ATMItems.VIBRANIUM_INGOT.get()), key(ATMItems.UNOBTAINIUM_INGOT.get()));
        this.tag(ItemTags.BEACON_PAYMENT_ITEMS).add(key(ATMItems.ALLTHEMODIUM_INGOT.get()), key(ATMItems.VIBRANIUM_INGOT.get()), key(ATMItems.UNOBTAINIUM_INGOT.get()));
        
        this.tag(ItemTags.PIGLIN_LOVED)
                .add(
                        key(ATMItems.ALLTHEMODIUM_HELMET.get()),
                        key(ATMItems.ALLTHEMODIUM_CHESTPLATE.get()),
                        key(ATMItems.ALLTHEMODIUM_LEGGINGS.get()),
                        key(ATMItems.ALLTHEMODIUM_BOOTS.get()));
        
        this.tag(ATMTags.Items.RAW_MATERIALS_ALLTHEMODIUM).add(key(ATMItems.RAW_ALLTHEMODIUM.get()));
        this.tag(ATMTags.Items.RAW_MATERIALS_VIBRANIUM).add(key(ATMItems.RAW_VIBRANIUM.get()));
        this.tag(ATMTags.Items.RAW_MATERIALS_UNOBTAINIUM).add(key(ATMItems.RAW_UNOBTAINIUM.get()));
        this.tag(Tags.Items.RAW_MATERIALS).add(key(ATMItems.RAW_ALLTHEMODIUM.get()), key(ATMItems.RAW_VIBRANIUM.get()), key(ATMItems.RAW_UNOBTAINIUM.get()));
        
        this.tag(ATMTags.Items.NUGGETS_ALLTHEMODIUM).add(key(ATMItems.ALLTHEMODIUM_NUGGET.get()));
        this.tag(ATMTags.Items.NUGGETS_VIBRANIUM).add(key(ATMItems.VIBRANIUM_NUGGET.get()));
        this.tag(ATMTags.Items.NUGGETS_UNOBTAINIUM).add(key(ATMItems.UNOBTAINIUM_NUGGET.get()));
        this.tag(Tags.Items.NUGGETS).add(key(ATMItems.ALLTHEMODIUM_NUGGET.get()), key(ATMItems.VIBRANIUM_NUGGET.get()), key(ATMItems.UNOBTAINIUM_NUGGET.get()));
        
        this.tag(ATMTags.Items.INGOTS_ALLTHEMODIUM).add(key(ATMItems.ALLTHEMODIUM_INGOT.get()));
        this.tag(ATMTags.Items.INGOTS_VIBRANIUM).add(key(ATMItems.VIBRANIUM_INGOT.get()));
        this.tag(ATMTags.Items.INGOTS_UNOBTAINIUM).add(key(ATMItems.UNOBTAINIUM_INGOT.get()));
        this.tag(ATMTags.Items.INGOTS_ALLOYS).add(key(ATMItems.VIBRANIUM_ALLTHEMODIUM_ALLOY.get()), key(ATMItems.UNOBTAINIUM_ALLTHEMODIUM_ALLOY.get()), key(ATMItems.UNOBTAINIUM_VIBRANIUM_ALLOY.get()));
        this.tag(ATMTags.Items.INGOTS_VIBRANIUM_ALLTHEMODIUM_ALLOY).add(key(ATMItems.VIBRANIUM_ALLTHEMODIUM_ALLOY.get()));
        this.tag(ATMTags.Items.INGOTS_UNOBTAINIUM_ALLTHEMODIUM_ALLOY).add(key(ATMItems.UNOBTAINIUM_ALLTHEMODIUM_ALLOY.get()));
        this.tag(ATMTags.Items.INGOTS_UNOBTAINIUM_VIBRANIUM_ALLOY).add(key(ATMItems.UNOBTAINIUM_VIBRANIUM_ALLOY.get()));
        this.tag(Tags.Items.INGOTS)
                .add(
                        key(ATMItems.ALLTHEMODIUM_INGOT.get()),
                        key(ATMItems.VIBRANIUM_INGOT.get()),
                        key(ATMItems.UNOBTAINIUM_INGOT.get()),
                        key(ATMItems.VIBRANIUM_ALLTHEMODIUM_ALLOY.get()),
                        key(ATMItems.UNOBTAINIUM_ALLTHEMODIUM_ALLOY.get()),
                        key(ATMItems.UNOBTAINIUM_VIBRANIUM_ALLOY.get()));
        
        this.tag(ATMTags.Items.DUSTS_ALLTHEMODIUM).add(key(ATMItems.ALLTHEMODIUM_DUST.get()));
        this.tag(ATMTags.Items.DUSTS_VIBRANIUM).add(key(ATMItems.VIBRANIUM_DUST.get()));
        this.tag(ATMTags.Items.DUSTS_UNOBTAINIUM).add(key(ATMItems.UNOBTAINIUM_DUST.get()));
        this.tag(ATMTags.Items.DUSTS_VIBRANIUM_ALLTHEMODIUM_ALLOY).add(key(ATMItems.VIBRANIUM_ALLTHEMODIUM_DUST.get()));
        this.tag(ATMTags.Items.DUSTS_UNOBTAINIUM_ALLTHEMODIUM_ALLOY).add(key(ATMItems.UNOBTAINIUM_ALLTHEMODIUM_DUST.get()));
        this.tag(ATMTags.Items.DUSTS_UNOBTAINIUM_VIBRANIUM_ALLOY).add(key(ATMItems.UNOBTAINIUM_VIBRANIUM_DUST.get()));
        this.tag(Tags.Items.DUSTS)
                .add(
                        key(ATMItems.ALLTHEMODIUM_DUST.get()),
                        key(ATMItems.VIBRANIUM_DUST.get()),
                        key(ATMItems.UNOBTAINIUM_DUST.get()),
                        key(ATMItems.VIBRANIUM_ALLTHEMODIUM_DUST.get()),
                        key(ATMItems.UNOBTAINIUM_ALLTHEMODIUM_DUST.get()),
                        key(ATMItems.UNOBTAINIUM_VIBRANIUM_DUST.get()));
        
        this.tag(ATMTags.Items.PLATES).add(key(ATMItems.ALLTHEMODIUM_PLATE.get()), key(ATMItems.VIBRANIUM_PLATE.get()), key(ATMItems.UNOBTAINIUM_PLATE.get()));
        this.tag(ATMTags.Items.PLATES_ALLTHEMODIUM).add(key(ATMItems.ALLTHEMODIUM_PLATE.get()));
        this.tag(ATMTags.Items.PLATES_VIBRANIUM).add(key(ATMItems.VIBRANIUM_PLATE.get()));
        this.tag(ATMTags.Items.PLATES_UNOBTAINIUM).add(key(ATMItems.UNOBTAINIUM_PLATE.get()));
        
        this.tag(ATMTags.Items.GEARS).add(key(ATMItems.ALLTHEMODIUM_GEAR.get()), key(ATMItems.VIBRANIUM_GEAR.get()), key(ATMItems.UNOBTAINIUM_GEAR.get()));
        this.tag(ATMTags.Items.GEARS_ALLTHEMODIUM).add(key(ATMItems.ALLTHEMODIUM_GEAR.get()));
        this.tag(ATMTags.Items.GEARS_VIBRANIUM).add(key(ATMItems.VIBRANIUM_GEAR.get()));
        this.tag(ATMTags.Items.GEARS_UNOBTAINIUM).add(key(ATMItems.UNOBTAINIUM_GEAR.get()));
        
        this.tag(ATMTags.Items.RODS_ALLTHEMODIUM).add(key(ATMItems.ALLTHEMODIUM_ROD.get()));
        this.tag(ATMTags.Items.RODS_VIBRANIUM).add(key(ATMItems.VIBRANIUM_ROD.get()));
        this.tag(ATMTags.Items.RODS_UNOBTAINIUM).add(key(ATMItems.UNOBTAINIUM_ROD.get()));
        this.tag(Tags.Items.RODS).add(key(ATMItems.ALLTHEMODIUM_ROD.get()), key(ATMItems.VIBRANIUM_ROD.get()), key(ATMItems.UNOBTAINIUM_ROD.get()));
        
        this.tag(Tags.Items.ORES)
                .add(
                        key(ATMBlocks.ALLTHEMODIUM_ORE.get().asItem()),
                        key(ATMBlocks.DEEPSLATE_ALLTHEMODIUM_ORE.get().asItem()),
                        key(ATMBlocks.VIBRANIUM_ORE.get().asItem()),
                        key(ATMBlocks.OTHER_VIBRANIUM_ORE.get().asItem()),
                        key(ATMBlocks.UNOBTAINIUM_ORE.get().asItem()));
        this.tag(ATMTags.Items.ORES_ALLTHEMODIUM).add(key(ATMBlocks.ALLTHEMODIUM_ORE.get().asItem()), key(ATMBlocks.DEEPSLATE_ALLTHEMODIUM_ORE.get().asItem()));
        this.tag(ATMTags.Items.ORES_VIBRANIUM).add(key(ATMBlocks.VIBRANIUM_ORE.get().asItem()), key(ATMBlocks.OTHER_VIBRANIUM_ORE.get().asItem()));
        this.tag(ATMTags.Items.ORES_UNOBTAINIUM).add(key(ATMBlocks.UNOBTAINIUM_ORE.get().asItem()));
        this.tag(Tags.Items.ORES_IN_GROUND_STONE).add(key(ATMBlocks.ALLTHEMODIUM_ORE.get().asItem()));
        this.tag(Tags.Items.ORES_IN_GROUND_DEEPSLATE).add(key(ATMBlocks.DEEPSLATE_ALLTHEMODIUM_ORE.get().asItem()));
        this.tag(Tags.Items.ORES_IN_GROUND_NETHERRACK).add(key(ATMBlocks.VIBRANIUM_ORE.get().asItem()));
        this.tag(ATMTags.Items.ORES_IN_GROUND_ANCIENT_STONE).add(key(ATMBlocks.OTHER_VIBRANIUM_ORE.get().asItem()));
        this.tag(ATMTags.Items.ORES_IN_GROUND_END_STONE).add(key(ATMBlocks.UNOBTAINIUM_ORE.get().asItem()));
        
        this.tag(Tags.Items.STONES).add(key(ATMBlocks.ANCIENT_STONE.get().asItem()));
        this.tag(ItemTags.STONE_CRAFTING_MATERIALS).add(key(ATMBlocks.ANCIENT_STONE.get().asItem()));
        this.tag(ItemTags.STONE_TOOL_MATERIALS).add(key(ATMBlocks.ANCIENT_STONE.get().asItem()));
        
        this.tag(Tags.Items.STORAGE_BLOCKS)
                .add(
                        key(ATMBlocks.PIGLICH_HEART_BLOCK.get().asItem()),
                        key(ATMBlocks.ALLTHEMODIUM_BLOCK.get().asItem()),
                        key(ATMBlocks.VIBRANIUM_BLOCK.get().asItem()),
                        key(ATMBlocks.UNOBTAINIUM_BLOCK.get().asItem()),
                        key(ATMBlocks.RAW_ALLTHEMODIUM_BLOCK.get().asItem()),
                        key(ATMBlocks.RAW_VIBRANIUM_BLOCK.get().asItem()),
                        key(ATMBlocks.RAW_UNOBTAINIUM_BLOCK.get().asItem()),
                        key(ATMBlocks.VIBRANIUM_ALLTHEMODIUM_BLOCK.get().asItem()),
                        key(ATMBlocks.UNOBTAINIUM_ALLTHEMODIUM_BLOCK.get().asItem()),
                        key(ATMBlocks.UNOBTAINIUM_VIBRANIUM_BLOCK.get().asItem()));
        this.tag(ATMTags.Items.STORAGE_BLOCKS_ALLTHEMODIUM).add(key(ATMBlocks.ALLTHEMODIUM_BLOCK.get().asItem()));
        this.tag(ATMTags.Items.STORAGE_BLOCKS_VIBRANIUM).add(key(ATMBlocks.VIBRANIUM_BLOCK.get().asItem()));
        this.tag(ATMTags.Items.STORAGE_BLOCKS_UNOBTAINIUM).add(key(ATMBlocks.UNOBTAINIUM_BLOCK.get().asItem()));
        this.tag(ATMTags.Items.STORAGE_BLOCKS_RAW_ALLTHEMODIUM).add(key(ATMBlocks.RAW_ALLTHEMODIUM_BLOCK.get().asItem()));
        this.tag(ATMTags.Items.STORAGE_BLOCKS_RAW_VIBRANIUM).add(key(ATMBlocks.RAW_VIBRANIUM_BLOCK.get().asItem()));
        this.tag(ATMTags.Items.STORAGE_BLOCKS_RAW_UNOBTAINIUM).add(key(ATMBlocks.RAW_UNOBTAINIUM_BLOCK.get().asItem()));
        this.tag(ATMTags.Items.STORAGE_BLOCKS_VIBRANIUM_ALLTHEMODIUM_ALLOY).add(key(ATMBlocks.VIBRANIUM_ALLTHEMODIUM_BLOCK.get().asItem()));
        this.tag(ATMTags.Items.STORAGE_BLOCKS_UNOBTAINIUM_ALLTHEMODIUM_ALLOY).add(key(ATMBlocks.UNOBTAINIUM_ALLTHEMODIUM_BLOCK.get().asItem()));
        this.tag(ATMTags.Items.STORAGE_BLOCKS_UNOBTAINIUM_VIBRANIUM_ALLOY).add(key(ATMBlocks.UNOBTAINIUM_VIBRANIUM_BLOCK.get().asItem()));
        
        this.tag(ATMTags.Items.ATM_FOODS).add(key(ATMItems.ALLTHEMODIUM_APPLE.get()), key(ATMItems.ALLTHEMODIUM_CARROT.get()));
        this.tag(Tags.Items.FOODS).addTag(ATMTags.Items.ATM_FOODS).add(key(ATMItems.SOUL_BERRIES.get()));
        this.tag(Tags.Items.FOODS_FRUIT).add(key(ATMItems.ALLTHEMODIUM_APPLE.get()), key(ATMItems.SOUL_BERRIES.get()));
        this.tag(Tags.Items.FOODS_VEGETABLE).add(key(ATMItems.ALLTHEMODIUM_CARROT.get()));
        this.tag(Tags.Items.FOODS_BERRY).add(key(ATMItems.SOUL_BERRIES.get()));
        
        this.tag(Tags.Items.BOOKSHELVES)
                .add(
                        key(ATMBlocks.ANCIENT_BOOKSHELF.get().asItem()),
                        key(ATMBlocks.SOUL_BOOKSHELF.get().asItem()),
                        key(ATMBlocks.DEMONIC_BOOKSHELF.get().asItem()));
        this.tag(Tags.Items.BUCKETS)
                .add(
                        key(ATMFluids.SOUL_LAVA_BUCKET.get()),
                        key(ATMFluids.MOLTEN_ALLTHEMODIUM_BUCKET.get()),
                        key(ATMFluids.MOLTEN_VIBRANIUM_BUCKET.get()),
                        key(ATMFluids.MOLTEN_UNOBTAINIUM_BUCKET.get()));
    }
    
    private static ResourceKey<Item> key(ItemLike item) {
        return item.asItem().builtInRegistryHolder().key();
    }
}
