package net.indevo.simplest_hammers;

import com.mojang.logging.LogUtils;
import net.indevo.simplest_hammers.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(SimplestHammers.MOD_ID)
public class SimplestHammers
{
    public static final String MOD_ID = "simplest_hammers";
    private static final Logger LOGGER = LogUtils.getLogger();

    public SimplestHammers() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    if(event.getTabKey() == CreativeModeTabs.COMBAT) {
        event.accept(ModItems.WOODEN_HAMMER);
        event.accept(ModItems.STONE_HAMMER);
        event.accept(ModItems.IRON_HAMMER);
        event.accept(ModItems.GOLDEN_HAMMER);
        event.accept(ModItems.DIAMOND_HAMMER);
        event.accept(ModItems.NETHERITE_HAMMER);
        }
    if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
        event.accept(ModItems.WOODEN_HAMMER);
        event.accept(ModItems.STONE_HAMMER);
        event.accept(ModItems.IRON_HAMMER);
        event.accept(ModItems.GOLDEN_HAMMER);
        event.accept(ModItems.DIAMOND_HAMMER);
        event.accept(ModItems.NETHERITE_HAMMER);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
