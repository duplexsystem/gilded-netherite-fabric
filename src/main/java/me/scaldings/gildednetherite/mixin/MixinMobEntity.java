package me.scaldings.gildednetherite.mixin;

import me.scaldings.gildednetherite.GildedNetherite;
import me.scaldings.gildednetherite.init.Items;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MobEntity.class)
public class MixinMobEntity {
    @Inject(at = @At("HEAD"), method = "getPreferredEquipmentSlot", cancellable = true)
    private static void getPreferredEquipmentSlot(ItemStack stack, CallbackInfoReturnable<EquipmentSlot> info) {
        if(GildedNetherite.isTrinketsLoaded && stack.getItem() == Items.GILDED_ELYTRA) info.setReturnValue(EquipmentSlot.MAINHAND);
    }
}
