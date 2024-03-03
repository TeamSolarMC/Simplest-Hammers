package net.indevo.simplest_hammers.util;

import net.indevo.simplest_hammers.SimplestHammers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> NEEDS_WOOD_TOOL = tag("needs_wood_tool");
        public static final TagKey<Block> NEEDS_STONE_TOOL = tag("needs_stone_tool");
        public static final TagKey<Block> NEEDS_IRON_TOOL = tag("needs_iron_tool");
        public static final TagKey<Block> NEEDS_GOLD_TOOL = tag("needs_gold_tool");
        public static final TagKey<Block> NEEDS_DIAMOND_TOOL = tag("needs_diamond_tool");
        public static final TagKey<Block> NEEDS_NETHERITE_TOOL = tag("needs_netherite_tool");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(SimplestHammers.MOD_ID, name));
        }
        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Items {
        public static final TagKey<Item> HAMMERS = forgeTag("hammers");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(SimplestHammers.MOD_ID, name));
        }
        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}
