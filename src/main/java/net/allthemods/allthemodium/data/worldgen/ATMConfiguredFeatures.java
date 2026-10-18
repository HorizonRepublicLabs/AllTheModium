package net.allthemods.allthemodium.data.worldgen;

import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.RedStoneOreBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.feature.BlockColumnFeature;
import net.minecraft.world.level.levelgen.feature.BlockReplacement;
import net.minecraft.world.level.levelgen.feature.DeltaFeature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.OverlayFeature;
import net.minecraft.world.level.levelgen.feature.ScatteredOreFeature;
import net.minecraft.world.level.levelgen.feature.SimpleBlockFeature;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.OffsetPlacement;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RandomizedIntStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import net.allthemods.allthemodium.api.ATM;
import net.allthemods.allthemodium.common.blocks.AncientCaveVines;
import net.allthemods.allthemodium.core.registry.ATMBlocks;
import net.allthemods.allthemodium.core.registry.ATMFluids;
import net.allthemods.alltheores.common.material.Material;
import net.allthemods.alltheores.common.parts.BlockPartType;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

public class ATMConfiguredFeatures {
    
    public static final ResourceKey<Feature> ALLTHEMODIUM = ATMConfiguredFeatures.create("allthemodium");
    public static final ResourceKey<Feature> VIBRANIUM = ATMConfiguredFeatures.create("vibranium");
    public static final ResourceKey<Feature> OTHER_VIBRANIUM = ATMConfiguredFeatures.create("other_vibranium");
    public static final ResourceKey<Feature> UNOBTAINIUM = ATMConfiguredFeatures.create("unobtainium");
    
    public static final ResourceKey<Feature> ORE_COAL = ATMConfiguredFeatures.create("mining/ore_coal");
    public static final ResourceKey<Feature> ORE_COPPER_SMALL = ATMConfiguredFeatures.create("mining/ore_copper_small");
    public static final ResourceKey<Feature> ORE_COPPER_LARGE = ATMConfiguredFeatures.create("mining/ore_copper_large");
    public static final ResourceKey<Feature> ORE_IRON = ATMConfiguredFeatures.create("mining/ore_iron");
    public static final ResourceKey<Feature> ORE_IRON_SMALL = ATMConfiguredFeatures.create("mining/ore_iron_small");
    public static final ResourceKey<Feature> ORE_GOLD = ATMConfiguredFeatures.create("mining/ore_gold");
    public static final ResourceKey<Feature> ORE_GOLD_BURIED = ATMConfiguredFeatures.create("mining/ore_gold_buried");
    public static final ResourceKey<Feature> ORE_NETHER_GOLD = ATMConfiguredFeatures.create("mining/ore_nether_gold");
    public static final ResourceKey<Feature> ORE_REDSTONE = ATMConfiguredFeatures.create("mining/ore_redstone");
    public static final ResourceKey<Feature> ORE_LAPIS = ATMConfiguredFeatures.create("mining/ore_lapis");
    public static final ResourceKey<Feature> ORE_LAPIS_BURIED = ATMConfiguredFeatures.create("mining/ore_lapis_buried");
    public static final ResourceKey<Feature> ORE_DIAMOND_SMALL = ATMConfiguredFeatures.create("mining/ore_diamond_small");
    public static final ResourceKey<Feature> ORE_DIAMOND_BURIED = ATMConfiguredFeatures.create("mining/ore_diamond_buried");
    public static final ResourceKey<Feature> ORE_DIAMOND_MEDIUM = ATMConfiguredFeatures.create("mining/ore_diamond_medium");
    public static final ResourceKey<Feature> ORE_DIAMOND_LARGE = ATMConfiguredFeatures.create("mining/ore_diamond_large");
    public static final ResourceKey<Feature> ORE_EMERALD = ATMConfiguredFeatures.create("mining/ore_emerald");
    public static final ResourceKey<Feature> ORE_QUARTZ = ATMConfiguredFeatures.create("mining/ore_quartz");
    public static final ResourceKey<Feature> GLOWSTONE = ATMConfiguredFeatures.create("mining/glowstone");
    public static final ResourceKey<Feature> ORE_ANCIENT_DEBRIS_SMALL = ATMConfiguredFeatures.create("mining/ore_ancient_debris_small");
    public static final ResourceKey<Feature> ORE_ANCIENT_DEBRIS_LARGE = ATMConfiguredFeatures.create("mining/ore_ancient_debris_large");
    
