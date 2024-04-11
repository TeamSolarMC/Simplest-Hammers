//package net.indevo.simplest_hammers.enchantment;
//
//import net.indevo.simplest_hammers.item.custom.HammerItem;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.item.enchantment.EnchantmentCategory;
//import net.minecraftforge.common.IExtensibleEnum;
//
//public enum ModEnchantmentCategory implements IExtensibleEnum {
//    HAMMER {
//        public boolean canEnchant(Item item) {
//            return item instanceof HammerItem;
//        }
//    };
//
//
//    private java.util.function.Predicate<Item> delegate;
//
//    private ModEnchantmentCategory() {}
//
//    private ModEnchantmentCategory(java.util.function.Predicate<Item> delegate) {
//        this.delegate = delegate;
//    }
//
//    public static EnchantmentCategory create(String name, java.util.function.Predicate<Item> delegate) {
//        throw new IllegalStateException("Enum not extended");
//    }
//
//    public boolean canEnchant(Item pItem) {
//        return this.delegate == null ? false : this.delegate.test(pItem);
//    }
//}
