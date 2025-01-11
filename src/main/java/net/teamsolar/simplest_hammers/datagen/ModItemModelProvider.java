package net.teamsolar.simplest_hammers.datagen;

import net.teamsolar.simplest_hammers.SimplestHammers;
import net.teamsolar.simplest_hammers.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SimplestHammers.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        handheldItem(ModItems.WOODEN_HAMMER);
        handheldItem(ModItems.STONE_HAMMER);
        handheldItem(ModItems.IRON_HAMMER);
        handheldItem(ModItems.GOLDEN_HAMMER);
        handheldItem(ModItems.DIAMOND_HAMMER);
        handheldItem(ModItems.NETHERITE_HAMMER);

        simpleItem(ModItems.HAMMER_SMITHING_TEMPLATE);
    }

    private <T extends Item> ItemModelBuilder handheldItem(DeferredItem<T> item) {
        return withExistingParent(item.getId().getPath(),
                mcLoc("item/handheld")).texture("layer0",
                modLoc("item/" + item.getId().getPath()));
    }

    private <T extends Item>  ItemModelBuilder simpleItem(DeferredItem<T> item) {
        return withExistingParent(item.getId().getPath(),
                mcLoc("item/generated")).texture("layer0",
                modLoc("item/" + item.getId().getPath()));
    }
}
