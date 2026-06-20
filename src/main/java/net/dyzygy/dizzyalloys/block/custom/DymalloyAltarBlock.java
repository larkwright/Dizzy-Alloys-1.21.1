package net.dyzygy.dizzyalloys.block.custom;

import net.dyzygy.dizzyalloys.DizzyAlloys;
import net.dyzygy.dizzyalloys.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;
import java.util.Properties;

public class DymalloyAltarBlock extends Block {
    public DymalloyAltarBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Shapes.box(0, 0, 0, 1, 0.875, 1);
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if(!level.isClientSide()) {
            checkForItems(level, pos);
        }
        super.entityInside(state, level, pos, entity);
    }

    private void checkForItems(Level level, BlockPos pos) {
        AABB searchArea = new AABB(pos).move(0, 1, 0);
        List<ItemEntity> items = level.getEntitiesOfClass(ItemEntity.class, searchArea);

        for(ItemEntity itemEntity : items) {
            ItemStack stack = itemEntity.getItem();

            if(stack.getItem() == ModItems.RAW_TIN.get()) {
                itemEntity.setItem(new ItemStack(Items.DIAMOND, stack.getCount()));
                level.playSound(null, pos, SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.BLOCKS, 1f, 1f);
            }

            if(stack.getItem() == Items.POPPY) {
                itemEntity.setItem(new ItemStack(Items.WITHER_ROSE, stack.getCount()));
                level.playSound(null, pos, SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.BLOCKS, 1f, 1f);
            }
        }
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos,
                                               Player player, BlockHitResult hitResult) {
        level.playSound(player, pos, SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.BLOCKS, 1f, 1f);
        return super.useWithoutItem(state, level, pos, player, hitResult);
    }
}
