package me.scaldings.gildednetherite.init;

import com.oroarmor.multi_item_lib.UniqueItemRegistry;
import me.scaldings.gildednetherite.GildedNetherite;
import me.scaldings.gildednetherite.init.items.*;
import me.scaldings.gildednetherite.init.materials.GildedToolMaterial;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.item.Item.Settings;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class Items {
    //Items
    public static final Item GILDED_INGOT = new Item(new Item.Settings().fireproof().group(ItemGroup.MATERIALS));
    public static final Item DIAMOND_SCRAP = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
    public static final Item GILDED_PHANTOM_MEMBRANE = new Item(new Item.Settings().group(ItemGroup.BREWING));

    //Armor
    public static final Item GILDED_HELMET = new GildedArmorItem(ArmorMaterials.NETHERITE, EquipmentSlot.HEAD, new Item.Settings().fireproof().group(ItemGroup.COMBAT).rarity(Rarity.RARE));
    public static final Item GILDED_CHESTPLATE = new GildedArmorItem(ArmorMaterials.NETHERITE, EquipmentSlot.CHEST, new Item.Settings().fireproof().group(ItemGroup.COMBAT).rarity(Rarity.RARE));
    public static final Item GILDED_LEGGINGS = new GildedArmorItem(ArmorMaterials.NETHERITE, EquipmentSlot.LEGS, new Item.Settings().fireproof().group(ItemGroup.COMBAT).rarity(Rarity.RARE));
    public static final Item GILDED_BOOTS = new GildedArmorItem(ArmorMaterials.NETHERITE, EquipmentSlot.FEET, new Item.Settings().fireproof().group(ItemGroup.COMBAT).rarity(Rarity.RARE));
    public static final Settings GILDED_ELYTRA_SETTINGS = new Item.Settings().fireproof().group(ItemGroup.TRANSPORTATION).rarity(Rarity.EPIC).maxDamage(682);
    public static Item GILDED_ELYTRA;

    //Tools
    public static final ToolItem GILDED_SWORD = new SwordItem(GildedToolMaterial.GILDED, 3, -2.2F, new Item.Settings().fireproof().group(ItemGroup.COMBAT).rarity(Rarity.RARE));
    public static final ToolItem GILDED_PICKAXE = new GildedPickaxeItem(GildedToolMaterial.GILDED, 1, -2.6F, new Item.Settings().fireproof().group(ItemGroup.TOOLS).rarity(Rarity.RARE));
    public static final ToolItem GILDED_AXE = new GildedAxeItem(GildedToolMaterial.GILDED, 5, -2.8F, new Item.Settings().fireproof().group(ItemGroup.TOOLS).rarity(Rarity.RARE));
    public static final ToolItem GILDED_SHOVEL = new ShovelItem(GildedToolMaterial.GILDED, 1, -2.8F, new Item.Settings().fireproof().group(ItemGroup.TOOLS).rarity(Rarity.RARE));
    public static final ToolItem GILDED_HOE = new GildedHoeItem(GildedToolMaterial.GILDED, -4, 0.2F, new Item.Settings().fireproof().group(ItemGroup.TOOLS).rarity(Rarity.RARE));
    public static final ShieldItem GILDED_SHIELD = new GildedShieldItem(new Item.Settings().fireproof().group(ItemGroup.COMBAT).rarity(Rarity.UNCOMMON).maxDamage(422));

    //Blocks
    public static final Item GILDED_BLOCK = new BlockItem(Blocks.GILDED_BLOCK, new FabricItemSettings().group(ItemGroup.DECORATIONS).fireproof().rarity(Rarity.RARE));

    public static void registerItems() {
        register(GILDED_INGOT, "gilded_ingot");
        register(GILDED_HELMET, "gilded_helmet");
        register(GILDED_CHESTPLATE, "gilded_chestplate");
        register(GILDED_LEGGINGS, "gilded_leggings");
        register(GILDED_BOOTS, "gilded_boots");
        register(GILDED_SWORD, "gilded_sword");
        register(GILDED_PICKAXE, "gilded_pickaxe");
        register(GILDED_AXE, "gilded_axe");
        register(GILDED_SHOVEL, "gilded_shovel");
        register(GILDED_HOE, "gilded_hoe");
        register(DIAMOND_SCRAP, "diamond_scrap");
        register(GILDED_PHANTOM_MEMBRANE, "gilded_phantom_membrane");
        register(GILDED_BLOCK, "gilded_block");
    }

    public static void registerUniqueItems() {
        register(GILDED_SHIELD, "gilded_shield");
        UniqueItemRegistry.SHIELD.addItemToRegistry(GILDED_SHIELD);
        GILDED_ELYTRA = GildedNetherite.isTrinketsLoaded ? Trinkets.getGildedElytraTrinket() : new GildedElytraItem(GILDED_ELYTRA_SETTINGS);
        register(GILDED_ELYTRA, "gilded_elytra");
        UniqueItemRegistry.ELYTRA.addItemToRegistry(GILDED_ELYTRA);
    }

    private static void register(Item item, String name) {
        Registry.register(Registry.ITEM, new Identifier(GildedNetherite.MOD_ID, name), item);
    }
}
