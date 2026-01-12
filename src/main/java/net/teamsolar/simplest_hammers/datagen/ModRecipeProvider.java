package net.teamsolar.simplest_hammers.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.teamsolar.simplest_hammers.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        super(provider, recipeOutput);
    }

    @Override
    protected void buildRecipes() {

        /*ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.IRON_HAMMER.get())
                .pattern("ABA")
                .pattern("ACA")
                .pattern(" C ")
                .define('A', Items.IRON_INGOT)
                .define('B', Items.IRON_BLOCK)
                .define('C', Items.STICK)
                .unlockedBy("has_iron_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.IRON_INGOT).build()))
                .unlockedBy("has_iron_block", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.IRON_BLOCK).build()))
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK).build()))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DIAMOND_HAMMER.get())
                .pattern("ABA")
                .pattern("ACA")
                .pattern(" C ")
                .define('A', Items.DIAMOND)
                .define('B', Items.DIAMOND_BLOCK)
                .define('C', Items.STICK)
                .unlockedBy("has_diamond", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.DIAMOND).build()))
                .unlockedBy("has_diamond_block", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.DIAMOND_BLOCK).build()))
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK).build()))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GOLDEN_HAMMER.get())
                .pattern("ABA")
                .pattern("ACA")
                .pattern(" C ")
                .define('A', Items.GOLD_INGOT)
                .define('B', Items.GOLD_BLOCK)
                .define('C', Items.STICK)
                .unlockedBy("has_gold_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.GOLD_INGOT).build()))
                .unlockedBy("has_gold_block", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.GOLD_BLOCK).build()))
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK).build()))
                .save(output);

         */

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, ModItems.HAMMER_SMITHING_TEMPLATE.toStack(2))
                .pattern("ABA")
                .pattern("ACA")
                .pattern("AAA")
                .define('A', Items.EMERALD)
                .define('B', ModItems.HAMMER_SMITHING_TEMPLATE)
                .define('C', Items.COBBLESTONE)
                .unlockedBy("has_hammer_template", has(ModItems.HAMMER_SMITHING_TEMPLATE.get()))
                .save(output);

        // netheriteSmithing(output, ModItems.DIAMOND_HAMMER.get(), RecipeCategory.MISC, ModItems.NETHERITE_HAMMER.get());

        /*
        SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(ModItems.HAMMER_SMITHING_TEMPLATE.get()), // ModItems.HAMMER_SMITHING_TEMPLATE.get(),
                Ingredient.of(Items.WOODEN_PICKAXE),
                Ingredient.of(ItemTags.PLANKS),
                RecipeCategory.TOOLS,
                ModItems.WOODEN_HAMMER.get()
        )
                .unlocks("has_hammer_template", hasInInventory(ModItems.HAMMER_SMITHING_TEMPLATE.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(SimplestHammers.MODID, "wooden_hammer_from_pickaxe"));
        */
        hammerSmithingRecipe(
                Ingredient.of(Items.WOODEN_PICKAXE),
                // Ingredient.of(BuiltInRegistries.ITEM.getOrThrow(ItemTags.LOGS)),
                Ingredient.of(items.getOrThrow(ItemTags.LOGS)),
                ModItems.WOODEN_HAMMER.get()
        );
        hammerSmithingRecipe(
                Ingredient.of(Items.STONE_PICKAXE),
                Ingredient.of(Items.SMOOTH_STONE),
                ModItems.STONE_HAMMER.get()
        );
        hammerSmithingRecipe(
                Ingredient.of(Items.IRON_PICKAXE),
                Ingredient.of(Items.IRON_BLOCK.asItem()),
                ModItems.IRON_HAMMER.get()
        );
        hammerSmithingRecipe(
                Ingredient.of(Items.GOLDEN_PICKAXE),
                Ingredient.of(Items.GOLD_BLOCK),
                ModItems.GOLDEN_HAMMER.get()
        );
        hammerSmithingRecipe(
                Ingredient.of(Items.DIAMOND_PICKAXE),
                Ingredient.of(Items.DIAMOND_BLOCK),
                ModItems.DIAMOND_HAMMER.get()
        );
        hammerSmithingRecipe(
                Ingredient.of(Items.NETHERITE_PICKAXE),
                Ingredient.of(Items.DIAMOND_BLOCK),
                ModItems.NETHERITE_HAMMER.get()
        );
        // Upgrades
        hammerUpgradeRecipe(
                Ingredient.of(ModItems.WOODEN_HAMMER.get()),
                Ingredient.of(Items.SMOOTH_STONE),
                ModItems.STONE_HAMMER.get()
        );
        hammerUpgradeRecipe(
                Ingredient.of(ModItems.STONE_HAMMER.get()),
                Ingredient.of(Items.IRON_BLOCK),
                ModItems.IRON_HAMMER.get()
        );
        hammerUpgradeRecipe(
                Ingredient.of(ModItems.IRON_HAMMER.get()),
                Ingredient.of(Items.GOLD_BLOCK),
                ModItems.GOLDEN_HAMMER.get()
        );
        hammerUpgradeRecipe(
                Ingredient.of(ModItems.GOLDEN_HAMMER.get()),
                Ingredient.of(Items.DIAMOND_BLOCK),
                ModItems.DIAMOND_HAMMER.get()
        );
        netheriteSmithing(ModItems.DIAMOND_HAMMER.get(), RecipeCategory.MISC, ModItems.NETHERITE_HAMMER.get());

        basicBlastingAndSmeltingRecipe(ModItems.IRON_HAMMER.get(), Items.IRON_NUGGET);
        basicBlastingAndSmeltingRecipe(ModItems.GOLDEN_HAMMER.get(), Items.GOLD_NUGGET);
    }

    private String itemNameWithoutNamespace(Item item) {
        return BuiltInRegistries.ITEM.getKey(item).getPath();
    }

    private void hammerSmithingRecipe(Ingredient base, Ingredient additional, Item outputItem) {
        SmithingTransformRecipeBuilder.smithing(
            Ingredient.of(ModItems.HAMMER_SMITHING_TEMPLATE.get()), // ModItems.HAMMER_SMITHING_TEMPLATE.get(),
            base,
            additional,
            RecipeCategory.TOOLS,
            outputItem
        )
            .unlocks("has_hammer_template", has(ModItems.HAMMER_SMITHING_TEMPLATE.get()))
            .save(output, itemNameWithoutNamespace(outputItem).concat("_from_pickaxe"));
    }
    private void hammerUpgradeRecipe(Ingredient base, Ingredient additional, Item outputItem) {
        SmithingTransformRecipeBuilder.smithing(
            Ingredient.of(ModItems.HAMMER_SMITHING_TEMPLATE.get()), // ModItems.HAMMER_SMITHING_TEMPLATE.get(),
            base,
            additional,
            RecipeCategory.TOOLS,
            outputItem
        )
            .unlocks("has_hammer_template", has(ModItems.HAMMER_SMITHING_TEMPLATE.get()))
            .save(output, itemNameWithoutNamespace(outputItem).concat("_from_upgrade"));
    }
    private void basicBlastingAndSmeltingRecipe(Item input, Item outputItem) {
        String unqualifiedItemName = itemNameWithoutNamespace(input);
        SimpleCookingRecipeBuilder.blasting(
                        Ingredient.of(input),
                        RecipeCategory.MISC,
                        outputItem,
                        0.1F,
                        100
                )
                .unlockedBy("has_".concat(unqualifiedItemName), has(input))
                .save(output, unqualifiedItemName.concat("_blasting"));
        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(input),
                        RecipeCategory.MISC,
                        outputItem,
                        0.1F,
                        200
                )
                .unlockedBy("has_".concat(unqualifiedItemName), has(input))
                .save(output, unqualifiedItemName.concat("_smelting"));
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> provider) {
            super(packOutput, provider);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new ModRecipeProvider(provider, recipeOutput);
        }

        @Override
        public String getName() {
            return "My Recipes";
        }
    }
}
