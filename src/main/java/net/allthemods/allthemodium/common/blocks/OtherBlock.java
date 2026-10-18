package net.allthemods.allthemodium.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;

public class OtherBlock extends Block {

    public OtherBlock(Properties properties) {
        super(properties.requiresCorrectToolForDrops()
                .isRedstoneConductor((_, _, _) -> false)
                .sound(SoundType.ANCIENT_DEBRIS)
                .strength(-1.0f, 1500.0f)
        );
    }

    @Override
    public boolean canEntityDestroy(BlockState state, BlockGetter level, BlockPos pos, Entity entity) {
        return OtherProtection.canEntityDestroy(pos, entity, super.canEntityDestroy(state, level, pos, entity));
    }

    @Override
    protected float getDestroyProgress(BlockState state, Player player, BlockGetter level, BlockPos pos) {
        return OtherProtection.getDestroyProgress(state, player, level, pos, this.canEntityDestroy(state, level, pos, player));
    }
}
