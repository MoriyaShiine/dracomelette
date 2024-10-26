/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.dracomelette.common.init;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.item.consume.TeleportRandomlyConsumeEffect;

import java.util.List;

public class ModConsumableComponents {
	public static final ConsumableComponent DRACOMELETTE = ConsumableComponents.food()
			.consumeEffect(new ApplyEffectsConsumeEffect(List.of(
					new StatusEffectInstance(StatusEffects.ABSORPTION, 1800, 3),
					new StatusEffectInstance(StatusEffects.REGENERATION, 1800, 3),
					new StatusEffectInstance(StatusEffects.RESISTANCE, 1800, 2)),
					1))
			.consumeEffect(new TeleportRandomlyConsumeEffect())
			.build();
}
