package me.scaldings.gildednetherite.init;

import me.scaldings.gildednetherite.mixin.BrewingRecipeRegistryAccessor;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.potion.Potion;
import net.minecraft.util.registry.Registry;

public class Potions {
    public static Potion STRONG_SLOW_FALLING;
    public static Potion STRONG_LONG_SLOW_FALLING;

    public static void registerPotions() {
        STRONG_SLOW_FALLING = register("strong_slow_falling", new Potion("slow_falling", new StatusEffectInstance(StatusEffects.SLOW_FALLING, 1800, 3)));
        STRONG_LONG_SLOW_FALLING = register("strong_long_slow_falling", new Potion("slow_falling", new StatusEffectInstance(StatusEffects.SLOW_FALLING, 4800, 3)));
        BrewingRecipeRegistryAccessor.invokeRegisterPotionRecipe(net.minecraft.potion.Potions.AWKWARD, Items.GILDED_PHANTOM_MEMBRANE, STRONG_SLOW_FALLING);
        BrewingRecipeRegistryAccessor.invokeRegisterPotionRecipe(STRONG_SLOW_FALLING, net.minecraft.item.Items.REDSTONE, STRONG_LONG_SLOW_FALLING);
    }

    private static Potion register(String name, Potion potion) {
        return Registry.register(Registry.POTION, name, potion);
    }
}