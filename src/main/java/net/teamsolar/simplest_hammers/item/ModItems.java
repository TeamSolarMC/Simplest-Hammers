package net.teamsolar.simplest_hammers.item;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.teamsolar.simplest_hammers.SimplestHammers;
import net.teamsolar.simplest_hammers.item.custom.HammerItem;

public class ModItems {
    public static final Item WOODEN_HAMMER = registerItem("wooden_hammer",
            new HammerItem(6, -3.4F, ToolMaterials.WOOD, new Item.Settings().maxDamage(88)));
    public static final Item STONE_HAMMER = registerItem("stone_hammer",
            new HammerItem(7, -3.4F, ToolMaterials.STONE, new Item.Settings().maxDamage(196)));
    public static final Item IRON_HAMMER = registerItem("iron_hammer",
            new HammerItem(6, -3.3F, ToolMaterials.IRON, new Item.Settings().maxDamage(375)));
    public static final Item GOLDEN_HAMMER = registerItem("golden_hammer",
            new HammerItem(6, -3.2F, ToolMaterials.GOLD, new Item.Settings().maxDamage(48)));
    public static final Item DIAMOND_HAMMER = registerItem("diamond_hammer",
            new HammerItem(5, -3.2F, ToolMaterials.DIAMOND, new Item.Settings().maxDamage(2341)));
    public static final Item NETHERITE_HAMMER = registerItem("netherite_hammer",
            new HammerItem(5, -3.2F, ToolMaterials.NETHERITE, new Item.Settings().maxDamage(3046).fireproof()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(SimplestHammers.MOD_ID, name), item);
    }

    public static void registerModItems() {
        SimplestHammers.LOGGER.info("Registering Items for {}", SimplestHammers.MOD_ID);
    }
}