    public static final ResourceKey<Feature> ANCIENT_TREE = ATMConfiguredFeatures.create("ancient_tree");
    public static final ResourceKey<Feature> CAVE_VINE = ATMConfiguredFeatures.create("cave_vine");
    public static final ResourceKey<Feature> DEMONIC_TREE = ATMConfiguredFeatures.create("demonic_tree");
    public static final ResourceKey<Feature> SOUL_DELTAS = ATMConfiguredFeatures.create("soul_deltas");
    public static final ResourceKey<Feature> SOUL_TREE = ATMConfiguredFeatures.create("soul_tree");

    public static final ResourceKey<Feature> ANCIENT_GRASS_BONEMEAL = ATMConfiguredFeatures.create("ancient_grass_bonemeal");
    public static final ResourceKey<Feature> CRIMSON_FOREST_BONEMEAL = ATMConfiguredFeatures.create("crimson_forest_bonemeal");
    public static final ResourceKey<Feature> WARPED_FOREST_BONEMEAL = ATMConfiguredFeatures.create("warped_forest_bonemeal");

    public static void bootstrap(final BootstrapContext<Feature> ctx) {
        ctx.register(ATMConfiguredFeatures.ALLTHEMODIUM, new OreFeature(List.of(
                BlockReplacement.replace(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), ATMBlocks.ALLTHEMODIUM_ORE.get().defaultBlockState()),
                BlockReplacement.replace(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ATMBlocks.DEEPSLATE_ALLTHEMODIUM_ORE.get().defaultBlockState())
        ), 4));
        ctx.register(ATMConfiguredFeatures.VIBRANIUM, new OreFeature(List.of(
                BlockReplacement.replace(new BlockMatchTest(Blocks.NETHERRACK), ATMBlocks.VIBRANIUM_ORE.get().defaultBlockState())
        ), 5));
        ctx.register(ATMConfiguredFeatures.UNOBTAINIUM, new OreFeature(List.of(
                BlockReplacement.replace(new BlockMatchTest(Blocks.END_STONE), ATMBlocks.UNOBTAINIUM_ORE.get().defaultBlockState())
        ), 5));
        ctx.register(ATMConfiguredFeatures.OTHER_VIBRANIUM, new OreFeature(List.of(
                BlockReplacement.replace(new BlockMatchTest(ATMBlocks.ANCIENT_STONE.get()), ATMBlocks.OTHER_VIBRANIUM_ORE.get().defaultBlockState())
        ), 5));
        
