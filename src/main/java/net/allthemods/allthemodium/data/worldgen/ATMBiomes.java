package net.allthemods.allthemodium.data.worldgen;

import net.minecraft.util.ARGB;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.attribute.AmbientAdditionsSettings;
import net.minecraft.world.attribute.AmbientMoodSettings;
import net.minecraft.world.attribute.AmbientParticle;
import net.minecraft.world.attribute.AmbientSounds;
import net.minecraft.world.attribute.BackgroundMusic;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import net.allthemods.allthemodium.api.ATM;

import java.util.List;
import java.util.Optional;

public class ATMBiomes {
    
    public static final ResourceKey<Biome> MINING = ATMBiomes.create("mining");
    public static final ResourceKey<Biome> THE_BEYOND = ATMBiomes.create("the_beyond");
    public static final ResourceKey<Biome> THE_OTHER = ATMBiomes.create("the_other");
    public static final ResourceKey<Biome> BASALT_DELTAS = ATMBiomes.create("basalt_deltas");
    public static final ResourceKey<Biome> CRIMSON_FOREST = ATMBiomes.create("crimson_forest");
    public static final ResourceKey<Biome> WARPED_FOREST = ATMBiomes.create("warped_forest");
    public static final ResourceKey<Biome> SOUL_SAND_VALLEY = ATMBiomes.create("soul_sand_valley");
    public static final ResourceKey<Biome> DESERT = ATMBiomes.create("desert");
    public static final ResourceKey<Biome> DESERT_HILLS = ATMBiomes.create("desert_hills");
   // public static final ResourceKey<Biome> WRETCHED_CAVES = ATMBiomes.create("wretched_caves");
    
