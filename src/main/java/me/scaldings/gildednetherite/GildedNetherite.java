package me.scaldings.gildednetherite;

import me.scaldings.gildednetherite.init.Blocks;
import me.scaldings.gildednetherite.init.Items;
import me.scaldings.gildednetherite.init.LootTables;
import me.scaldings.gildednetherite.init.Potions;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class GildedNetherite implements ModInitializer {
    public static final String MOD_ID = "gildednetherite";

    public static boolean isTrinketsLoaded = false;

    @Override
    public void onInitialize() {
        isTrinketsLoaded = FabricLoader.getInstance().isModLoaded("trinkets");
        Blocks.registerBlocks();
        Items.registerItems();
        Items.registerUniqueItems();
        Potions.registerPotions();
        LootTables.registerLootTables();
    }
}
