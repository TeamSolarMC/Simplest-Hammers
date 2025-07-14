package net.teamsolar.simplest_hammers.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.teamsolar.simplest_hammers.item.ModItems;
import net.teamsolar.simplest_hammers.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends FabricTagProvider.ItemTagProvider {
    public ModItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    public String getName() {
        return "Item Tags";
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Items.HAMMERS)
                .add(
                        ModItems.WOODEN_HAMMER,
                        ModItems.STONE_HAMMER,
                        ModItems.GOLDEN_HAMMER,
                        ModItems.IRON_HAMMER,
                        ModItems.DIAMOND_HAMMER,
                        ModItems.NETHERITE_HAMMER
                );
    }
}
