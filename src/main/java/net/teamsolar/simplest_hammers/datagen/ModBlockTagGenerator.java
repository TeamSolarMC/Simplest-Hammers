package net.teamsolar.simplest_hammers.datagen;

import net.teamsolar.simplest_hammers.SimplestHammers;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                @Nullable ExistingFileHelper existingFileHelper ){
        super(output, lookupProvider, SimplestHammers.MODID, existingFileHelper);
    }

    // ?
    /*private static TagKey<Block> create(String p_203847_) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(p_203847_));
    }*/

    @Override
    protected void addTags(HolderLookup.Provider pProvider ){
        // ?
    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
