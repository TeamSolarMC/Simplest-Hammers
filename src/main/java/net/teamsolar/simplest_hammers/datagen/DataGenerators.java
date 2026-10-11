package net.teamsolar.simplest_hammers.datagen;

import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.teamsolar.simplest_hammers.SimplestHammers;

@EventBusSubscriber(modid = SimplestHammers.MODID)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {
        // CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        event.createProvider(ModModelProvider::new);
        event.createProvider(ModBlockTagGenerator::new);
        event.createProvider(ModItemTagProvider::new);

        event.createReloadableRegistryObjects(
            new RegistrySetBuilder()
                    .add(ModRecipeProvider.create())
        );
        event.createProvider(ModGlobalLootModifierProvider::new);
   }
}
