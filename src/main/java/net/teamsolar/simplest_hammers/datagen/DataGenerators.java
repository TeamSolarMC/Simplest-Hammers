package net.teamsolar.simplest_hammers.datagen;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.data.event.GatherDataRegistryEntriesEvent;
import net.teamsolar.simplest_hammers.SimplestHammers;

@EventBusSubscriber(modid = SimplestHammers.MODID)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {
        event.createProvider(ModModelProvider::new);
        event.createProvider(ModBlockTagGenerator::new);
        event.createProvider(ModItemTagProvider::new);
        event.createProvider(ModGlobalLootModifierProvider::new);
    }
    @SubscribeEvent
    public static void gatherRegistries(GatherDataRegistryEntriesEvent event) {
        event.add(ModRecipeProvider.create());
    }
}
