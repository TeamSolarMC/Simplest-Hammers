package net.teamsolar.simplest_hammers.event;

import net.teamsolar.simplest_hammers.SimplestHammers;
import net.teamsolar.simplest_hammers.item.ModItems;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.village.WandererTradesEvent;

@EventBusSubscriber(modid = SimplestHammers.MODID)
public class ModWanderingTraderEvent {

    @SubscribeEvent
    public static void wanderingVillagerTrade(WandererTradesEvent event) {
        event.getRareTrades().add((level, pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 12),
                new ItemStack(ModItems.HAMMER_SMITHING_TEMPLATE.get(), 1),
                1, 2, 0.2f
        ));
    }
}