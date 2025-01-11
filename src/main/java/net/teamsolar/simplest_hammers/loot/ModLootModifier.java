package net.teamsolar.simplest_hammers.loot;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.LootModifier;

// When applied, adds 1 item (specified by the constructor) to village toolsmith chests with a count of 1.
public class ModLootModifier extends LootModifier {
    // See below for how the codec works.
    public static final MapCodec<ModLootModifier> CODEC = RecordCodecBuilder.mapCodec(inst ->
            // LootModifier#codecStart adds the conditions field.
            LootModifier.codecStart(inst).and(
                    BuiltInRegistries.ITEM.byNameCodec().fieldOf("item").forGetter(e -> e.item)
            ).apply(inst, ModLootModifier::new)
    );
    // Our extra properties.
    private final Item item;

    // First constructor parameter is the list of conditions. The rest is our extra properties.
    public ModLootModifier(LootItemCondition[] conditions, Item item) {
        super(conditions);
        this.item = item;
    }

    // Return our codec here.
    @Override
    public MapCodec<ModLootModifier> codec() {
        return CODEC;
    }

    // This is where the magic happens. Use your extra properties here if needed.
    // Parameters are the existing loot, and the loot context.
    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        // ResourceLocation lootTableId = context.getQueriedLootTableId();
        // SimplestHammers.getLogger().info("Loot table %s; %s".formatted(lootTableId.getNamespace(), lootTableId.getPath()));
        /*if(lootTableId.getNamespace().equals("minecraft") && lootTableId.getPath().equals("chests/village/village_toolsmith")) {
            // Add your items to generatedLoot here.
            generatedLoot.add(new ItemStack(item, 1));
        }*/
        generatedLoot.add(new ItemStack(item, 1));
        return generatedLoot;
    }
}
