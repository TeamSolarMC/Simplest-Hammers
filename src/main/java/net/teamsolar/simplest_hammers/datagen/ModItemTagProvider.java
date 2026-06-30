package net.teamsolar.simplest_hammers.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagAppender;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import net.teamsolar.simplest_hammers.SimplestHammers;
import net.teamsolar.simplest_hammers.item.ModItems;
import net.teamsolar.simplest_hammers.util.ModTags;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, SimplestHammers.MODID);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        TagAppender<Item> builder = this.tag(ModTags.Items.HAMMERS);
        builder.addAll(
                List.of(
                        ModItems.WOODEN_HAMMER.getKey(),
                        ModItems.STONE_HAMMER.getKey(),
                        ModItems.COPPER_HAMMER.getKey(),
                        ModItems.IRON_HAMMER.getKey(),
                        ModItems.DIAMOND_HAMMER.getKey(),
                        ModItems.GOLDEN_HAMMER.getKey(),
                        ModItems.NETHERITE_HAMMER.getKey()
                )
        );
        this.tag(ItemTags.DURABILITY_ENCHANTABLE).addTag(ModTags.Items.HAMMERS);
        this.tag(ItemTags.MINING_ENCHANTABLE).addTag(ModTags.Items.HAMMERS);
        this.tag(ItemTags.MINING_LOOT_ENCHANTABLE).addTag(ModTags.Items.HAMMERS);
    }

    @Override
    public String getName() {
        return "Item Tags";
    }
}
