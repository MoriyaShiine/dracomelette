/*
 * All Rights Reserved (c) 2022 MoriyaShiine
 */

package moriyashiine.dracomelette.common;

import eu.midnightdust.lib.config.MidnightConfig;
import moriyashiine.dracomelette.common.registry.ModItems;
import moriyashiine.dracomelette.common.registry.ModSoundEvents;
import net.fabricmc.api.ModInitializer;

public class Dracomelette implements ModInitializer {
	public static final String MOD_ID = "dracomelette";

	@Override
	public void onInitialize() {
		MidnightConfig.init(MOD_ID, ModConfig.class);
		ModItems.init();
		ModSoundEvents.init();
	}
}
