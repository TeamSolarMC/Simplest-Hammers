package net.indevo.simplest_hammers.item;

import net.indevo.simplest_hammers.SimplestHammers;
import net.indevo.simplest_hammers.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier WOOD = TierSortingRegistry.registerTier(
            new ForgeTier(0, 88, 1.0F, 1.0F, 15,
                    ModTags.Blocks.NEEDS_WOOD_TOOL, () -> Ingredient.of(ItemTags.PLANKS)),
            new ResourceLocation(SimplestHammers.MOD_ID, "planks"), List.of(Tiers.WOOD), List.of());

    public static final Tier STONE = TierSortingRegistry.registerTier(
            new ForgeTier(1, 196, 2.0F, 2.0F, 5,
                    ModTags.Blocks.NEEDS_STONE_TOOL, () -> Ingredient.of(ItemTags.STONE_TOOL_MATERIALS)),
            new ResourceLocation(SimplestHammers.MOD_ID, "stone"), List.of(Tiers.STONE), List.of());

    public static final Tier IRON = TierSortingRegistry.registerTier(
            new ForgeTier(2, 375, 4.0F, 3.0F, 14,
                    ModTags.Blocks.NEEDS_IRON_TOOL, () -> Ingredient.of(Items.IRON_INGOT)),
            new ResourceLocation(SimplestHammers.MOD_ID, "iron_ingot"), List.of(Tiers.IRON), List.of());

    public static final Tier GOLD = TierSortingRegistry.registerTier(
            new ForgeTier(0, 48, 8.0F, 1.0F, 22,
                    ModTags.Blocks.NEEDS_GOLD_TOOL, () -> Ingredient.of(Items.GOLD_INGOT)),
            new ResourceLocation(SimplestHammers.MOD_ID, "gold_ingot"), List.of(Tiers.GOLD), List.of());

    public static final Tier DIAMOND = TierSortingRegistry.registerTier(
            new ForgeTier(3, 2341, 6.0F, 4.0F, 10,
                    ModTags.Blocks.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(Items.DIAMOND)),
            new ResourceLocation(SimplestHammers.MOD_ID, "diamond"), List.of(Tiers.DIAMOND), List.of());

    public static final Tier NETHERITE = TierSortingRegistry.registerTier(
            new ForgeTier(4, 3046, 7.0F, 5.0F, 15,
                    ModTags.Blocks.NEEDS_NETHERITE_TOOL, () -> Ingredient.of(Items.NETHERITE_INGOT)),
            new ResourceLocation(SimplestHammers.MOD_ID, "netherite_ingot"), List.of(Tiers.NETHERITE), List.of());

}
