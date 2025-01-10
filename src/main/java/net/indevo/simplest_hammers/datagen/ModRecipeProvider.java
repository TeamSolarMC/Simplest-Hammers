package net.indevo.simplest_hammers.datagen;

import com.mojang.serialization.Decoder;
import net.indevo.simplest_hammers.SimplestHammers;
import net.indevo.simplest_hammers.item.ModItems;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;
import java.util.regex.Pattern;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput output) {

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

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HAMMER_SMITHING_TEMPLATE.get(), 2)
                .pattern("ABA")
                .pattern("ACA")
                .pattern("AAA")
                .define('A', Items.EMERALD)
                .define('B', ModItems.HAMMER_SMITHING_TEMPLATE)
                .define('C', Items.COBBLESTONE)
                .unlockedBy("has_hammer_template", hasInInventory(ModItems.HAMMER_SMITHING_TEMPLATE.get()))
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
                Ingredient.of(ItemTags.PLANKS),
                ModItems.WOODEN_HAMMER.get(),
                output
        );
        hammerSmithingRecipe(
                Ingredient.of(Items.STONE_PICKAXE),
                Ingredient.of(Items.SMOOTH_STONE),
                ModItems.STONE_HAMMER.get(),
                output
        );
        hammerSmithingRecipe(
                Ingredient.of(Items.IRON_PICKAXE),
                Ingredient.of(Items.IRON_BLOCK.asItem()),
                ModItems.IRON_HAMMER.get(),
                output
        );
        hammerSmithingRecipe(
                Ingredient.of(Items.GOLDEN_PICKAXE),
                Ingredient.of(Items.GOLD_BLOCK),
                ModItems.GOLDEN_HAMMER.get(),
                output
        );
        hammerSmithingRecipe(
                Ingredient.of(Items.DIAMOND_PICKAXE),
                Ingredient.of(Items.DIAMOND_BLOCK),
                ModItems.DIAMOND_HAMMER.get(),
                output
        );
        hammerSmithingRecipe(
                Ingredient.of(Items.NETHERITE_PICKAXE),
                Ingredient.of(Items.NETHERITE_INGOT),
                ModItems.NETHERITE_HAMMER.get(),
                output
        );
        // Upgrades
        hammerUpgradeRecipe(
                Ingredient.of(ModItems.WOODEN_HAMMER.get()),
                Ingredient.of(Items.SMOOTH_STONE),
                ModItems.STONE_HAMMER.get(),
                output
        );
        hammerUpgradeRecipe(
                Ingredient.of(ModItems.STONE_HAMMER.get()),
                Ingredient.of(Items.IRON_BLOCK),
                ModItems.IRON_HAMMER.get(),
                output
        );
        hammerUpgradeRecipe(
                Ingredient.of(ModItems.IRON_HAMMER.get()),
                Ingredient.of(Items.GOLD_BLOCK),
                ModItems.GOLDEN_HAMMER.get(),
                output
        );
        hammerUpgradeRecipe(
                Ingredient.of(ModItems.GOLDEN_HAMMER.get()),
                Ingredient.of(Items.DIAMOND_BLOCK),
                ModItems.DIAMOND_HAMMER.get(),
                output
        );
        /* hammerUpgradeRecipe(
                Ingredient.of(ModItems.DIAMOND_HAMMER.get()),
                Ingredient.of(Items.NETHERITE_INGOT),
                ModItems.NETHERITE_HAMMER.get(),
                output
        ); */
        netheriteSmithing(output, ModItems.DIAMOND_HAMMER.get(), RecipeCategory.MISC, ModItems.NETHERITE_HAMMER.get());
    }
    private Criterion<InventoryChangeTrigger.TriggerInstance> hasInInventory(ItemLike item) {
        return inventoryTrigger(ItemPredicate.Builder.item()
                .of(item).build());
    }

    private String stripModId(String itemString) {
        /*LOGGER.info(itemString);
        Pattern pattern = Pattern.compile("(.+):(.+)");
        var matches = pattern.matcher(itemString);
        return matches.group(2);*/
        return itemString.substring(SimplestHammers.MODID.length() + 1);
    }

    private void hammerSmithingRecipe(Ingredient base, Ingredient additional, Item outputItem, RecipeOutput output) {
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.HAMMER_SMITHING_TEMPLATE.get()), // ModItems.HAMMER_SMITHING_TEMPLATE.get(),
                        base,
                        additional,
                        RecipeCategory.TOOLS,
                        outputItem
                )
                .unlocks("has_hammer_template", hasInInventory(ModItems.HAMMER_SMITHING_TEMPLATE.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(SimplestHammers.MODID, stripModId(outputItem.toString()).concat("_from_pickaxe")));
    }
    private void hammerUpgradeRecipe(Ingredient base, Ingredient additional, Item outputItem, RecipeOutput output) {
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.HAMMER_SMITHING_TEMPLATE.get()), // ModItems.HAMMER_SMITHING_TEMPLATE.get(),
                        base,
                        additional,
                        RecipeCategory.TOOLS,
                        outputItem
                )
                .unlocks("has_hammer_template", hasInInventory(ModItems.HAMMER_SMITHING_TEMPLATE.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(SimplestHammers.MODID, stripModId(outputItem.toString()).concat("_from_upgrade")));
    }

}
