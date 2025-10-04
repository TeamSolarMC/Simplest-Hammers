package net.teamsolar.simplest_hammers.item;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.teamsolar.simplest_hammers.SimplestHammers;
import net.teamsolar.simplest_hammers.item.custom.HammerItem;

import java.util.function.Function;

public class ModItems {
    public static final Item WOODEN_HAMMER = registerItem("wooden_hammer",
            setting -> new HammerItem(ToolMaterial.WOOD, 6, -3.4F, setting)); // 6, -3.4F
    public static final Item STONE_HAMMER = registerItem("stone_hammer",
            setting -> new HammerItem(ToolMaterial.STONE, 7, -3.4F, setting)); // 7, -3.4F
    public static final Item IRON_HAMMER = registerItem("iron_hammer",
            setting -> new HammerItem(ToolMaterial.IRON, 6, -3.3F, setting)); // 6, -3.3F
    public static final Item GOLDEN_HAMMER = registerItem("golden_hammer",
            setting -> new HammerItem(ToolMaterial.GOLD, 6, -3.2F, setting)); // 6, -3.2F
    public static final Item DIAMOND_HAMMER = registerItem("diamond_hammer",
            setting -> new HammerItem(ToolMaterial.DIAMOND, 5, -3.2F, setting)); // 5, -3.2F
    public static final Item NETHERITE_HAMMER = registerItem("netherite_hammer",
            setting -> new HammerItem(ToolMaterial.NETHERITE, 5, -3.2F, setting.fireproof())); // 5, -3.2F

    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(SimplestHammers.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SimplestHammers.MOD_ID, name)))));
    }

    public static void registerModItems() {
        SimplestHammers.LOGGER.info("Registering Items for {}", SimplestHammers.MOD_ID);
    }
}
