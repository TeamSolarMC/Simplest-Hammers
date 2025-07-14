package net.teamsolar.simplest_hammers;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.teamsolar.simplest_hammers.datagen.ModBlockTagGenerator;
import net.teamsolar.simplest_hammers.datagen.ModItemModelProvider;
import net.teamsolar.simplest_hammers.datagen.ModItemTagGenerator;
import net.teamsolar.simplest_hammers.datagen.ModRecipeProvider;

public class SimplestHammersDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModBlockTagGenerator::new);
        pack.addProvider(ModItemTagGenerator::new);
        pack.addProvider(ModRecipeProvider::new);
        pack.addProvider(ModItemModelProvider::new);
    }
}
