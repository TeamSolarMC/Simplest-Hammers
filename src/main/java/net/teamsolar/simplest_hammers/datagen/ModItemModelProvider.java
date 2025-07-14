package net.teamsolar.simplest_hammers.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.Item;
import net.teamsolar.simplest_hammers.item.ModItems;

public class ModItemModelProvider extends FabricModelProvider {

    public ModItemModelProvider(FabricDataOutput output) {
        super(output);
    }

    private void handheldItem(ItemModelGenerator itemModelGenerator, Item item) {
        itemModelGenerator.register(item, Models.HANDHELD);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {}

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        handheldItem(itemModelGenerator, ModItems.WOODEN_HAMMER);
        handheldItem(itemModelGenerator, ModItems.STONE_HAMMER);
        handheldItem(itemModelGenerator, ModItems.IRON_HAMMER);
        handheldItem(itemModelGenerator, ModItems.GOLDEN_HAMMER);
        handheldItem(itemModelGenerator, ModItems.DIAMOND_HAMMER);
        handheldItem(itemModelGenerator, ModItems.NETHERITE_HAMMER);
    }
}
