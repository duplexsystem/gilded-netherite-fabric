package me.scaldings.gildednetherite.init;

import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.loot.ConstantLootTableRange;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;

public class LootTables {
    private static final Identifier BASTION_TREASURE_LOOT_TABLE_ID = new Identifier("minecraft", "chests/bastion_treasure");
    private static final Identifier BASTION_OTHER_LOOT_TABLE_ID = new Identifier("minecraft", "chests/bastion_other");

    public static void registerLootTables() {
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
            if (BASTION_TREASURE_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(3))
                        .withEntry(ItemEntry.builder(Items.DIAMOND_SCRAP).weight(8).build())
                        .withEntry(ItemEntry.builder(Items.GILDED_INGOT).weight(4).build());
                supplier.withPool(poolBuilder.build());
            } else if (BASTION_OTHER_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(1))
                        .withEntry(ItemEntry.builder(Items.DIAMOND_SCRAP).weight(2).build());
                supplier.withPool(poolBuilder.build());
            }
        });
    }
}
