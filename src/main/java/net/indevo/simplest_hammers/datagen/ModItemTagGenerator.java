package net.indevo.simplest_hammers.datagen;

import net.indevo.simplest_hammers.SimplestHammers;
import net.indevo.simplest_hammers.item.ModItems;
import net.indevo.simplest_hammers.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> future,
                               CompletableFuture<TagLookup<Block>> completableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, future, completableFuture, SimplestHammers.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
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