    public static void bootstrap(final BootstrapContext<Biome> ctx) {
        HolderGetter<PlacedFeature> features = ctx.lookup(Registries.PLACED_FEATURE);
        HolderGetter<WorldCarver> carvers = ctx.lookup(Registries.CARVER);
        
        ctx.register(
                ATMBiomes.MINING,
                ATMBiomes.builder(false, 1.0F, 0.0F)
                        .specialEffects(ATMBiomes.effects(0x3F76E4, 0x2BBB0F, 0x55C93F))
                        .generationSettings(ATMBiomes.miningOres(new BiomeGenerationSettings.Builder(features, carvers), features)
                                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, features.getOrThrow(ATMPlacedFeatures.ORE_GLOWSTONE))
                                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, features.getOrThrow(ATMPlacedFeatures.ALLTHEMODIUM_MINING))
                                .build()
                        )
                        .setAttribute(EnvironmentAttributes.FOG_COLOR, ARGB.vector3fFromRGB24(0xC0D8FF))
                        .setAttribute(EnvironmentAttributes.SKY_COLOR, ARGB.vector3fFromRGB24(0x6EB1FF))
                        .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, ARGB.vector3fFromRGB24(0x050533))
                        .mobSpawnSettings(MobSpawnSettings.EMPTY)
                        .build()
        );
        
        ctx.register(
                ATMBiomes.THE_BEYOND,
                ATMBiomes.builder(false, 0.7F, 0.0F)
                        .specialEffects(ATMBiomes.effects(0x3F76E4, 0x2BBB0F, 0x55C93F))
                        .generationSettings(ATMBiomes.emptyGeneration(features, carvers))
                        .setAttribute(EnvironmentAttributes.FOG_COLOR, ARGB.vector3fFromRGB24(0xC0D8FF))
                        .setAttribute(EnvironmentAttributes.SKY_COLOR, ARGB.vector3fFromRGB24(0x6ED1FF))
                        .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, ARGB.vector3fFromRGB24(0x050533))
                        .mobSpawnSettings(MobSpawnSettings.EMPTY)
                        .build()
        );
        
        ctx.register(ATMBiomes.THE_OTHER,
                ATMBiomes.builder(false, 1.0F, 0.0F)
                        .specialEffects(ATMBiomes.effects(0x330303, 0x1B4745, 0x1B4745))
                        .generationSettings(ATMBiomes.theOther(features, carvers))
                        .setAttribute(EnvironmentAttributes.FOG_COLOR, ARGB.vector3fFromRGB24(0x330303))
                        .setAttribute(EnvironmentAttributes.SKY_COLOR, ARGB.vector3fFromRGB24(0x330303))
                        .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, ARGB.vector3fFromRGB24(0x330303))
                        .setAttribute(EnvironmentAttributes.AMBIENT_PARTICLES, AmbientParticle.of(ParticleTypes.WHITE_ASH, 0.118093334F))
                        .setAttribute(EnvironmentAttributes.AMBIENT_SOUNDS, new AmbientSounds(Optional.empty(), Optional.of(AmbientMoodSettings.LEGACY_CAVE_SETTINGS), List.of()))
                        .mobSpawnSettings(ATMBiomes.spawns()
                                .addSpawn(EntityTypes.SKELETON, 30, 5, 15)
                                .addSpawn(EntityTypes.GHAST, 50, 4, 4)
                                .addSpawn(EntityTypes.WITHER_SKELETON, 140, 1, 4)
                                .addSpawn(EntityTypes.BLAZE, 100, 2, 5)
                                .addSpawn(EntityTypes.ENDERMAN, 10, 4, 8)
                                .build()
                        )
                        .build()
        );
       /* ctx.register(
                ATMBiomes.WRETCHED_CAVES,
                ATMBiomes.builder(false, 0.9F, 0.0F)
                        .specialEffects(ATMBiomes.effects(0x330303, 0x1B4745, 0x1B4745))
                        .generationSettings(ATMBiomes.other(features, carvers)
                                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, features.getOrThrow(ATMPlacedFeatures.DEMONIC_TREE))
                                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, features.getOrThrow(ATMPlacedFeatures.ORE_GLOWSTONE))


                                .build()
                        )
                        .putAttributes(ATMBiomes.netherAttributes(0x685F70, 0x330303, SoundEvents.MUSIC_BIOME_BASALT_DELTAS, SoundEvents.AMBIENT_BASALT_DELTAS_LOOP, SoundEvents.AMBIENT_BASALT_DELTAS_MOOD, SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS, ParticleTypes.FIREFLY, 0.118093334F))
                        .mobSpawnSettings(ATMBiomes.spawns()
                                .addSpawn(EntityTypes.WITHER_SKELETON, 140, 1, 4)
                                .addSpawn(EntityTypes.GHAST, 40, 1, 1)
                                .addSpawn(EntityTypes.PIGLIN, 100, 2, 5)
                                .build()
                        )
                        .build()
        );

        */
        ctx.register(
                ATMBiomes.BASALT_DELTAS,
                ATMBiomes.builder(false, 0.9F, 0.0F)
                        .specialEffects(ATMBiomes.effects(0x330303, 0x1B4745, 0x1B4745))
                        // The deltas are the one sterile biome of The Other: soul deltas and nothing else
                        .generationSettings(new BiomeGenerationSettings.Builder(features, carvers)
                                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, features.getOrThrow(ATMPlacedFeatures.SOUL_DELTA))
                                .build()
                        )
                        .putAttributes(ATMBiomes.netherAttributes(0x685F70, 0x330303, SoundEvents.MUSIC_BIOME_BASALT_DELTAS, SoundEvents.AMBIENT_BASALT_DELTAS_LOOP, SoundEvents.AMBIENT_BASALT_DELTAS_MOOD, SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS, ParticleTypes.WHITE_ASH, 0.118093334F))
                        .mobSpawnSettings(ATMBiomes.spawns()
                                .addSpawn(EntityTypes.STRIDER, 160, 1, 2)
                                .addSpawn(EntityTypes.BLAZE, 140, 1, 2)
                                .addSpawn(EntityTypes.WITHER_SKELETON, 140, 1, 4)
                                .addSpawn(EntityTypes.GHAST, 40, 1, 1)
                                .addSpawn(EntityTypes.MAGMA_CUBE, 100, 2, 5)
                                .build()
                        )
                        .build()
        );
        ctx.register(
                ATMBiomes.CRIMSON_FOREST,
                ATMBiomes.builder(true, 1.0F, 0.0F)
                        .specialEffects(ATMBiomes.effects(0x330303, 0x1B4745, 0x1B4745))
                        .generationSettings(ATMBiomes.other(features, carvers)
                                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, features.getOrThrow(ATMPlacedFeatures.DEMONIC_TREE))
                                .build()
                        )
                        .putAttributes(ATMBiomes.netherAttributes(0x330303, 0x330303, SoundEvents.MUSIC_BIOME_CRIMSON_FOREST, SoundEvents.AMBIENT_CRIMSON_FOREST_LOOP, SoundEvents.AMBIENT_CRIMSON_FOREST_MOOD, SoundEvents.AMBIENT_CRIMSON_FOREST_ADDITIONS, ParticleTypes.WHITE_ASH, 0.118093334F))
                        .mobSpawnSettings(ATMBiomes.spawns()
                                .addSpawn(EntityTypes.WITHER_SKELETON, 100, 4, 7)
                                .addSpawn(EntityTypes.ZOMBIFIED_PIGLIN, 1, 2, 4)
                                .addSpawn(EntityTypes.HOGLIN, 9, 3, 4)
                                .addSpawn(EntityTypes.PIGLIN, 100, 3, 10)
                                .build()
                        )
                        .build()
        );
        ctx.register(
                ATMBiomes.DESERT,
                ATMBiomes.builder(false, 2.0F, 0.0F)
                        .specialEffects(ATMBiomes.effects(0x330303, 0x1B4745, 0x1B4745))
                        .generationSettings(ATMBiomes.other(features, carvers).build())
                        .putAttributes(ATMBiomes.netherAttributes(0x330303, 0x330303, SoundEvents.MUSIC_BIOME_BASALT_DELTAS, SoundEvents.AMBIENT_BASALT_DELTAS_LOOP, SoundEvents.AMBIENT_BASALT_DELTAS_MOOD, SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS, ParticleTypes.WHITE_ASH, 0.118093334F))
                        .mobSpawnSettings(ATMBiomes.desertSpawns(false).build())
                        .build()
        );
        ctx.register(
                ATMBiomes.DESERT_HILLS,
                ATMBiomes.builder(false, 2.0F, 0.0F)
                        .specialEffects(ATMBiomes.effects(0x330303, 0x1B4745, 0x1B4745))
                        .generationSettings(ATMBiomes.other(features, carvers).build())
                        .putAttributes(ATMBiomes.netherAttributes(0x330303, 0x330303, SoundEvents.MUSIC_BIOME_BASALT_DELTAS, SoundEvents.AMBIENT_BASALT_DELTAS_LOOP, SoundEvents.AMBIENT_BASALT_DELTAS_MOOD, SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS, ParticleTypes.WHITE_ASH, 0.118093334F))
                        .mobSpawnSettings(ATMBiomes.desertSpawns(true).build())
                        .build()
        );
        ctx.register(
                ATMBiomes.SOUL_SAND_VALLEY,
                ATMBiomes.builder(false, 1.0F, 0.0F)
                        .specialEffects(ATMBiomes.effects(0x330303, 0x1B4745, 0x1B4745))
                        .generationSettings(ATMBiomes.other(features, carvers).build())
                        .putAttributes(ATMBiomes.netherAttributes(0x1B4745, 0x330303, SoundEvents.MUSIC_BIOME_SOUL_SAND_VALLEY, SoundEvents.AMBIENT_SOUL_SAND_VALLEY_LOOP, SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, SoundEvents.AMBIENT_SOUL_SAND_VALLEY_ADDITIONS, ParticleTypes.ASH, 0.00625F))
                        .mobSpawnSettings(ATMBiomes.spawns()
                                .addSpawn(EntityTypes.SKELETON, 30, 5, 15)
                                .addSpawn(EntityTypes.GHAST, 50, 4, 4)
                                .addSpawn(EntityTypes.WITHER_SKELETON, 140, 4, 4)
                                .addSpawn(EntityTypes.BLAZE, 100, 2, 5)
                                .addSpawn(EntityTypes.ENDERMAN, 10, 4, 8)
                                .build()
                        )
                        .build()
        );
        ctx.register(ATMBiomes.WARPED_FOREST, ATMBiomes.builder(true, 2.0F, 0.0F)
                .specialEffects(ATMBiomes.effects(0x330303, 0x1B4745, 0x1B4745))
                .generationSettings(ATMBiomes.other(features, carvers)
                        .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, features.getOrThrow(ATMPlacedFeatures.SOUL_TREE))
                        .build()
                )
                .putAttributes(ATMBiomes.netherAttributes(0x1A051A, 0x1A051A, SoundEvents.MUSIC_BIOME_WARPED_FOREST, SoundEvents.AMBIENT_WARPED_FOREST_LOOP, SoundEvents.AMBIENT_WARPED_FOREST_MOOD, SoundEvents.AMBIENT_WARPED_FOREST_ADDITIONS, ParticleTypes.WHITE_ASH, 0.118093334F))
                .mobSpawnSettings(ATMBiomes.spawns()
                        .addSpawn(EntityTypes.WITHER_SKELETON, 140, 1, 4)
                        .addSpawn(EntityTypes.BLAZE, 100, 2, 5)
                        .addSpawn(EntityTypes.ENDERMAN, 1, 6, 9)
                        .addMobSpawnCost(EntityTypes.ENDERMAN, 1.0, 0.12)
                        .build()
                )
                .build()
        );
    }
    
    private static Biome.BiomeBuilder builder(boolean precipitation, float temperature, float downfall) {
        return new Biome.BiomeBuilder()
                .hasPrecipitation(precipitation)
                .temperature(temperature)
                .downfall(downfall);
    }
    
    private static BiomeSpecialEffects effects(int waterColor, int foliageColor, int grassColor) {
        return new BiomeSpecialEffects.Builder()
                .waterColor(waterColor)
                .foliageColorOverride(foliageColor)
                .grassColorOverride(grassColor)
                .build();
    }
    
    private static net.minecraft.world.attribute.EnvironmentAttributeMap.Builder netherAttributes(
            int fogColor,
            int skyColor,
            Holder<SoundEvent> music,
            Holder<SoundEvent> ambientLoop,
            Holder<SoundEvent> ambientMood,
            Holder<SoundEvent> ambientAddition,
            ParticleOptions particle,
            float particleChance
    ) {
        return net.minecraft.world.attribute.EnvironmentAttributeMap.builder()
                .set(EnvironmentAttributes.FOG_COLOR, ARGB.vector3fFromRGB24(fogColor))
                .set(EnvironmentAttributes.SKY_COLOR, ARGB.vector3fFromRGB24(skyColor))
                .set(EnvironmentAttributes.WATER_FOG_COLOR, ARGB.vector3fFromRGB24(0x330303))
                .set(EnvironmentAttributes.AMBIENT_PARTICLES, AmbientParticle.of(particle, particleChance))
                .set(EnvironmentAttributes.BACKGROUND_MUSIC, new BackgroundMusic(music))
                .set(EnvironmentAttributes.AMBIENT_SOUNDS, new AmbientSounds(
                        Optional.of(ambientLoop),
                        Optional.of(new AmbientMoodSettings(ambientMood, 6000, 8, 2.0)),
                        List.of(new AmbientAdditionsSettings(ambientAddition, 0.0111))
                ));
    }
    
    private static MobSpawnSettings.Builder spawns() {
        return new MobSpawnSettings.Builder();
    }
    
    private static MobSpawnSettings.Builder desertSpawns(boolean hills) {
        MobSpawnSettings.Builder builder = ATMBiomes.spawns()
                .addSpawn(EntityTypes.RABBIT, 4, 2, 3)
                .addSpawn(EntityTypes.SPIDER, 100, 4, 4)
                .addSpawn(EntityTypes.ZOMBIE, 19, 4, 4)
                .addSpawn(EntityTypes.ZOMBIE_VILLAGER, 1, 1, 1)
                .addSpawn(EntityTypes.WITHER_SKELETON, 140, 1, 4)
                .addSpawn(EntityTypes.BLAZE, 100, 2, hills ? 5 : 2)
                .addSpawn(EntityTypes.SKELETON, 100, 4, 4)
                .addSpawn(EntityTypes.CREEPER, 100, 4, 4)
                .addSpawn(EntityTypes.ENDERMAN, 10, 1, 4)
                .addSpawn(EntityTypes.WITCH, 5, 1, 1)
                .addSpawn(EntityTypes.HUSK, 80, 4, 4);
        if (hills) return builder;
        return builder.addSpawn(EntityTypes.SLIME, 100, 4, 4);
    }
    
    private static BiomeGenerationSettings emptyGeneration(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<WorldCarver> carvers) {
        return new BiomeGenerationSettings.Builder(placedFeatures, carvers).build();
    }

    /**
     * The vanilla ore set, ranged against the Mining Dimension's layer stack: y 65-247 spans its deepslate and
     * stone bands, y 1-64 its netherrack band.
     */
    private static BiomeGenerationSettings.PlainBuilder miningOres(BiomeGenerationSettings.PlainBuilder builder, HolderGetter<PlacedFeature> features) {
        return builder
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, features.getOrThrow(ATMPlacedFeatures.ORE_COAL_LOWER))
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, features.getOrThrow(ATMPlacedFeatures.ORE_COAL_UPPER))

                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, features.getOrThrow(ATMPlacedFeatures.ORE_COPPER))
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, features.getOrThrow(ATMPlacedFeatures.ORE_COPPER_LARGE))

                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, features.getOrThrow(ATMPlacedFeatures.ORE_IRON_SMALL))
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, features.getOrThrow(ATMPlacedFeatures.ORE_IRON_MIDDLE))
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, features.getOrThrow(ATMPlacedFeatures.ORE_IRON_UPPER))

                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, features.getOrThrow(ATMPlacedFeatures.ORE_GOLD))
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, features.getOrThrow(ATMPlacedFeatures.ORE_GOLD_EXTRA))
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, features.getOrThrow(ATMPlacedFeatures.ORE_GOLD_LOWER))
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, features.getOrThrow(ATMPlacedFeatures.ORE_GOLD_DELTAS))
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, features.getOrThrow(ATMPlacedFeatures.ORE_GOLD_NETHER))

                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, features.getOrThrow(ATMPlacedFeatures.ORE_REDSTONE))
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, features.getOrThrow(ATMPlacedFeatures.ORE_REDSTONE_LOWER))

                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, features.getOrThrow(ATMPlacedFeatures.ORE_LAPIS))
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, features.getOrThrow(ATMPlacedFeatures.ORE_LAPIS_BURIED))

                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, features.getOrThrow(ATMPlacedFeatures.ORE_DIAMOND))
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, features.getOrThrow(ATMPlacedFeatures.ORE_DIAMOND_BURIED))
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, features.getOrThrow(ATMPlacedFeatures.ORE_DIAMOND_MEDIUM))
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, features.getOrThrow(ATMPlacedFeatures.ORE_DIAMOND_LARGE))

                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, features.getOrThrow(ATMPlacedFeatures.ORE_EMERALD))

                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, features.getOrThrow(ATMPlacedFeatures.ORE_QUARTZ_DELTAS))
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, features.getOrThrow(ATMPlacedFeatures.ORE_QUARTZ_NETHER))

                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, features.getOrThrow(ATMPlacedFeatures.ORE_DEBRIS_SMALL))
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, features.getOrThrow(ATMPlacedFeatures.ORE_ANCIENT_DEBRIS_LARGE));
    }

    private static BiomeGenerationSettings theOther(HolderGetter<PlacedFeature> features, HolderGetter<WorldCarver> carvers) {
        return ATMBiomes.other(features, carvers)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, features.getOrThrow(ATMPlacedFeatures.ANCIENT_TREE))
                .addCarver(carvers.getOrThrow(Carvers.CAVE_EXTRA_UNDERGROUND))
                .addCarver(carvers.getOrThrow(Carvers.CAVE))
                .build();
    }
    
    private static BiomeGenerationSettings.PlainBuilder other(HolderGetter<PlacedFeature> features, HolderGetter<WorldCarver> carvers) {
        return new BiomeGenerationSettings.Builder(features, carvers)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, features.getOrThrow(ATMPlacedFeatures.OTHER_ORE_COAL))
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, features.getOrThrow(ATMPlacedFeatures.OTHER_ORE_COPPER))
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, features.getOrThrow(ATMPlacedFeatures.OTHER_ORE_IRON))
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, features.getOrThrow(ATMPlacedFeatures.OTHER_ORE_GOLD))
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, features.getOrThrow(ATMPlacedFeatures.OTHER_ORE_REDSTONE))
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, features.getOrThrow(ATMPlacedFeatures.OTHER_ORE_LAPIS))
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, features.getOrThrow(ATMPlacedFeatures.OTHER_ORE_DIAMOND))
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, features.getOrThrow(ATMPlacedFeatures.OTHER_ORE_EMERALD))
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, features.getOrThrow(ATMPlacedFeatures.ALLTHEMODIUM))
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, features.getOrThrow(ATMPlacedFeatures.VIBRANIUM_OTHER))
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, features.getOrThrow(ATMPlacedFeatures.CAVE_VINES));
    }
        
    private static ResourceKey<Biome> create(String path) {
        return ATM.key(Registries.BIOME, path);
    }
}
