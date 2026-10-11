package net.teamsolar.simplest_hammers.datagen;

import net.minecraft.advancements.Advancement;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.MultiRegistryBootstrap;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.data.recipes.SmithingTransformRecipeBuilder;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.teamsolar.simplest_hammers.item.ModItems;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ModRecipeProvider extends RecipeProvider {
    protected ModRecipeProvider(BootstrapContext<Recipe<?>> recipeOutput, BootstrapContext<Advancement> advancementOutput) {
        super(recipeOutput, advancementOutput);
    }

    @Override
    protected void buildRecipes() {

        shaped(
                RecipeCategory.MISC,
                ModItems.HAMMER_SMITHING_TEMPLATE,
                2
        )
                .pattern("ABA")
                .pattern("ACA")
                .pattern("AAA")
                .define('A', Items.EMERALD)
                .define('B', ModItems.HAMMER_SMITHING_TEMPLATE)
                .define('C', Items.COBBLESTONE)
                .unlockedBy("has_hammer_template", has(ModItems.HAMMER_SMITHING_TEMPLATE.get()))
                .save(output);

        hammerSmithingRecipe(
                Ingredient.of(Items.WOODEN_PICKAXE),
                Ingredient.of(items.getOrThrow(ItemTags.LOGS)),
                ModItems.WOODEN_HAMMER.get()
        );
        hammerSmithingRecipe(
                Ingredient.of(Items.STONE_PICKAXE),
                Ingredient.of(Items.SMOOTH_STONE),
                ModItems.STONE_HAMMER.get()
        );
        hammerSmithingRecipe(
                Ingredient.of(Items.COPPER_PICKAXE),
                Ingredient.of(Items.COPPER_BLOCK.weathering().unaffected()),
                ModItems.COPPER_HAMMER.get()
        );
        hammerSmithingRecipe(
                Ingredient.of(Items.IRON_PICKAXE),
                Ingredient.of(Items.IRON_BLOCK),
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
                Ingredient.of(ModItems.WOODEN_HAMMER),
                Ingredient.of(Items.SMOOTH_STONE),
                ModItems.STONE_HAMMER.get()
        );
        // Alternative path: Stone -> Copper -> Iron / Stone -> Iron
        hammerUpgradeRecipe(
                Ingredient.of(ModItems.STONE_HAMMER),
                Ingredient.of(Items.COPPER_BLOCK.weathering().unaffected()),
                ModItems.COPPER_HAMMER.get()
        );
        // *
        hammerUpgradeRecipe(
                Ingredient.of(ModItems.STONE_HAMMER, ModItems.COPPER_HAMMER),
                Ingredient.of(Items.IRON_BLOCK),
                ModItems.IRON_HAMMER.get()
        );
        // Alternative path: Iron -> Gold -> Diamond / Iron -> Diamond
        hammerUpgradeRecipe(
                Ingredient.of(ModItems.IRON_HAMMER),
                Ingredient.of(Items.GOLD_BLOCK),
                ModItems.GOLDEN_HAMMER.get()
        );
        // *
        hammerUpgradeRecipe(
                Ingredient.of(ModItems.IRON_HAMMER, ModItems.GOLDEN_HAMMER),
                Ingredient.of(Items.DIAMOND_BLOCK),
                ModItems.DIAMOND_HAMMER.get()
        );
        netheriteSmithing(ModItems.DIAMOND_HAMMER.get(), RecipeCategory.MISC, ModItems.NETHERITE_HAMMER.get());

        basicBlastingAndSmeltingRecipe(ModItems.IRON_HAMMER.get(), Items.IRON_NUGGET);
        basicBlastingAndSmeltingRecipe(ModItems.COPPER_HAMMER.get(), Items.COPPER_NUGGET);
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
                        CookingBookCategory.MISC,
                        outputItem,
                        0.1F,
                        100
                )
                .unlockedBy("has_".concat(unqualifiedItemName), has(input))
                .save(output, unqualifiedItemName.concat("_blasting"));
        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(input),
                        RecipeCategory.MISC,
                        CookingBookCategory.MISC,
                        outputItem,
                        0.1F,
                        200
                )
                .unlockedBy("has_".concat(unqualifiedItemName), has(input))
                .save(output, unqualifiedItemName.concat("_smelting"));
    }

    public static MultiRegistryBootstrap create() {
        return new MultiRegistryBootstrap() {
            @Override
            public @NotNull Set<ResourceKey<? extends Registry<?>>> requestedRegistries() {
                return Set.of(Registries.RECIPE, Registries.ADVANCEMENT);
            }

            @Override
            public void run(@NotNull BootstrapGetter registries) {
                new ModRecipeProvider(
                        registries.get(Registries.RECIPE),
                        registries.get(Registries.ADVANCEMENT)
                ).buildRecipes();
            }
        };
    }
}