        ctx.register(ATMConfiguredFeatures.GLOWSTONE, new OreFeature(List.of(
                BlockReplacement.replace(new BlockMatchTest(Blocks.NETHERRACK), Blocks.GLOWSTONE.defaultBlockState())
        ), 8));
        ctx.register(ATMConfiguredFeatures.ORE_COAL, ATMConfiguredFeatures.stoneOre(
                Blocks.COAL_ORE,
                Blocks.DEEPSLATE_COAL_ORE,
                17
        ));
        ctx.register(ATMConfiguredFeatures.ORE_COPPER_SMALL, ATMConfiguredFeatures.stoneOre(
                Blocks.COPPER_ORE,
                Blocks.DEEPSLATE_COPPER_ORE,
                10
        ));
        ctx.register(ATMConfiguredFeatures.ORE_COPPER_LARGE, ATMConfiguredFeatures.stoneOre(
                Blocks.COPPER_ORE,
                Blocks.DEEPSLATE_COPPER_ORE,
                20
        ));
        ctx.register(ATMConfiguredFeatures.ORE_IRON, ATMConfiguredFeatures.stoneOre(
                Blocks.IRON_ORE,
                Blocks.DEEPSLATE_IRON_ORE,
                9
        ));
        ctx.register(ATMConfiguredFeatures.ORE_IRON_SMALL, ATMConfiguredFeatures.stoneOre(
                Blocks.IRON_ORE,
                Blocks.DEEPSLATE_IRON_ORE,
                4
        ));
        ctx.register(ATMConfiguredFeatures.ORE_GOLD, ATMConfiguredFeatures.stoneOre(
                Blocks.GOLD_ORE,
                Blocks.DEEPSLATE_GOLD_ORE,
                9
        ));
        ctx.register(ATMConfiguredFeatures.ORE_GOLD_BURIED, ATMConfiguredFeatures.stoneOre(
                Blocks.GOLD_ORE,
                Blocks.DEEPSLATE_GOLD_ORE,
                9,
                0.5F
        ));
        ctx.register(ATMConfiguredFeatures.ORE_NETHER_GOLD, new OreFeature(List.of(
                BlockReplacement.replace(new BlockMatchTest(Blocks.NETHERRACK), Blocks.NETHER_GOLD_ORE.defaultBlockState())
        ), 10));
        ctx.register(ATMConfiguredFeatures.ORE_REDSTONE, ATMConfiguredFeatures.stoneOre(
                Blocks.REDSTONE_ORE.defaultBlockState().setValue(RedStoneOreBlock.LIT, false),
                Blocks.DEEPSLATE_REDSTONE_ORE.defaultBlockState().setValue(RedStoneOreBlock.LIT, false),
                8
        ));
        ctx.register(ATMConfiguredFeatures.ORE_LAPIS, ATMConfiguredFeatures.stoneOre(
                Blocks.LAPIS_ORE,
                Blocks.DEEPSLATE_LAPIS_ORE,
                7
        ));
        ctx.register(ATMConfiguredFeatures.ORE_LAPIS_BURIED, ATMConfiguredFeatures.stoneOre(
                Blocks.LAPIS_ORE,
                Blocks.DEEPSLATE_LAPIS_ORE,
                7,
                1.0F
        ));
        ctx.register(ATMConfiguredFeatures.ORE_DIAMOND_SMALL, ATMConfiguredFeatures.stoneOre(
                Blocks.DIAMOND_ORE,
                Blocks.DEEPSLATE_DIAMOND_ORE,
                4,
                0.5F
        ));
        ctx.register(ATMConfiguredFeatures.ORE_DIAMOND_BURIED, ATMConfiguredFeatures.stoneOre(
                Blocks.DIAMOND_ORE,
                Blocks.DEEPSLATE_DIAMOND_ORE,
                8,
                1.0F
        ));
        ctx.register(ATMConfiguredFeatures.ORE_DIAMOND_MEDIUM, ATMConfiguredFeatures.stoneOre(
                Blocks.DIAMOND_ORE,
                Blocks.DEEPSLATE_DIAMOND_ORE,
                8,
                0.5F
        ));
        ctx.register(ATMConfiguredFeatures.ORE_DIAMOND_LARGE, ATMConfiguredFeatures.stoneOre(
                Blocks.DIAMOND_ORE,
                Blocks.DEEPSLATE_DIAMOND_ORE,
                12,
                0.7F
        ));
        ctx.register(ATMConfiguredFeatures.ORE_EMERALD, ATMConfiguredFeatures.stoneOre(
                Blocks.EMERALD_ORE,
                Blocks.DEEPSLATE_EMERALD_ORE,
                3
        ));
        ctx.register(ATMConfiguredFeatures.ORE_QUARTZ, new OreFeature(List.of(
                BlockReplacement.replace(new BlockMatchTest(Blocks.NETHERRACK), Blocks.NETHER_QUARTZ_ORE.defaultBlockState())
        ), 14));
        ctx.register(ATMConfiguredFeatures.ORE_ANCIENT_DEBRIS_SMALL, new ScatteredOreFeature(List.of(
                BlockReplacement.replace(new TagMatchTest(BlockTags.BASE_STONE_NETHER), Blocks.ANCIENT_DEBRIS.defaultBlockState())
        ), 2, 1.0F));
        ctx.register(ATMConfiguredFeatures.ORE_ANCIENT_DEBRIS_LARGE, new ScatteredOreFeature(List.of(
                BlockReplacement.replace(new TagMatchTest(BlockTags.BASE_STONE_NETHER), Blocks.ANCIENT_DEBRIS.defaultBlockState())
        ), 3, 1.0F));
        
