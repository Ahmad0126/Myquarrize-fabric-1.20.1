package net.ahmad.myquarize.item;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent COKLAT_BATANG = new FoodComponent.Builder()
            .hunger(6)
            .saturationModifier(2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 300), 0.50f)
            .build();
}
