package me.scaldings.gildednetherite.mixin;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.ShieldDecorationRecipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ShieldDecorationRecipe.class)
public class MixinShieldDecorationRecipe {
    @Redirect(method = "matches", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;getItem()Lnet/minecraft/item/Item;"))
    public net.minecraft.item.Item addCustomBannerMatches(ItemStack itemStack) {
        if (itemStack.getItem() == me.scaldings.gildednetherite.init.Items.GILDED_SHIELD) {
            return Items.SHIELD;
        }
        return itemStack.getItem();
    }

    @Redirect(method = "craft", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;getItem()Lnet/minecraft/item/Item;"))
    public net.minecraft.item.Item addCustomBannerCraft(ItemStack itemStack) {
        if (itemStack.getItem() == me.scaldings.gildednetherite.init.Items.GILDED_SHIELD) {
            return Items.SHIELD;
        }
        return itemStack.getItem();
    }
}
