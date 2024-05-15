/*
 * All Rights Reserved (c) MoriyaShiine
 */

package moriyashiine.dracomelette.common.init;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
	public static final FoodComponent DRACOMELETTE = new FoodComponent.Builder().nutrition(20).saturationModifier(1).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1800, 3), 1).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 1800, 2), 1).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 1800, 3), 1).build();
}
