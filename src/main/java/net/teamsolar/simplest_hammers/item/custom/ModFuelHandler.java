package net.teamsolar.simplest_hammers.item.custom;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.teamsolar.simplest_hammers.item.ModItems;

public class ModFuelHandler {

    public static void registerFuels() {
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.WOODEN_HAMMER, 200);
    }
}