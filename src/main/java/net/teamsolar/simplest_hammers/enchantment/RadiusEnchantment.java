//package net.indevo.simplest_hammers.enchantment;
//
//import net.indevo.simplest_hammers.item.custom.HammerItem;
//import net.minecraft.core.BlockPos;
//import net.minecraft.server.level.ServerLevel;
//import net.minecraft.world.entity.*;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.enchantment.Enchantment;
//import net.minecraft.world.item.enchantment.EnchantmentCategory;
//
//public class RadiusEnchantment extends Enchantment {
//    protected RadiusEnchantment(Rarity pRarity, EquipmentSlot... pApplicableSlots) {
//        super(pRarity, EnchantmentCategory.WEAPON, pApplicableSlots);
//    }
//
//    @Override
//    public boolean canApplyAtEnchantingTable(ItemStack stack) {
//        return super.canApplyAtEnchantingTable(stack) && stack.getItem() instanceof HammerItem;
//    }
//
//    @Override
//    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
//        if (pAttacker.level().isClientSide()) {
//            ServerLevel level = ((ServerLevel) pAttacker.level());
//            BlockPos position = pTarget.blockPosition();
//        }
//
//        super.doPostAttack(pAttacker, pTarget, pLevel);
//    }
//
//    @Override
//    public boolean canEnchant(ItemStack pStack) {
//        return pStack.getItem() instanceof HammerItem;
//    }
//
//    @Override
//    public int getMaxLevel() {
//        return 1;
//    }
//}