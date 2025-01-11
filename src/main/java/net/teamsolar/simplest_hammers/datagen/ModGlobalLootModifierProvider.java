package net.teamsolar.simplest_hammers.datagen;

import net.teamsolar.simplest_hammers.SimplestHammers;
import net.teamsolar.simplest_hammers.loot.ModLootModifier;
import net.teamsolar.simplest_hammers.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture, SimplestHammers.MODID);
    }

    @Override
    protected void start() {
        add(
                "hammer_smithing_template_modifier_in_toolsmith_chests",
                new ModLootModifier(
                        new LootItemCondition[]{
                                LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("chests/village/village_toolsmith"))
                                        .and(
                                                LootItemRandomChanceCondition.randomChance(0.75f)
                                        ).build()
                        },
                        ModItems.HAMMER_SMITHING_TEMPLATE.get()
                )
        );
        add(
                "hammer_smithing_template_modifier_in_armorer_chests",
                new ModLootModifier(
                        new LootItemCondition[]{
                                LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("chests/village/village_armorer"))
                                        .and(
                                                LootItemRandomChanceCondition.randomChance(0.75f)
                                        ).build()
                        },
                        ModItems.HAMMER_SMITHING_TEMPLATE.get()
                )
        );
        add(
                "hammer_smithing_template_modifier_in_weaponsmith_chests",
                new ModLootModifier(
                        new LootItemCondition[]{
                                LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("chests/village/village_weaponsmith"))
                                        .and(
                                                LootItemRandomChanceCondition.randomChance(0.75f)
                                        ).build()
                        },
                        ModItems.HAMMER_SMITHING_TEMPLATE.get()
                )
        );
    }
}
