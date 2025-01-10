package net.indevo.simplest_hammers.item;

import net.indevo.simplest_hammers.SimplestHammers;
import net.indevo.simplest_hammers.item.custom.HammerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(SimplestHammers.MODID);

    public static final DeferredItem<HammerItem> WOODEN_HAMMER = ITEMS.register("wooden_hammer",
            () -> new HammerItem(
                    Tiers.WOOD,
                    new Item.Properties().durability(88).attributes(HammerItem.createAttributes(
                            Tiers.WOOD, 6.0F, -3.4F
                    )
                    )
            )
    );
    public static final DeferredItem<HammerItem> STONE_HAMMER = ITEMS.register("stone_hammer",
            () -> new HammerItem(
                    Tiers.STONE,
                    new Item.Properties().durability(196).attributes(HammerItem.createAttributes(
                                    Tiers.STONE, 7.0F, -3.4F
                            )
                    )
            )
    );
    public static final DeferredItem<HammerItem> IRON_HAMMER = ITEMS.register("iron_hammer",
            () -> new HammerItem(
                    Tiers.IRON,
                    new Item.Properties().durability(375).attributes(HammerItem.createAttributes(
                                Tiers.IRON, 6.0F, -3.3F
                            )
                    )
            )
    );
    public static final DeferredItem<HammerItem> GOLDEN_HAMMER = ITEMS.register("golden_hammer",
            () -> new HammerItem(
                    Tiers.GOLD,
                    new Item.Properties().durability(48).attributes(HammerItem.createAttributes(
                            Tiers.GOLD, 6.0F, -3.2F
                            )
                    )
            )
    );
    public static final DeferredItem<HammerItem> DIAMOND_HAMMER = ITEMS.register("diamond_hammer",
            () -> new HammerItem(
                    Tiers.DIAMOND,
                    new Item.Properties().durability(2341).attributes(HammerItem.createAttributes(
                            Tiers.DIAMOND, 5.0F, -3.2F
                            )
                    )
            )
    );
    public static final DeferredItem<HammerItem> NETHERITE_HAMMER = ITEMS.register("netherite_hammer",
            () -> new HammerItem(
                    Tiers.NETHERITE,
                    new Item.Properties().durability(3046).attributes(HammerItem.createAttributes(
                            Tiers.NETHERITE, 5.0F, -3.2F
                            )
                    )
            )
    );
    /*
    public static final DeferredItem<HammerItem> IRON_HAMMER = ITEMS.register("iron_hammer",
            () -> new HammerItem(Tiers.IRON, 6, -3.3F, new Item.Properties().durability(375)));
    public static final DeferredItem<HammerItem> GOLDEN_HAMMER = ITEMS.register("golden_hammer",
            () -> new HammerItem(Tiers.GOLD, 6, -3.2F, new Item.Properties().durability(48)));
    public static final DeferredItem<HammerItem> DIAMOND_HAMMER = ITEMS.register("diamond_hammer",
            () -> new HammerItem(Tiers.DIAMOND, 5, -3.2F, new Item.Properties().durability(2341)));
    public static final DeferredItem<HammerItem> NETHERITE_HAMMER = ITEMS.register("netherite_hammer",
            () -> new HammerItem(Tiers.NETHERITE, 5, -3.2F, new Item.Properties().durability(3046).fireResistant()));
*/
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
