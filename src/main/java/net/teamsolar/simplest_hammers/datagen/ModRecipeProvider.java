package net.teamsolar.simplest_hammers.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.teamsolar.simplest_hammers.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> IRON_HAMMER = List.of(ModItems.IRON_HAMMER);
    private static final List<ItemConvertible> GOLDEN_HAMMER = List.of(ModItems.GOLDEN_HAMMER);

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                createShaped(RecipeCategory.MISC, ModItems.IRON_HAMMER)
                        .pattern("ABA")
                        .pattern("ACA")
                        .pattern(" C ")
                        .input('A', Items.IRON_INGOT)
                        .input('B', Items.IRON_BLOCK)
                        .input('C', Items.STICK)
                        .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                        .criterion(hasItem(Items.IRON_BLOCK), conditionsFromItem(Items.IRON_INGOT))
                        .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                        .offerTo(exporter,getRecipeName(ModItems.WOODEN_HAMMER) + "_");

                createShaped(RecipeCategory.MISC, ModItems.DIAMOND_HAMMER)
                        .pattern("ABA")
                        .pattern("ACA")
                        .pattern(" C ")
                        .input('A', Items.DIAMOND)
                        .input('B', Items.DIAMOND_BLOCK)
                        .input('C', Items.STICK)
                        .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                        .criterion(hasItem(Items.DIAMOND_BLOCK), conditionsFromItem(Items.DIAMOND_BLOCK))
                        .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                        .offerTo(exporter,getRecipeName(ModItems.DIAMOND_HAMMER) + "_");

                createShaped(RecipeCategory.MISC, ModItems.GOLDEN_HAMMER)
                        .pattern("ABA")
                        .pattern("ACA")
                        .pattern(" C ")
                        .input('A', Items.GOLD_INGOT)
                        .input('B', Items.GOLD_BLOCK)
                        .input('C', Items.STICK)
                        .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                        .criterion(hasItem(Items.GOLD_BLOCK), conditionsFromItem(Items.GOLD_BLOCK))
                        .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                        .offerTo(exporter, getRecipeName(ModItems.GOLDEN_HAMMER));

                createShaped(RecipeCategory.MISC, ModItems.WOODEN_HAMMER)
                        .pattern("AAA")
                        .pattern("ACA")
                        .pattern(" C ")
                        .input('A', ItemTags.LOGS)
                        .input('C', Items.STICK)
                        .criterion("has_logs", conditionsFromTag(ItemTags.LOGS))
                        .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                        .offerTo(exporter, getRecipeName(ModItems.WOODEN_HAMMER));

                createShaped(RecipeCategory.MISC, ModItems.STONE_HAMMER)
                        .pattern("AAA")
                        .pattern("ACA")
                        .pattern(" C ")
                        .input('A', Items.SMOOTH_STONE)
                        .input('C', Items.STICK)
                        .criterion(hasItem(Items.SMOOTH_STONE), conditionsFromItem(Items.SMOOTH_STONE))
                        .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                        .offerTo(exporter, getRecipeName(ModItems.STONE_HAMMER));

                offerNetheriteUpgradeRecipe(ModItems.DIAMOND_HAMMER, RecipeCategory.MISC, ModItems.NETHERITE_HAMMER);
                offerSmelting(IRON_HAMMER, RecipeCategory.MISC, Items.IRON_NUGGET, 0.1f, 200, "iron");
                offerBlasting(IRON_HAMMER, RecipeCategory.MISC, Items.IRON_NUGGET, 0.1f, 100, "iron");
                offerSmelting(GOLDEN_HAMMER, RecipeCategory.MISC, Items.GOLD_NUGGET, 0.1f, 200, "gold");
                offerBlasting(GOLDEN_HAMMER, RecipeCategory.MISC, Items.GOLD_NUGGET, 0.1f, 100, "gold");
            }
        };
    }

    @Override
    public String getName() {
        return "Simplest Hammers Refabricated Recipes";
    }
}
