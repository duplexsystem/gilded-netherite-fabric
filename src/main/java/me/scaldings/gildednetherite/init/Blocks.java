package me.scaldings.gildednetherite.init;

import me.scaldings.gildednetherite.GildedNetherite;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Blocks {
    public static final Block GILDED_BLOCK = new Block(FabricBlockSettings.of(Material.METAL, MaterialColor.BLACK).requiresTool().strength(70.0f, 1400.0f).sounds(BlockSoundGroup.NETHERITE));

    public static void registerBlocks() {
        register(GILDED_BLOCK, "gilded_block");
    }

    private static void register(Block block, String name) {Registry.register(Registry.BLOCK, new Identifier(GildedNetherite.MOD_ID, name), block);}
}
