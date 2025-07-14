package net.teamsolar.simplest_hammers.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;

public class ModCreativeTab {
    public static void registerCreativeTab() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register(entries -> {
                    entries.add(ModItems.WOODEN_HAMMER);
                    entries.add(ModItems.STONE_HAMMER);
                    entries.add(ModItems.IRON_HAMMER);
                    entries.add(ModItems.GOLDEN_HAMMER);
                    entries.add(ModItems.DIAMOND_HAMMER);
                    entries.add(ModItems.NETHERITE_HAMMER);
                });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register(entries -> {
                    entries.add(ModItems.WOODEN_HAMMER);
                    entries.add(ModItems.STONE_HAMMER);
                    entries.add(ModItems.IRON_HAMMER);
                    entries.add(ModItems.GOLDEN_HAMMER);
                    entries.add(ModItems.DIAMOND_HAMMER);
                    entries.add(ModItems.NETHERITE_HAMMER);
                });
    }
}
