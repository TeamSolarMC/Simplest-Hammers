package net.teamsolar.simplest_hammers.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import net.teamsolar.simplest_hammers.SimplestHammers;
import net.teamsolar.simplest_hammers.item.ModItems;
import net.teamsolar.simplest_hammers.util.ModTags;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, SimplestHammers.MODID);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        this.tag(ModTags.Items.HAMMERS)
                .add(
                        ModItems.WOODEN_HAMMER.get(),
                        ModItems.STONE_HAMMER.get(),
                        ModItems.GOLDEN_HAMMER.get(),
                        ModItems.IRON_HAMMER.get(),
                        ModItems.DIAMOND_HAMMER.get(),
                        ModItems.NETHERITE_HAMMER.get());
        this.tag(ItemTags.DURABILITY_ENCHANTABLE).addTag(ModTags.Items.HAMMERS);
        this.tag(ItemTags.MINING_ENCHANTABLE).addTag(ModTags.Items.HAMMERS);
        this.tag(ItemTags.MINING_LOOT_ENCHANTABLE).addTag(ModTags.Items.HAMMERS);
    }

    @Override
    public String getName() {
        return "Item Tags";
    }
}
