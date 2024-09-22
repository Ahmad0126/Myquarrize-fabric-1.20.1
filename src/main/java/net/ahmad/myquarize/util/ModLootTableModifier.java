package net.ahmad.myquarize.util;

import net.ahmad.myquarize.Myquarrize;
import net.ahmad.myquarize.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModLootTableModifier {
    private static final Identifier JUNGLE_TEMPLE_ID = new Identifier(Myquarrize.MOD_ID, "chests/jungle_temple");
    private static final Identifier HUSK_ID = new Identifier(Myquarrize.MOD_ID, "entities/husk");
    private static final Identifier SUS_SAND_ID = new Identifier(Myquarrize.MOD_ID, "entities/husk");

    public static void modifyLootTables(){
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(JUNGLE_TEMPLE_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.METAL_DETECTOR))
                        .with(ItemEntry.builder(ModItems.COKLAT_BATANG))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f,1f)).build());

                tableBuilder.pool(poolBuilder);
            }

            if(HUSK_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.STEEL_HOE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f,1f)).build());

                tableBuilder.pool(poolBuilder);
            }
        });

        LootTableEvents.REPLACE.register((resourceManager, lootManager, id, original, source) -> {
            if(SUS_SAND_ID.equals(id)){
                List<LootPoolEntry> entries = new ArrayList<>(Arrays.asList(original.pools[0].entries));
                entries.add(ItemEntry.builder(ModItems.STEEL).build());

                LootPool.Builder pool = LootPool.builder().with(entries);
                return LootTable.builder().pool(pool).build();
            }
            return null;
        });

        Myquarrize.LOGGER.info("Modifying vanilla Loot tables");
    }
}
