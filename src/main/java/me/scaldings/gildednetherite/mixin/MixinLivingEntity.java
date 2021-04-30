package me.scaldings.gildednetherite.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(LivingEntity.class)
public abstract class MixinLivingEntity {
    @Shadow @Nullable public abstract StatusEffectInstance getStatusEffect(StatusEffect effect);

    @ModifyConstant(method = "travel(Lnet/minecraft/util/math/Vec3d;)V", constant = @Constant(doubleValue = 0.01))
    public double setSlowFallingSpeed(double value) {
        return (0.01 * this.getStatusEffect(StatusEffects.SLOW_FALLING).getAmplifier());
    }
}
