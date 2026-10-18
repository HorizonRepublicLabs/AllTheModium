package net.allthemods.allthemodium.common.items;

import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.BlockTransformer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemInstance;
import net.minecraft.world.item.component.BlockTransformers;
import net.minecraft.world.item.context.UseOnContext;

import java.util.List;

public class PaxelItem extends Item {
    
    private static final List<ResourceKey<BlockTransformer>> TRANSFORMERS = List.of(BlockTransformers.AXE, BlockTransformers.SHOVEL);
    
    public PaxelItem(Properties properties) {
        super(properties);
    }
    
    @Override
    public InteractionResult useOn(UseOnContext context) {
        HolderLookup.RegistryLookup<BlockTransformer> transformers = context.getLevel().registryAccess().lookupOrThrow(Registries.BLOCK_TRANSFORMER);
        for (ResourceKey<BlockTransformer> key : PaxelItem.TRANSFORMERS) {
            var holder = transformers.get(key);
            if (holder.isEmpty()) continue;
            InteractionResult result = holder.get().value().transformBlock(context, holder.get());
            if (result != InteractionResult.PASS) return result;
        }
        return InteractionResult.PASS;
    }
    
    @Override
    public boolean canPerformAction(ItemInstance stack, ItemAbility ability) {
        return ability == ItemAbilities.SHOVEL_DOUSE || super.canPerformAction(stack, ability);
    }
}
