package net.teamsolar.simplest_hammers.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.teamsolar.simplest_hammers.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> IRON_HAMMER = List.of(ModItems.IRON_HAMMER);
    private static final List<ItemConvertible> GOLDEN_HAMMER = List.of(ModItems.GOLDEN_HAMMER);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.IRON_HAMMER)
                .pattern("ABA")
                .pattern("ACA")
                .pattern(" C ")
                .input('A', Items.IRON_INGOT)
                .input('B', Items.IRON_BLOCK)
                .input('C', Items.STICK)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.IRON_BLOCK), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.WOODEN_HAMMER) + "_"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DIAMOND_HAMMER)
                .pattern("ABA")
                .pattern("ACA")
                .pattern(" C ")
                .input('A', Items.DIAMOND)
                .input('B', Items.DIAMOND_BLOCK)
                .input('C', Items.STICK)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(Items.DIAMOND_BLOCK), conditionsFromItem(Items.DIAMOND_BLOCK))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.DIAMOND_HAMMER) + "_"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GOLDEN_HAMMER)
                .pattern("ABA")
                .pattern("ACA")
                .pattern(" C ")
                .input('A', Items.GOLD_INGOT)
                .input('B', Items.GOLD_BLOCK)
                .input('C', Items.STICK)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.GOLD_BLOCK), conditionsFromItem(Items.GOLD_BLOCK))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GOLDEN_HAMMER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.WOODEN_HAMMER)
                .pattern("AAA")
                .pattern("ACA")
                .pattern(" C ")
                .input('A', ItemTags.LOGS)
                .input('C', Items.STICK)
                .criterion("has_logs", conditionsFromTag(ItemTags.LOGS))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.WOODEN_HAMMER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.STONE_HAMMER)
                .pattern("AAA")
                .pattern("ACA")
                .pattern(" C ")
                .input('A', Items.SMOOTH_STONE)
                .input('C', Items.STICK)
                .criterion(hasItem(Items.SMOOTH_STONE), conditionsFromItem(Items.SMOOTH_STONE))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.STONE_HAMMER)));

        offerNetheriteUpgradeRecipe(exporter, ModItems.DIAMOND_HAMMER, RecipeCategory.MISC, ModItems.NETHERITE_HAMMER);
        offerSmelting(exporter, IRON_HAMMER, RecipeCategory.MISC, Items.IRON_NUGGET, 0.1f, 200, "iron");
        offerBlasting(exporter, IRON_HAMMER, RecipeCategory.MISC, Items.IRON_NUGGET, 0.1f, 100, "iron");
        offerSmelting(exporter, GOLDEN_HAMMER, RecipeCategory.MISC, Items.GOLD_NUGGET, 0.1f, 200, "gold");
        offerBlasting(exporter, GOLDEN_HAMMER, RecipeCategory.MISC, Items.GOLD_NUGGET, 0.1f, 100, "gold");
    }
}
