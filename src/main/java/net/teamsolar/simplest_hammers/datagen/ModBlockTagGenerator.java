package net.teamsolar.simplest_hammers.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.teamsolar.simplest_hammers.SimplestHammers;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider ){
        super(output, lookupProvider, SimplestHammers.MODID);
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
