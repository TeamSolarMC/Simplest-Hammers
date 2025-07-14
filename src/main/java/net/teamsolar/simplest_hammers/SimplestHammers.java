package net.teamsolar.simplest_hammers;

import com.mojang.logging.LogUtils;
import net.fabricmc.api.ModInitializer;
import net.teamsolar.simplest_hammers.event.ModEvents;
import net.teamsolar.simplest_hammers.item.ModCreativeTab;
import net.teamsolar.simplest_hammers.item.ModItems;
import net.teamsolar.simplest_hammers.item.custom.ModFuelHandler;
import org.slf4j.Logger;

public class SimplestHammers implements ModInitializer
{
    public static final String MOD_ID = "simplest_hammers";
    public static final Logger LOGGER = LogUtils.getLogger();

    @Override
    public void onInitialize() {
        ModItems.registerModItems();
        ModCreativeTab.registerCreativeTab();
        ModEvents.registerEvents();
        ModFuelHandler.registerFuels();
    }
}
