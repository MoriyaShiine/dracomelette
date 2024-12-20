/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.dracomelette.common.init;

import moriyashiine.dracomelette.common.Dracomelette;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;

public class ModSoundEvents {
	public static final SoundEvent BLOCK_DRAGON_EGG_COOK = SoundEvent.of(Dracomelette.id("block.dragon_egg.cook"));

	public static void init() {
		Registry.register(Registries.SOUND_EVENT, BLOCK_DRAGON_EGG_COOK.id(), BLOCK_DRAGON_EGG_COOK);
	}
}
