package net.teamsolar.simplest_hammers.event;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;

public class ModEvents {
    public static void registerEvents() {
        PlayerBlockBreakEvents.AFTER.register(new HammerEvent());
    }
//
//    // Done with the help of https://github.com/CoFH/CoFHCore/blob/1.19.x/src/main/java/cofh/core/event/AreaEffectEvents.java
//    // Don't be a jerk License
//    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();
//
//    @SubscribeEvent
//    public static void onHammerUsage(BlockEvent.BreakEvent event) {
//        Player player = event.getPlayer();
//        ItemStack mainHandItem = player.getMainHandItem();
//
//        if (mainHandItem.getItem() instanceof HammerItem hammer && player instanceof ServerPlayer serverPlayer) {
//            BlockPos initalBlockPos = event.getPos();
//            if (HARVESTED_BLOCKS.contains(initalBlockPos)) {
//                return;
//            }
//
//            Enchantment enchantment = ModEnchantment.RADIUS.get();
//            int enchantmentLevel = EnchantmentHelper.getItemEnchantmentLevel(enchantment, mainHandItem);
//
//            if (enchantmentLevel == 1) {
//                for (BlockPos pos : HammerItem.getBlocksToBeDestroyed(2, initalBlockPos, serverPlayer)) {
//                    if (pos == initalBlockPos || !hammer.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
//                        continue;
//                    }
//
//                    HARVESTED_BLOCKS.add(pos);
//                    serverPlayer.gameMode.destroyBlock(pos);
//                    HARVESTED_BLOCKS.remove(pos);
//                }
//            //}
//        if (){
//                for (BlockPos pos : HammerItem.getBlocksToBeDestroyed(1, initalBlockPos, serverPlayer)) {
//                    if (pos == initalBlockPos || !hammer.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
//                        continue;
//                    }
//
//                    // Have to add them to a Set otherwise, the same code right here will get called for each block!
//                    HARVESTED_BLOCKS.add(pos);
//                    serverPlayer.gameMode.destroyBlock(pos);
//                    HARVESTED_BLOCKS.remove(pos);
//                }
//            }
//        }
//    }

    // Done with the help of https://github.com/CoFH/CoFHCore/blob/1.19.x/src/main/java/cofh/core/event/AreaEffectEvents.java
    // Don't be a jerk License
    //private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();
    /*
    public static void onHammerUsage(BlockEvent.BreakEvent event) {
        PlayerEntity player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if(mainHandItem.getItem() instanceof HammerItem hammer && player instanceof ServerPlayerEntity serverPlayer) {
            BlockPos initalBlockPos = event.getPos();
            if (HARVESTED_BLOCKS.contains(initalBlockPos)) {
                return;
            }

            for (BlockPos pos : HammerItem.getBlocksToBeDestroyed(1, initalBlockPos, serverPlayer)) {
                if(pos == initalBlockPos || !hammer.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                // Have to add them to a Set otherwise, the same code right here will get called for each block!
                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
        }
    }
    */
}