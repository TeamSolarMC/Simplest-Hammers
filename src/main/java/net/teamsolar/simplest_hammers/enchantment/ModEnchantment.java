//package net.indevo.simplest_hammers.enchantment;
//
//import net.indevo.simplest_hammers.SimplestHammers;
//import net.minecraft.world.entity.EquipmentSlot;
//import net.minecraft.world.item.enchantment.Enchantment;
//import net.minecraft.world.item.enchantment.EnchantmentCategory;
//import net.minecraftforge.eventbus.api.IEventBus;
//import net.minecraftforge.registries.DeferredRegister;
//import net.minecraftforge.registries.ForgeRegistries;
//import net.minecraftforge.registries.RegistryObject;
//
//public class ModEnchantment {
//    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
//            DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, SimplestHammers.MOD_ID);
//
//    public static final RegistryObject<Enchantment> RADIUS =
//            ENCHANTMENTS.register("radius",
//                    () -> new RadiusEnchantment(Enchantment.Rarity.UNCOMMON,
//                            EquipmentSlot.MAINHAND));
//
//    public static void register(IEventBus eventBus) {
//        ENCHANTMENTS.register(eventBus);
//    }
//}
