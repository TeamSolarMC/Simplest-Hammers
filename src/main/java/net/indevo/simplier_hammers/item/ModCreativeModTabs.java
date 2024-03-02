package net.indevo.simplier_hammers.item;

import net.indevo.simplier_hammers.SimplierHammers;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SimplierHammers.MOD_ID);

    public static final RegistryObject<CreativeModeTab> SIMPLIER_HAMMERS_TAB = CREATIVE_MODE_TABS.register("simplier_hammers_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.NETHERITE_HAMMER.get()))
                    .title(Component.translatable("creativetab.simplier_hammers_tab"))
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.WOOD_HAMMER.get());
                        pOutput.accept(ModItems.STONE_HAMMER.get());
                        pOutput.accept(ModItems.IRON_HAMMER.get());
                        pOutput.accept(ModItems.GOLD_HAMMER.get());
                        pOutput.accept(ModItems.DIAMOND_HAMMER.get());
                        pOutput.accept(ModItems.NETHERITE_HAMMER.get());
                    }))
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
