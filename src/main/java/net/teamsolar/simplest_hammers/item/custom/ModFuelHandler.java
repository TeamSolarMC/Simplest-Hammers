package net.teamsolar.simplest_hammers.item.custom;

import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.teamsolar.simplest_hammers.SimplestHammers;
import net.teamsolar.simplest_hammers.item.ModItems;

@Mod.EventBusSubscriber(modid = SimplestHammers.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModFuelHandler {

    @SubscribeEvent
    public static void onFurnaceFuel(FurnaceFuelBurnTimeEvent event) {
        if (event.getItemStack().is(ModItems.WOODEN_HAMMER.get())) {
            event.setBurnTime(200);
        }
    }
}