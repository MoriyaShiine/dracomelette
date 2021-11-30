package moriyashiine.dracomelette.common.registry;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
	public static final FoodComponent DRACOMELETTE = new FoodComponent.Builder().hunger(20).saturationModifier(1).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1800, 3), 1).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 1800, 2), 1).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 1800, 3), 1).build();
}
