package net.indevo.simplest_hammers.datagen;

import net.indevo.simplest_hammers.SimplestHammers;
import net.indevo.simplest_hammers.item.ModItems;
import net.indevo.simplest_hammers.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> future,
                               CompletableFuture<TagLookup<Block>> completableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, future, completableFuture, SimplestHammers.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Items.HAMMERS)
                .add(
                        ModItems.WOODEN_HAMMER.get(),
                        ModItems.STONE_HAMMER.get(),
                        ModItems.GOLDEN_HAMMER.get(),
                        ModItems.IRON_HAMMER.get(),
                        ModItems.DIAMOND_HAMMER.get(),
                        ModItems.NETHERITE_HAMMER.get());
    }

    @Override
    public String getName() {
        return "Item Tags";
    }
}
