package net.teamsolar.simplest_hammers.event;

// import net.neoforged.neoforge.event.vill*/age.WandererTradesEvent;

/*@EventBusSubscriber(modid = SimplestHammers.MODID)
public class ModWanderingTraderEvent {

    @SubscribeEvent
    public static void wanderingVillagerTrade(WandererTradesEvent event) {
        event.getRareTrades().add((level, pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 12),
                new ItemStack(ModItems.HAMMER_SMITHING_TEMPLATE.get(), 1),
                1, 2, 0.2f
        ));
    }
}*/


// Trades are now data driven
// (See https://github.com/neoforged/.github/blob/main/primers/26.1/index.md)