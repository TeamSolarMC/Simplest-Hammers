package net.teamsolar.simplest_hammers.item.custom;

import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.teamsolar.simplest_hammers.item.ModItems;

public class ModFuelHandler {

    public static void registerFuels() {
        FuelRegistryEvents.BUILD.register((builder, context) -> {
            builder.add(ModItems.WOODEN_HAMMER, context.baseSmeltTime());
        });
    }
}