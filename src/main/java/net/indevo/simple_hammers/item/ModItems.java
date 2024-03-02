package net.indevo.simple_hammers.item;

import net.indevo.simple_hammers.SimpleHammers;
import net.indevo.simple_hammers.item.custom.HammerItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SimpleHammers.MOD_ID);

    public static final RegistryObject<Item> WOOD_HAMMER = ITEMS.register("wood_hammer",
            () -> new HammerItem(ModToolTiers.WOOD, 1, -2.8F, new Item.Properties().durability(88)));
    public static final RegistryObject<Item> STONE_HAMMER = ITEMS.register("stone_hammer",
            () -> new HammerItem(ModToolTiers.STONE, 1, -2.8F, new Item.Properties().durability(196)));
    public static final RegistryObject<Item> IRON_HAMMER = ITEMS.register("iron_hammer",
            () -> new HammerItem(ModToolTiers.IRON, 1, -2.8F, new Item.Properties().durability(375)));
    public static final RegistryObject<Item> GOLD_HAMMER = ITEMS.register("gold_hammer",
            () -> new HammerItem(ModToolTiers.GOLD, 1, -2.8F, new Item.Properties().durability(48)));
    public static final RegistryObject<Item> DIAMOND_HAMMER = ITEMS.register("diamond_hammer",
            () -> new HammerItem(ModToolTiers.DIAMOND, 1, -2.8F, new Item.Properties().durability(2341)));
    public static final RegistryObject<Item> NETHERITE_HAMMER = ITEMS.register("netherite_hammer",
            () -> new HammerItem(ModToolTiers.NETHERITE, 1, -2.8F, new Item.Properties().durability(3046)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
