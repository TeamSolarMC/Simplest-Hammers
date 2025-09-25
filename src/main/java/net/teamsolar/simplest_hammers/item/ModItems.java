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
            new HammerItem(ToolMaterials.WOOD, new Item.Settings().maxDamage(88))); // 6, -3.4F
    public static final Item STONE_HAMMER = registerItem("stone_hammer",
            new HammerItem(ToolMaterials.STONE, new Item.Settings().maxDamage(196))); // 7, -3.4F
    public static final Item IRON_HAMMER = registerItem("iron_hammer",
            new HammerItem(ToolMaterials.IRON, new Item.Settings().maxDamage(375))); // 6, -3.3F
    public static final Item GOLDEN_HAMMER = registerItem("golden_hammer",
            new HammerItem(ToolMaterials.GOLD, new Item.Settings().maxDamage(48))); // 6, -3.2F
    public static final Item DIAMOND_HAMMER = registerItem("diamond_hammer",
            new HammerItem(ToolMaterials.DIAMOND, new Item.Settings().maxDamage(2341))); // 5, -3.2F
    public static final Item NETHERITE_HAMMER = registerItem("netherite_hammer",
            new HammerItem(ToolMaterials.NETHERITE, new Item.Settings().maxDamage(3046).fireproof())); // 5, -3.2F

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(SimplestHammers.MOD_ID, name), item);
    }

    public static void registerModItems() {
        SimplestHammers.LOGGER.info("Registering Items for {}", SimplestHammers.MOD_ID);
    }
}
