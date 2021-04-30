package me.scaldings.gildednetherite.init;

import dev.emi.trinkets.api.SlotGroups;
import dev.emi.trinkets.api.Slots;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import me.scaldings.gildednetherite.init.trinkets.GildedElytraTrinket;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Trinkets {
    public static Item getGildedElytraTrinket() {
        return new GildedElytraTrinket(Items.GILDED_ELYTRA_SETTINGS);
    }

    public static ItemStack getChestCapeItemStack(LivingEntity livingEntity) {
        PlayerEntity player = (PlayerEntity) livingEntity;
        TrinketComponent comp = TrinketsApi.getTrinketComponent(player);
        return comp.getStack(SlotGroups.CHEST, Slots.CAPE);
    }
}