        Material.forAll(material -> {
            Material.WorldGen worldGen = material.getWorldGen();
            if (worldGen == null) return;
            
            List<BlockReplacement> targets = new ArrayList<>();
            ATMConfiguredFeatures.addTarget(material, BlockPartType.STONE_ORE, new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), targets);
            ATMConfiguredFeatures.addTarget(material, BlockPartType.DEEPSLATE_ORE, new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), targets);
            ATMConfiguredFeatures.addTarget(material, BlockPartType.NETHER_ORE, new BlockMatchTest(Blocks.NETHERRACK), targets);
            ATMConfiguredFeatures.addTarget(material, BlockPartType.END_ORE, new BlockMatchTest(Blocks.END_STONE), targets);
            
            if (targets.isEmpty()) return;
            
            ctx.register(ATMConfiguredFeatures.mining(material), new OreFeature(targets, worldGen.veinSize())
            );
        });
        
        ctx.register(ATMConfiguredFeatures.ANCIENT_TREE, new TreeFeature.Builder(
                        new WeightedStateProvider(WeightedList.<BlockState>builder()
                                .add(ATMBlocks.ANCIENT_LOG_0.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y), 10)
                                .add(ATMBlocks.ANCIENT_LOG_1.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y), 10)
                                .add(ATMBlocks.ANCIENT_LOG_2.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y), 10)
                                .build()
                        ),
                        new ForkingTrunkPlacer(5, 2, 2),
                        BlockStateProvider.of(ATMBlocks.ANCIENT_LEAVES.get().defaultBlockState()
                                .setValue(LeavesBlock.DISTANCE, 7)
                                .setValue(LeavesBlock.PERSISTENT, false)
                                .setValue(LeavesBlock.WATERLOGGED, false)
                        ),
                        new AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)),
                        new TwoLayersFeatureSize(1, 0, 2),
                        ATMConfiguredFeatures.belowTrunk(ATMBlocks.ANCIENT_DIRT.get())
                ).ignoreVines().build()
        );
        ctx.register(ATMConfiguredFeatures.SOUL_TREE, ATMConfiguredFeatures.fancyTree(
                        new WeightedStateProvider(WeightedList.<BlockState>builder()
                                .add(ATMBlocks.SOUL_LOG_0.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y), 10)
                                .add(ATMBlocks.SOUL_LOG_1.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y), 10)
                                .add(ATMBlocks.SOUL_LOG_2.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y), 10)
                                .build()
                        ),
                        ATMBlocks.SOUL_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 7).setValue(LeavesBlock.PERSISTENT, false),
                        Blocks.WARPED_NYLIUM
                )
        );
        ctx.register(ATMConfiguredFeatures.DEMONIC_TREE, ATMConfiguredFeatures.fancyTree(
                        BlockStateProvider.of(ATMBlocks.DEMONIC_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)),
                        ATMBlocks.DEMONIC_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 7).setValue(LeavesBlock.PERSISTENT, false),
                        Blocks.CRIMSON_NYLIUM
                ));
        ctx.register(ATMConfiguredFeatures.CAVE_VINE, new BlockColumnFeature(
                List.of(
                        BlockColumnFeature.layer(
                                new WeightedListInt(WeightedList.<IntProvider>builder()
                                        .add(UniformInt.of(0, 19), 2)
                                        .add(UniformInt.of(0, 2), 3)
                                        .add(UniformInt.of(0, 6), 10)
                                        .build()),
                                new WeightedStateProvider(WeightedList.<BlockState>builder()
                                        .add(ATMBlocks.ANCIENT_CAVE_VINES_PLANT.get().defaultBlockState().setValue(AncientCaveVines.BERRIES, false), 4)
                                        .add(ATMBlocks.ANCIENT_CAVE_VINES_PLANT.get().defaultBlockState().setValue(AncientCaveVines.BERRIES, true), 1)
                                        .build())
                        ),
                        BlockColumnFeature.layer(
                                ConstantInt.of(1),
                                new RandomizedIntStateProvider(
                                        new WeightedStateProvider(WeightedList.<BlockState>builder()
                                                .add(ATMBlocks.ANCIENT_CAVE_VINES.get().defaultBlockState().setValue(AncientCaveVines.BERRIES, false), 4)
                                                .add(ATMBlocks.ANCIENT_CAVE_VINES.get().defaultBlockState().setValue(AncientCaveVines.BERRIES, true), 1)
                                                .build()),
                                        BlockStateProperties.AGE_25,
                                        UniformInt.of(23, 25)
                                )
                        )
                ),
                Direction.DOWN,
                BlockPredicate.matchesBlocks(Blocks.AIR),
                true
        ));
        ctx.register(ATMConfiguredFeatures.SOUL_DELTAS, new DeltaFeature(
                ATMFluids.SOUL_LAVA_BLOCK.get().defaultBlockState(),
                Blocks.MAGMA_BLOCK.defaultBlockState(),
                UniformInt.of(3, 7),
                UniformInt.of(0, 2)
        ));

        ctx.register(ATMConfiguredFeatures.ANCIENT_GRASS_BONEMEAL, new SimpleBlockFeature(
                new WeightedStateProvider(WeightedList.<BlockState>builder()
                        .add(Blocks.AIR.defaultBlockState(), 50)
                        .add(ATMBlocks.ANCIENT_FERN.get().defaultBlockState(), 20)
                        .add(ATMBlocks.ANCIENT_HERB.get().defaultBlockState(), 9)
                        .add(ATMBlocks.SOUL_HERB.get().defaultBlockState(), 1)
                        .build()
                )
        ));
        ctx.register(ATMConfiguredFeatures.CRIMSON_FOREST_BONEMEAL, ATMConfiguredFeatures.netherForestBonemeal(BlockStateProvider.of(ATMBlocks.DEMONIC_HERB.get())));
        ctx.register(ATMConfiguredFeatures.WARPED_FOREST_BONEMEAL, ATMConfiguredFeatures.netherForestBonemeal(BlockStateProvider.of(ATMBlocks.SOUL_HERB.get())));
    }
    
    private static TreeFeature fancyTree(BlockStateProvider provider, BlockState leaves, Block belowTrunk) {
        return new TreeFeature.Builder(
                provider,
                new FancyTrunkPlacer(3, 11, 0),
                BlockStateProvider.of(leaves),
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)),
                ATMConfiguredFeatures.belowTrunk(belowTrunk)
        ).ignoreVines().build();
    }
    
    private static Holder<BlockStateProvider> belowTrunk(Block block) {
        return Holder.direct(RuleBasedStateProvider.ifTrueThenProvide(BlockPredicate.not(BlockPredicate.matchesTag(BlockTags.CANNOT_REPLACE_BELOW_TREE_TRUNK)), block));
    }
    
    // Replaces the removed NetherForestVegetationConfig(provider, 2, 1): spreadWidth^2 tries within +-2 blocks on the same level.
    private static Feature netherForestBonemeal(BlockStateProvider provider) {
        return new OverlayFeature(HolderSet.direct(PlacementUtils.inlinePlaced(
                new SimpleBlockFeature(provider),
                CountPlacement.of(4),
                OffsetPlacement.ofTriangle(2, 0),
                BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE)
        )));
    }
    
    private static OreFeature stoneOre(Block stoneOre, Block deepslateOre, int size) {
        return ATMConfiguredFeatures.stoneOre(stoneOre, deepslateOre, size, 0.0F);
    }
    
    private static OreFeature stoneOre(Block stoneOre, Block deepslateOre, int size, float discardChance) {
        return ATMConfiguredFeatures.stoneOre(stoneOre.defaultBlockState(), deepslateOre.defaultBlockState(), size, discardChance);
    }
    
    private static OreFeature stoneOre(BlockState stoneOre, BlockState deepslateOre, int size) {
        return ATMConfiguredFeatures.stoneOre(stoneOre, deepslateOre, size, 0.0F);
    }
    
    private static OreFeature stoneOre(BlockState stoneOre, BlockState deepslateOre, int size, float discardChance) {
        return new OreFeature(List.of(
                BlockReplacement.replace(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), stoneOre),
                BlockReplacement.replace(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), deepslateOre)
        ), size, discardChance);
    }
    
    private static void addTarget(
            Material material,
            BlockPartType type,
            RuleTest target,
            List<BlockReplacement> targets
    ) {
        material.apply(type, part -> {
            if (part.isVanilla()) return;
            targets.add(BlockReplacement.replace(target, part.getHolder().get().defaultBlockState()));
        });
    }
    
    
    private static ResourceKey<Feature> create(String path) {
        return ATM.key(Registries.FEATURE, path);
    }
    
    public static ResourceKey<Feature> mining(Material material) {
        return ATMConfiguredFeatures.create("mining/ore_" + material.getGroup());
    }
}
