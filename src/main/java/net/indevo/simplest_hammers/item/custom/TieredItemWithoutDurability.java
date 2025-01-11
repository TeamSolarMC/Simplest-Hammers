package net.indevo.simplest_hammers.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

public class TieredItemWithoutDurability extends Item {
    private final Tier tier;

    public TieredItemWithoutDurability(Tier tier, Item.Properties properties) {
        super(properties);
        this.tier = tier;
    }

    public Tier getTier() {
        return this.tier;
    }

    @SuppressWarnings("deprecation")
    @Override
    public int getEnchantmentValue() {
        return this.tier.getEnchantmentValue();
    }

    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return this.tier.getRepairIngredient().test(repair) || super.isValidRepairItem(toRepair, repair);
    }
}
