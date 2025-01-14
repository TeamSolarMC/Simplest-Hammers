package net.teamsolar.simplest_hammers.datagen;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
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
import java.util.regex.Pattern;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture, SimplestHammers.MODID);
    }

    @Override
    protected void start() {
        add(
                "hammer_smithing_template_modifier_in_toolsmith_chests",
                toExistingLootPoolWithChance(
                        "chests/village/village_toolsmith",
                        0.75f,
                        ModItems.HAMMER_SMITHING_TEMPLATE.get()
                )
        );
        add(
                "hammer_smithing_template_modifier_in_armorer_chests",
                toExistingLootPoolWithChance(
                        "chests/village/village_armorer",
                        0.75f,
                        ModItems.HAMMER_SMITHING_TEMPLATE.get()
                )
        );
        add(
                "hammer_smithing_template_modifier_in_weaponsmith_chests",
                toExistingLootPoolWithChance(
                        "chests/village/village_weaponsmith",
                        0.75f,
                        ModItems.HAMMER_SMITHING_TEMPLATE.get()
                )
        );

        for(ResourceKey<LootTable> table: BuiltInLootTables.all()) {
            var key = table.location().getPath();
            // SimplestExcavators.getLogger().info("Datagen checking chest %s".formatted(key));
            if(key.startsWith("chests/village") && key.matches("chests/village/(.+_house)")) {
                // SimplestExcavators.getLogger().info("Adding chest loot modifier to %s".formatted(key));
                add(
                        "hammer_smithing_template_in_".concat(matchHouseType(key)),
                        toExistingLootPoolWithChance(
                                table.location(),
                                0.15f,
                                ModItems.HAMMER_SMITHING_TEMPLATE.get()
                        )
                );
            }
        }
    }

    private String matchHouseType(String key) {
        Pattern nameMatcher = Pattern.compile("chests/village/(.+_house)");
        var results = nameMatcher.matcher(key);
        results.find();
        return results.group(1);
        // SimplestExcavators.getLogger().info("%d".formatted(results.groupCount()));
        // SimplestExcavators.getLogger().info("%s".formatted(results.matches()));
    }

    private ModLootModifier toExistingLootPoolWithChance(ResourceLocation location, float chance, Item item) {
        return new ModLootModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(location)
                                .and(
                                        LootItemRandomChanceCondition.randomChance(chance)
                                ).build()
                },
                item
        );
    }
    private ModLootModifier toExistingLootPoolWithChance(String location, float chance, Item item) {
        return toExistingLootPoolWithChance(ResourceLocation.withDefaultNamespace(location), chance, item);
    }
}
