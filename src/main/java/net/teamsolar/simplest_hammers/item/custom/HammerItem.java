package net.teamsolar.simplest_hammers.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

import java.util.ArrayList;
import java.util.List;

public class HammerItem extends DiggerItemWithoutDurability {
    public HammerItem(Tier tier, Properties properties) {
        super(tier, BlockTags.MINEABLE_WITH_PICKAXE, properties);
    }

    public static List<BlockPos> getBlocksToBeDestroyed(int range, BlockPos initialBlockPos, ServerPlayer player) {
        List<BlockPos> positions = new ArrayList<>();


        if(player.isShiftKeyDown()) {
            return positions;
        }
        BlockHitResult traceResult = player.level().clip(new ClipContext(player.getEyePosition(1f),
                (player.getEyePosition(1f).add(player.getViewVector(1f).scale(6f))),
                ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));
        if(traceResult.getType() == HitResult.Type.MISS) {
            return positions;
        } else {
            // assuming that the clip hit a block
            switch(traceResult.getDirection()) {
                case UP, DOWN:
                    for(int x = -range; x <= range; x++) {
                        for(int y = -range; y <= range; y++) {
                            positions.add(new BlockPos(initialBlockPos.getX() + x, initialBlockPos.getY(), initialBlockPos.getZ() + y));
                        }
                    }
                    break;
                case EAST, WEST:
                    for(int x = -range; x <= range; x++) {
                        for(int y = -range; y <= range; y++) {
                            positions.add(new BlockPos(initialBlockPos.getX(), initialBlockPos.getY() + y, initialBlockPos.getZ() + x));
                        }
                    }
                    break;
                case NORTH, SOUTH:
                    for(int x = -range; x <= range; x++) {
                        for(int y = -range; y <= range; y++) {
                            positions.add(new BlockPos(initialBlockPos.getX() + x, initialBlockPos.getY() + y, initialBlockPos.getZ()));
                        }
                    }
                    break;
            }
            positions = positions.stream().filter(it -> !it.equals(initialBlockPos)).toList();

            return positions;
        }
    }
}
