package net.teamsolar.simplest_hammers.event;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.teamsolar.simplest_hammers.SimplestHammers;
import net.teamsolar.simplest_hammers.item.custom.HammerItem;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

public class HammerEvent implements PlayerBlockBreakEvents.After {
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    @Override
    public void afterBlockBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity) {
        if (world.isClient()) return;

        ItemStack mainHandItem = player.getMainHandStack();

        if (mainHandItem.getItem() instanceof HammerItem hammer && player instanceof ServerPlayerEntity serverPlayer) {
            if (HARVESTED_BLOCKS.contains(pos)) return;

            for (BlockPos positionTarget : HammerItem.getBlocksToBeDestroyed(1, pos, serverPlayer)) {
                SimplestHammers.LOGGER.info("Attempting to break: {}", positionTarget);
                if (positionTarget.equals(pos)) continue;

                BlockState targetState = world.getBlockState(positionTarget);
                if (!hammer.isCorrectForDrops(mainHandItem, targetState)) continue;

                HARVESTED_BLOCKS.add(positionTarget);
                serverPlayer.interactionManager.tryBreakBlock(positionTarget);
                HARVESTED_BLOCKS.remove(positionTarget);
            }
        }
    }
}
