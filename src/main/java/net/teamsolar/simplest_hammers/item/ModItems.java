package net.teamsolar.simplest_hammers.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraft.world.item.ToolMaterial;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.teamsolar.simplest_hammers.SimplestHammers;
import net.teamsolar.simplest_hammers.item.custom.HammerItem;

import java.util.List;


public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(SimplestHammers.MODID);

    private static final ChatFormatting DESCRIPTION_FORMAT = ChatFormatting.BLUE;
    private static final ChatFormatting TITLE_FORMAT = ChatFormatting.GRAY;

    // Hammer durability will be 3x the durability of the vanilla pickaxe of the same tier.
    public static final DeferredItem<HammerItem> WOODEN_HAMMER = ITEMS.registerItem(
        "wooden_hammer", HammerItem::new, () -> HammerItem.hammerProperties(
            ToolMaterial.WOOD,
            new Item.Properties(),
            6.0F,
            -3.4F,
            177
        )
    );
    public static final DeferredItem<HammerItem> STONE_HAMMER = ITEMS.registerItem("stone_hammer",
        HammerItem::new, () -> HammerItem.hammerProperties(
            ToolMaterial.STONE,
            new Item.Properties(),
            7.0F,
            -3.4F,
            393
        )
    );
    public static final DeferredItem<HammerItem> COPPER_HAMMER = ITEMS.registerItem("copper_hammer",
            HammerItem::new, () -> HammerItem.hammerProperties(
                    ToolMaterial.COPPER,
                    new Item.Properties(),
                    7.0F,
                    0.6F - 4.0F,
                    570
            )
    );
    public static final DeferredItem<HammerItem> IRON_HAMMER = ITEMS.registerItem("iron_hammer",
        HammerItem::new, () -> HammerItem.hammerProperties(
            ToolMaterial.IRON,
            new Item.Properties(),
            6.0F,
            -3.3F,
            750
        )
    );
    public static final DeferredItem<HammerItem> GOLDEN_HAMMER = ITEMS.registerItem("golden_hammer",
        HammerItem::new, () -> HammerItem.hammerProperties(
            ToolMaterial.GOLD,
            new Item.Properties(),
            6.0F,
            -3.2F,
            96
        )
    );
    public static final DeferredItem<HammerItem> DIAMOND_HAMMER = ITEMS.registerItem("diamond_hammer",
        HammerItem::new, () -> HammerItem.hammerProperties(
            ToolMaterial.DIAMOND,
            new Item.Properties(),
            5.0F,
            -3.2F,
            4683
        )
    );
    public static final DeferredItem<HammerItem> NETHERITE_HAMMER = ITEMS.registerItem("netherite_hammer",
        HammerItem::new, () -> HammerItem.hammerProperties(
            ToolMaterial.NETHERITE,
            new Item.Properties().fireResistant(),
            5.0F,
            -3.2F,
                6093
        )
    );

    public static final DeferredItem<SmithingTemplateItem> HAMMER_SMITHING_TEMPLATE = ITEMS.registerItem("hammer_upgrade_smithing_template",
        ( properties) -> new SmithingTemplateItem(
            Component.translatable("item.simplest_hammers.hammer_upgrade_smithing_template.applies_to").withStyle(DESCRIPTION_FORMAT), // DESCRIPTION_FORMAT
            Component.translatable("item.simplest_hammers.hammer_upgrade_smithing_template.ingredients").withStyle(DESCRIPTION_FORMAT), // DESCRIPTION_FORMAT
            // Component.translatable("item.simplest_hammers.hammer_smithing_template.upgrade_description").withStyle(ChatFormatting.GRAY),
            // Upgrade descriptions were removed in 1.21.10
            Component.translatable("item.simplest_hammers.hammer_upgrade_smithing_template.base_slot_description"), // No formatting
            Component.translatable("item.simplest_hammers.hammer_upgrade_smithing_template.additions_slot_description"), // No formatting
            // Base slot empty icons
            List.of(
                // ResourceLocation.withDefaultNamespace("item/empty_slot_pickaxe"),
                // 1.21.10: Slot is now called container/slot/shovel
                // ?
                ResourceLocation.withDefaultNamespace("container/slot/pickaxe"),
                ResourceLocation.fromNamespaceAndPath(SimplestHammers.MODID, "container/slot/empty_slot_hammer")
            ),
            // Additional slot empty icons
            List.of(
                    ResourceLocation.fromNamespaceAndPath(SimplestHammers.MODID, "container/slot/empty_slot_block")
            ),
            properties
        )
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
