package net.allthemods.allthemodium.data.provider.tags;

import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockItemTags;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import net.allthemods.allthemodium.api.ATM;
import net.allthemods.allthemodium.core.registry.ATMBlocks;
import net.allthemods.allthemodium.core.registry.ATMFluids;
import net.allthemods.allthemodium.core.registry.ATMTags;
import net.allthemods.alltheores.core.registry.ATORegistry;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ATMBlockTagsProvider extends BlockTagsProvider {
    
    
    public ATMBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, ATM.MOD_ID);
    }
    
    @Override
    protected void addTags(HolderLookup.Provider registries) {
        
        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(
                        key(ATMBlocks.ALLTHEMODIUM_ORE.get()),
                        key(ATMBlocks.DEEPSLATE_ALLTHEMODIUM_ORE.get()),
                        key(ATMBlocks.RAW_ALLTHEMODIUM_BLOCK.get()),
                        key(ATMBlocks.ALLTHEMODIUM_BLOCK.get()));
        
        this.tag(ATMTags.Blocks.NEEDS_ALLTHEMODIUM_TOOL)
                .add(
                        key(ATMBlocks.VIBRANIUM_ORE.get()),
                        key(ATMBlocks.OTHER_VIBRANIUM_ORE.get()),
                        key(ATMBlocks.RAW_VIBRANIUM_BLOCK.get()),
                        key(ATMBlocks.VIBRANIUM_BLOCK.get())
                );

        this.tag(ATMTags.Blocks.NEEDS_VIBRANIUM_TOOL)
                .add(
                        key(ATMBlocks.UNOBTAINIUM_ORE.get()),
                        key(ATMBlocks.RAW_UNOBTAINIUM_BLOCK.get()),
                        key(ATMBlocks.UNOBTAINIUM_BLOCK.get())
                );

        this.tag(ATMTags.Blocks.NEEDS_UNOBTAINIUM_TOOL)
                .add(
                        key(ATMBlocks.UNOBTAINIUM_ALLTHEMODIUM_BLOCK.get()),
                        key(ATMBlocks.UNOBTAINIUM_VIBRANIUM_BLOCK.get()),
                        key(ATMBlocks.VIBRANIUM_ALLTHEMODIUM_BLOCK.get()),
                        key(ATMBlocks.ANCIENT_STONE_BRICKS.get()),
                        key(ATMBlocks.CHISELED_ANCIENT_STONE_BRICKS.get()),
                        key(ATMBlocks.CRACKED_ANCIENT_STONE_BRICKS.get()),
                        key(ATMBlocks.POLISHED_ANCIENT_STONE.get()),
                        key(ATMBlocks.SMOOTH_ANCIENT_STONE.get()),
                        key(ATMBlocks.ANCIENT_STONE_BRICK_WALL.get()),
                        key(ATMBlocks.CHISELED_ANCIENT_STONE_BRICK_WALL.get()),
                        key(ATMBlocks.CRACKED_ANCIENT_STONE_BRICK_WALL.get()),
                        key(ATMBlocks.POLISHED_ANCIENT_STONE_WALL.get()),
                        key(ATMBlocks.SMOOTH_ANCIENT_STONE_WALL.get()),
                        key(ATMBlocks.ANCIENT_STONE_BRICK_STAIRS.get()),
                        key(ATMBlocks.CHISELED_ANCIENT_STONE_BRICK_STAIRS.get()),
                        key(ATMBlocks.CRACKED_ANCIENT_STONE_BRICK_STAIRS.get()),
                        key(ATMBlocks.POLISHED_ANCIENT_STONE_STAIRS.get()),
                        key(ATMBlocks.SMOOTH_ANCIENT_STONE_STAIRS.get()),
                        key(ATMBlocks.ANCIENT_STONE_BRICK_SLAB.get()),
                        key(ATMBlocks.CHISELED_ANCIENT_STONE_BRICK_SLAB.get()),
                        key(ATMBlocks.CRACKED_ANCIENT_STONE_BRICK_SLAB.get()),
                        key(ATMBlocks.POLISHED_ANCIENT_STONE_SLAB.get()),
                        key(ATMBlocks.SMOOTH_ANCIENT_STONE_SLAB.get())
                );

        this.tag(ATMTags.Blocks.INCORRECT_FOR_ALLTHEMODIUM_TOOL)
                .addTag(ATMTags.Blocks.NEEDS_VIBRANIUM_TOOL)
                .addTag(ATMTags.Blocks.NEEDS_UNOBTAINIUM_TOOL);

        this.tag(ATMTags.Blocks.INCORRECT_FOR_VIBRANIUM_TOOL)
                .addTag(ATMTags.Blocks.NEEDS_UNOBTAINIUM_TOOL);

        this.tag(ATMTags.Blocks.INCORRECT_FOR_UNOBTAINIUM_TOOL);
        this.tag(ATMTags.Blocks.INCORRECT_FOR_ALLOY_TOOL);

        List.of(
                BlockTags.INCORRECT_FOR_WOODEN_TOOL,
                BlockTags.INCORRECT_FOR_STONE_TOOL,
                BlockTags.INCORRECT_FOR_COPPER_TOOL,
                BlockTags.INCORRECT_FOR_IRON_TOOL,
                BlockTags.INCORRECT_FOR_GOLD_TOOL,
                BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
                BlockTags.INCORRECT_FOR_NETHERITE_TOOL
        ).forEach(tag -> this.tag(tag)
                .addTag(ATMTags.Blocks.NEEDS_ALLTHEMODIUM_TOOL)
                .addTag(ATMTags.Blocks.NEEDS_VIBRANIUM_TOOL)
                .addTag(ATMTags.Blocks.NEEDS_UNOBTAINIUM_TOOL)
        );
        
        this.tag(ATMTags.Blocks.MINEABLE_WITH_PAXEL)
                .addTag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.MINEABLE_WITH_SHOVEL)
                .addTag(BlockTags.MINEABLE_WITH_HOE);
        
        this.tag(ATMTags.Blocks.SUPPORTS_OTHER_VEGETATION)
                .add(
                        key(ATMBlocks.ANCIENT_DIRT.get()),
                        key(ATMBlocks.ANCIENT_GRASS.get()),
                        key(ATMBlocks.ANCIENT_PODZOL.get()),
                        key(Blocks.WARPED_NYLIUM),
                        key(Blocks.CRIMSON_NYLIUM)
                );
        
        this.tag(BlockTags.BEACON_BASE_BLOCKS)
                .add(
                        key(ATMBlocks.ALLTHEMODIUM_BLOCK.get()),
                        key(ATMBlocks.VIBRANIUM_BLOCK.get()),
                        key(ATMBlocks.UNOBTAINIUM_BLOCK.get()));
        
        this.tag(BlockTags.SOUL_FIRE_BASE_BLOCKS)
                .add(
                        key(ATMBlocks.ANCIENT_DIRT.get()),
                        key(ATMBlocks.ANCIENT_GRASS.get()),
                        key(ATMBlocks.ANCIENT_LOG_0.get()),
                        key(ATMBlocks.ANCIENT_LOG_1.get()),
                        key(ATMBlocks.ANCIENT_LOG_2.get()),
                        key(ATMBlocks.STRIPPED_ANCIENT_LOG.get()));
        
        this.tag(BlockTags.PLANKS).add(key(ATMBlocks.ANCIENT_PLANKS.get()), key(ATMBlocks.SOUL_PLANKS.get()), key(ATMBlocks.DEMONIC_PLANKS.get()));
        this.tag(ATMTags.Blocks.ANCIENT_PLANKS).add(key(ATMBlocks.ANCIENT_PLANKS.get()));
        this.tag(ATMTags.Blocks.SOUL_PLANKS).add(key(ATMBlocks.SOUL_PLANKS.get()));
        this.tag(ATMTags.Blocks.DEMONIC_PLANKS).add(key(ATMBlocks.DEMONIC_PLANKS.get()));
        
        this.tag(BlockTags.LOGS)
                .add(
                        key(ATMBlocks.ANCIENT_LOG_0.get()),
                        key(ATMBlocks.ANCIENT_LOG_1.get()),
                        key(ATMBlocks.ANCIENT_LOG_2.get()),
                        key(ATMBlocks.STRIPPED_ANCIENT_LOG.get()),
                        key(ATMBlocks.SOUL_LOG_0.get()),
                        key(ATMBlocks.SOUL_LOG_1.get()),
                        key(ATMBlocks.SOUL_LOG_2.get()),
                        key(ATMBlocks.STRIPPED_SOUL_LOG.get()),
                        key(ATMBlocks.DEMONIC_LOG.get()),
                        key(ATMBlocks.STRIPPED_DEMONIC_LOG.get()));
        
        this.tag(BlockItemTags.SAPLINGS.block()).add(key(ATMBlocks.ANCIENT_SAPLING.get()), key(ATMBlocks.SOUL_SAPLING.get()), key(ATMBlocks.DEMONIC_SAPLING.get()));
        this.tag(BlockTags.LEAVES)
                .add(
                        key(ATMBlocks.ANCIENT_LEAVES.get()),
                        key(ATMBlocks.ANCIENT_LEAVES_BOTTOM.get()),
                        key(ATMBlocks.SOUL_LEAVES.get()),
                        key(ATMBlocks.SOUL_LEAVES_BOTTOM.get()),
                        key(ATMBlocks.DEMONIC_LEAVES.get()),
                        key(ATMBlocks.DEMONIC_LEAVES_BOTTOM.get()));
        
        this.tag(BlockTags.CAVE_VINES).add(key(ATMBlocks.ANCIENT_CAVE_VINES.get()), key(ATMBlocks.ANCIENT_CAVE_VINES_PLANT.get()));
        this.tag(BlockTags.CLIMBABLE).add(key(ATMBlocks.ANCIENT_CAVE_VINES.get()), key(ATMBlocks.ANCIENT_CAVE_VINES_PLANT.get()));
        
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                        key(ATMBlocks.ALLTHEMODIUM_ORE.get()),
                        key(ATMBlocks.DEEPSLATE_ALLTHEMODIUM_ORE.get()),
                        key(ATMBlocks.VIBRANIUM_ORE.get()),
                        key(ATMBlocks.OTHER_VIBRANIUM_ORE.get()),
                        key(ATMBlocks.UNOBTAINIUM_ORE.get()),
                        key(ATMBlocks.RAW_ALLTHEMODIUM_BLOCK.get()),
                        key(ATMBlocks.RAW_VIBRANIUM_BLOCK.get()),
                        key(ATMBlocks.RAW_UNOBTAINIUM_BLOCK.get()),
                        key(ATMBlocks.ALLTHEMODIUM_BLOCK.get()),
                        key(ATMBlocks.VIBRANIUM_BLOCK.get()),
                        key(ATMBlocks.UNOBTAINIUM_BLOCK.get()),
                        key(ATMBlocks.UNOBTAINIUM_ALLTHEMODIUM_BLOCK.get()),
                        key(ATMBlocks.UNOBTAINIUM_VIBRANIUM_BLOCK.get()),
                        key(ATMBlocks.VIBRANIUM_ALLTHEMODIUM_BLOCK.get()),
                        key(ATMBlocks.PIGLICH_HEART_BLOCK.get()),
                        key(ATMBlocks.ANCIENT_STONE.get()),
                        key(ATMBlocks.SMOOTH_ANCIENT_STONE.get()),
                        key(ATMBlocks.MOSSY_ANCIENT_STONE.get()),
                        key(ATMBlocks.ANCIENT_STONE_BRICKS.get()),
                        key(ATMBlocks.CHISELED_ANCIENT_STONE_BRICKS.get()),
                        key(ATMBlocks.CRACKED_ANCIENT_STONE_BRICKS.get()),
                        key(ATMBlocks.POLISHED_ANCIENT_STONE.get()),
                        key(ATMBlocks.ANCIENT_STONE_WALL.get()),
                        key(ATMBlocks.SMOOTH_ANCIENT_STONE_WALL.get()),
                        key(ATMBlocks.MOSSY_ANCIENT_STONE_WALL.get()),
                        key(ATMBlocks.ANCIENT_STONE_BRICK_WALL.get()),
                        key(ATMBlocks.CHISELED_ANCIENT_STONE_BRICK_WALL.get()),
                        key(ATMBlocks.CRACKED_ANCIENT_STONE_BRICK_WALL.get()),
                        key(ATMBlocks.POLISHED_ANCIENT_STONE_WALL.get()),
                        key(ATMBlocks.ANCIENT_STONE_STAIRS.get()),
                        key(ATMBlocks.SMOOTH_ANCIENT_STONE_STAIRS.get()),
                        key(ATMBlocks.MOSSY_ANCIENT_STONE_STAIRS.get()),
                        key(ATMBlocks.ANCIENT_STONE_BRICK_STAIRS.get()),
                        key(ATMBlocks.CHISELED_ANCIENT_STONE_BRICK_STAIRS.get()),
                        key(ATMBlocks.CRACKED_ANCIENT_STONE_BRICK_STAIRS.get()),
                        key(ATMBlocks.POLISHED_ANCIENT_STONE_STAIRS.get()),
                        key(ATMBlocks.ANCIENT_STONE_SLAB.get()),
                        key(ATMBlocks.SMOOTH_ANCIENT_STONE_SLAB.get()),
                        key(ATMBlocks.MOSSY_ANCIENT_STONE_SLAB.get()),
                        key(ATMBlocks.ANCIENT_STONE_BRICK_SLAB.get()),
                        key(ATMBlocks.CHISELED_ANCIENT_STONE_BRICK_SLAB.get()),
                        key(ATMBlocks.CRACKED_ANCIENT_STONE_BRICK_SLAB.get()),
                        key(ATMBlocks.POLISHED_ANCIENT_STONE_SLAB.get()),
                        key(ATMBlocks.TELEPORT_PAD.get()));
        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(
                        key(ATMBlocks.ANCIENT_PLANKS.get()),
                        key(ATMBlocks.ANCIENT_LOG_0.get()),
                        key(ATMBlocks.ANCIENT_LOG_1.get()),
                        key(ATMBlocks.ANCIENT_LOG_2.get()),
                        key(ATMBlocks.STRIPPED_ANCIENT_LOG.get()),
                        key(ATMBlocks.ANCIENT_TRAPDOOR.get()),
                        key(ATMBlocks.ANCIENT_FENCE.get()),
                        key(ATMBlocks.ANCIENT_FENCE_GATE.get()),
                        key(ATMBlocks.ANCIENT_DOOR.get()),
                        key(ATMBlocks.ANCIENT_BOOKSHELF.get()),
                        key(ATMBlocks.ANCIENT_STAIRS.get()),
                        key(ATMBlocks.ANCIENT_SLAB.get()),
                        key(ATMBlocks.SOUL_PLANKS.get()),
                        key(ATMBlocks.SOUL_LOG_0.get()),
                        key(ATMBlocks.SOUL_LOG_1.get()),
                        key(ATMBlocks.SOUL_LOG_2.get()),
                        key(ATMBlocks.STRIPPED_SOUL_LOG.get()),
                        key(ATMBlocks.SOUL_TRAPDOOR.get()),
                        key(ATMBlocks.SOUL_FENCE.get()),
                        key(ATMBlocks.SOUL_FENCE_GATE.get()),
                        key(ATMBlocks.SOUL_DOOR.get()),
                        key(ATMBlocks.SOUL_BOOKSHELF.get()),
                        key(ATMBlocks.SOUL_STAIRS.get()),
                        key(ATMBlocks.SOUL_SLAB.get()),
                        key(ATMBlocks.DEMONIC_PLANKS.get()),
                        key(ATMBlocks.DEMONIC_LOG.get()),
                        key(ATMBlocks.STRIPPED_DEMONIC_LOG.get()),
                        key(ATMBlocks.DEMONIC_TRAPDOOR.get()),
                        key(ATMBlocks.DEMONIC_FENCE.get()),
                        key(ATMBlocks.DEMONIC_FENCE_GATE.get()),
                        key(ATMBlocks.DEMONIC_DOOR.get()),
                        key(ATMBlocks.DEMONIC_BOOKSHELF.get()),
                        key(ATMBlocks.DEMONIC_STAIRS.get()),
                        key(ATMBlocks.DEMONIC_SLAB.get()));
        this.tag(BlockTags.MINEABLE_WITH_HOE)
                .add(
                        key(ATMBlocks.ANCIENT_LEAVES.get()),
                        key(ATMBlocks.ANCIENT_LEAVES_BOTTOM.get()),
                        key(ATMBlocks.SOUL_LEAVES.get()),
                        key(ATMBlocks.SOUL_LEAVES_BOTTOM.get()),
                        key(ATMBlocks.DEMONIC_LEAVES.get()),
                        key(ATMBlocks.DEMONIC_LEAVES_BOTTOM.get()));
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(
                        key(ATMBlocks.ANCIENT_DIRT.get()),
                        key(ATMBlocks.ANCIENT_GRASS.get()),
                        key(ATMBlocks.ANCIENT_PODZOL.get()),
                        key(ATMBlocks.SUS_CLAY.get()),
                        key(ATMBlocks.SUS_SOUL_SAND.get())
                );
        
        this.tag(BlockTags.DIRT).add(key(ATMBlocks.ANCIENT_DIRT.get()), key(ATMBlocks.ANCIENT_GRASS.get()), key(ATMBlocks.ANCIENT_PODZOL.get()));
        this.tag(BlockTags.NYLIUM).add(key(ATMBlocks.ANCIENT_STONE.get()));
        this.tag(BlockTags.INFINIBURN_NETHER).add(key(ATMBlocks.ANCIENT_STONE.get()), key(ATMBlocks.ANCIENT_GRASS.get()), key(ATMBlocks.ANCIENT_DIRT.get()));
        
        this.tag(BlockTags.WOODEN_FENCES).add(key(ATMBlocks.ANCIENT_FENCE.get()), key(ATMBlocks.SOUL_FENCE.get()), key(ATMBlocks.DEMONIC_FENCE.get()));
        this.tag(BlockTags.FENCES).addTag(BlockTags.WOODEN_FENCES);
        this.tag(Tags.Blocks.FENCES_WOODEN).addTag(BlockTags.WOODEN_FENCES);
        
        this.tag(BlockTags.FENCE_GATES).add(key(ATMBlocks.ANCIENT_FENCE_GATE.get()), key(ATMBlocks.SOUL_FENCE_GATE.get()), key(ATMBlocks.DEMONIC_FENCE_GATE.get()));
        this.tag(Tags.Blocks.FENCE_GATES_WOODEN).addTag(BlockTags.FENCE_GATES);
        
        this.tag(BlockTags.WOODEN_SLABS).add(key(ATMBlocks.ANCIENT_SLAB.get()), key(ATMBlocks.SOUL_SLAB.get()), key(ATMBlocks.DEMONIC_SLAB.get()));
        this.tag(BlockTags.WOODEN_STAIRS).add(key(ATMBlocks.ANCIENT_STAIRS.get()), key(ATMBlocks.SOUL_STAIRS.get()), key(ATMBlocks.DEMONIC_STAIRS.get()));
        this.tag(BlockTags.WOODEN_DOORS).add(key(ATMBlocks.ANCIENT_DOOR.get()), key(ATMBlocks.SOUL_DOOR.get()), key(ATMBlocks.DEMONIC_DOOR.get()));
        this.tag(BlockTags.DOORS).addTag(BlockTags.WOODEN_DOORS);
        this.tag(BlockTags.WOODEN_TRAPDOORS).add(key(ATMBlocks.ANCIENT_TRAPDOOR.get()), key(ATMBlocks.SOUL_TRAPDOOR.get()), key(ATMBlocks.DEMONIC_TRAPDOOR.get()));
        this.tag(BlockTags.TRAPDOORS).addTag(BlockTags.WOODEN_TRAPDOORS);
        
        this.tag(BlockTags.SLABS)
                .addTag(BlockTags.WOODEN_SLABS)
                .add(
                        key(ATMBlocks.ANCIENT_STONE_SLAB.get()),
                        key(ATMBlocks.SMOOTH_ANCIENT_STONE_SLAB.get()),
                        key(ATMBlocks.MOSSY_ANCIENT_STONE_SLAB.get()),
                        key(ATMBlocks.ANCIENT_STONE_BRICK_SLAB.get()),
                        key(ATMBlocks.CHISELED_ANCIENT_STONE_BRICK_SLAB.get()),
                        key(ATMBlocks.CRACKED_ANCIENT_STONE_BRICK_SLAB.get()),
                        key(ATMBlocks.POLISHED_ANCIENT_STONE_SLAB.get()));
        this.tag(BlockTags.STAIRS)
                .addTag(BlockTags.WOODEN_STAIRS)
                .add(
                        key(ATMBlocks.ANCIENT_STONE_STAIRS.get()),
                        key(ATMBlocks.SMOOTH_ANCIENT_STONE_STAIRS.get()),
                        key(ATMBlocks.MOSSY_ANCIENT_STONE_STAIRS.get()),
                        key(ATMBlocks.ANCIENT_STONE_BRICK_STAIRS.get()),
                        key(ATMBlocks.CHISELED_ANCIENT_STONE_BRICK_STAIRS.get()),
                        key(ATMBlocks.CRACKED_ANCIENT_STONE_BRICK_STAIRS.get()),
                        key(ATMBlocks.POLISHED_ANCIENT_STONE_STAIRS.get()));
        this.tag(BlockTags.WALLS)
                .add(
                        key(ATMBlocks.ANCIENT_STONE_WALL.get()),
                        key(ATMBlocks.SMOOTH_ANCIENT_STONE_WALL.get()),
                        key(ATMBlocks.MOSSY_ANCIENT_STONE_WALL.get()),
                        key(ATMBlocks.ANCIENT_STONE_BRICK_WALL.get()),
                        key(ATMBlocks.CHISELED_ANCIENT_STONE_BRICK_WALL.get()),
                        key(ATMBlocks.CRACKED_ANCIENT_STONE_BRICK_WALL.get()),
                        key(ATMBlocks.POLISHED_ANCIENT_STONE_WALL.get()));
        
        this.tag(BlockTags.STONE_BRICKS)
                .add(
                        key(ATMBlocks.ANCIENT_STONE_BRICKS.get()),
                        key(ATMBlocks.CHISELED_ANCIENT_STONE_BRICKS.get()),
                        key(ATMBlocks.CRACKED_ANCIENT_STONE_BRICKS.get()));
        
        this.tag(Tags.Blocks.BOOKSHELVES)
                .add(
                        key(ATMBlocks.ANCIENT_BOOKSHELF.get()),
                        key(ATMBlocks.SOUL_BOOKSHELF.get()),
                        key(ATMBlocks.DEMONIC_BOOKSHELF.get()));
        
        this.tag(ATMTags.Blocks.ANCIENT_STONE).add(key(ATMBlocks.ANCIENT_STONE.get()));
        this.tag(ATMTags.Blocks.SMOOTH_ANCIENT_STONE).add(key(ATMBlocks.SMOOTH_ANCIENT_STONE.get()));
        this.tag(ATMTags.Blocks.MOSSY_ANCIENT_STONE).add(key(ATMBlocks.MOSSY_ANCIENT_STONE.get()));
        this.tag(ATMTags.Blocks.POLISHED_ANCIENT_STONE).add(key(ATMBlocks.POLISHED_ANCIENT_STONE.get()));
        this.tag(ATMTags.Blocks.ANCIENT_STONE_BRICKS).add(key(ATMBlocks.ANCIENT_STONE_BRICKS.get()));
        this.tag(ATMTags.Blocks.CRACKED_ANCIENT_STONE_BRICKS).add(key(ATMBlocks.CRACKED_ANCIENT_STONE_BRICKS.get()));
        this.tag(ATMTags.Blocks.CHISELED_ANCIENT_STONE_BRICKS).add(key(ATMBlocks.CHISELED_ANCIENT_STONE_BRICKS.get()));
        
        this.tag(ATMTags.Blocks.ORES_ALLTHEMODIUM).add(key(ATMBlocks.ALLTHEMODIUM_ORE.get()), key(ATMBlocks.DEEPSLATE_ALLTHEMODIUM_ORE.get()));
        this.tag(ATMTags.Blocks.ORES_VIBRANIUM).add(key(ATMBlocks.VIBRANIUM_ORE.get()), key(ATMBlocks.OTHER_VIBRANIUM_ORE.get()));
        this.tag(ATMTags.Blocks.ORES_UNOBTANIUM).add(key(ATMBlocks.UNOBTAINIUM_ORE.get()));
        this.tag(Tags.Blocks.ORES)
                .add(
                        key(ATMBlocks.ALLTHEMODIUM_ORE.get()),
                        key(ATMBlocks.DEEPSLATE_ALLTHEMODIUM_ORE.get()),
                        key(ATMBlocks.VIBRANIUM_ORE.get()),
                        key(ATMBlocks.OTHER_VIBRANIUM_ORE.get()),
                        key(ATMBlocks.UNOBTAINIUM_ORE.get()));
        this.tag(Tags.Blocks.ORES_IN_GROUND_STONE).add(key(ATMBlocks.ALLTHEMODIUM_ORE.get()));
        this.tag(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE).add(key(ATMBlocks.DEEPSLATE_ALLTHEMODIUM_ORE.get()));
        this.tag(Tags.Blocks.ORES_IN_GROUND_NETHERRACK).add(key(ATMBlocks.VIBRANIUM_ORE.get()));
        this.tag(ATORegistry.ORES_IN_GROUND_ANCIENT_STONE).add(key(ATMBlocks.OTHER_VIBRANIUM_ORE.get()));
        
        this.tag(Tags.Blocks.STORAGE_BLOCKS)
                .add(
                        key(ATMBlocks.PIGLICH_HEART_BLOCK.get()),
                        key(ATMBlocks.ALLTHEMODIUM_BLOCK.get()),
                        key(ATMBlocks.VIBRANIUM_BLOCK.get()),
                        key(ATMBlocks.UNOBTAINIUM_BLOCK.get()),
                        key(ATMBlocks.RAW_ALLTHEMODIUM_BLOCK.get()),
                        key(ATMBlocks.RAW_VIBRANIUM_BLOCK.get()),
                        key(ATMBlocks.RAW_UNOBTAINIUM_BLOCK.get()),
                        key(ATMBlocks.UNOBTAINIUM_ALLTHEMODIUM_BLOCK.get()),
                        key(ATMBlocks.UNOBTAINIUM_VIBRANIUM_BLOCK.get()),
                        key(ATMBlocks.VIBRANIUM_ALLTHEMODIUM_BLOCK.get()));
        this.tag(ATMTags.Blocks.STORAGE_BLOCKS_ALLTHEMODIUM).add(key(ATMBlocks.ALLTHEMODIUM_BLOCK.get()));
        this.tag(ATMTags.Blocks.STORAGE_BLOCKS_VIBRANIUM).add(key(ATMBlocks.VIBRANIUM_BLOCK.get()));
        this.tag(ATMTags.Blocks.STORAGE_BLOCKS_UNOBTAINIUM).add(key(ATMBlocks.UNOBTAINIUM_BLOCK.get()));
        this.tag(ATMTags.Blocks.STORAGE_BLOCKS_RAW_ALLTHEMODIUM).add(key(ATMBlocks.RAW_ALLTHEMODIUM_BLOCK.get()));
        this.tag(ATMTags.Blocks.STORAGE_BLOCKS_RAW_VIBRANIUM).add(key(ATMBlocks.RAW_VIBRANIUM_BLOCK.get()));
        this.tag(ATMTags.Blocks.STORAGE_BLOCKS_RAW_UNOBTAINIUM).add(key(ATMBlocks.RAW_UNOBTAINIUM_BLOCK.get()));
        this.tag(ATMTags.Blocks.STORAGE_BLOCKS_VIBRANIUM_ALLTHEMODIUM_ALLOY).add(key(ATMBlocks.VIBRANIUM_ALLTHEMODIUM_BLOCK.get()));
        this.tag(ATMTags.Blocks.STORAGE_BLOCKS_UNOBTAINIUM_ALLTHEMODIUM_ALLOY).add(key(ATMBlocks.UNOBTAINIUM_ALLTHEMODIUM_BLOCK.get()));
        this.tag(ATMTags.Blocks.STORAGE_BLOCKS_UNOBTAINIUM_VIBRANIUM_ALLOY).add(key(ATMBlocks.UNOBTAINIUM_VIBRANIUM_BLOCK.get()));
        
        for (var entry : ATMBlocks.BLOCKS.getEntries()) {
            this.tag(ATMTags.Blocks.OTHER_PROTECTION).add(key(entry.get()));
        }
        
        for (var entry : ATMFluids.BLOCKS.getEntries()) {
            this.tag(ATMTags.Blocks.OTHER_PROTECTION).add(key(entry.get()));
        }
        
        this.tag(ATMTags.Blocks.OTHER_PROTECTION)
                .add(
                        key(Blocks.SAND),
                        key(Blocks.SANDSTONE),
                        key(Blocks.CRIMSON_NYLIUM),
                        key(Blocks.WARPED_NYLIUM),
                        key(Blocks.NETHERRACK),
                        key(Blocks.SOUL_SAND),
                        key(Blocks.SOUL_SOIL),
                        key(Blocks.DEEPSLATE),
                        key(Blocks.NETHERITE_BLOCK),
                        key(Blocks.DIAMOND_BLOCK),
                        key(Blocks.AMETHYST_BLOCK),
                        key(Blocks.AMETHYST_CLUSTER),
                        key(Blocks.GOLD_BLOCK),
                        key(Blocks.SPAWNER))
                .addTag(Tags.Blocks.ORES);
        
        this.tag(ATMTags.Blocks.LOOTR_CONVERT_CLAYS).add(key(ATMBlocks.SUS_CLAY.get()));
        this.tag(ATMTags.Blocks.LOOTR_CONVERT_SOUL_SANDS).add(key(ATMBlocks.SUS_SOUL_SAND.get()));
        for (Identifier lootrBlock : List.of(ATM.id("lootr_suspicious_clay"), ATM.id("lootr_suspicious_soul_sand"))) {
            this.getOrCreateRawBuilder(ATMTags.Blocks.OTHER_PROTECTION).addOptionalElement(lootrBlock);
            this.getOrCreateRawBuilder(BlockTags.MINEABLE_WITH_SHOVEL).addOptionalElement(lootrBlock);
        }
        
        this.tag(Tags.Blocks.RELOCATION_NOT_SUPPORTED)
                .add(
                        key(ATMBlocks.ALLTHEMODIUM_ORE.get()),
                        key(ATMBlocks.DEEPSLATE_ALLTHEMODIUM_ORE.get()),
                        key(ATMBlocks.VIBRANIUM_ORE.get()),
                        key(ATMBlocks.OTHER_VIBRANIUM_ORE.get()),
                        key(ATMBlocks.UNOBTAINIUM_ORE.get()),
                        key(ATMBlocks.TELEPORT_PAD.get())
                );
    }
    
    private static TagKey<Block> atm(String path) {
        return TagKey.create(Registries.BLOCK, ATM.id(path));
    }
    
    private static TagKey<Block> c(String path) {
        return TagKey.create(Registries.BLOCK, ATM.c(path));
    }
    
    private static ResourceKey<Block> key(Block block) {
        return block.builtInRegistryHolder().key();
    }
}
