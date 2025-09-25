package net.teamsolar.simplest_hammers.util;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.teamsolar.simplest_hammers.SimplestHammers;

public class ModTags {
    public static class Items {
        public static final TagKey<Item> HAMMERS = tag("hammers");

        private static TagKey<Item> tag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(SimplestHammers.MOD_ID, name));
        }
    }
}
