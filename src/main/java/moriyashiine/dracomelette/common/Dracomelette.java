/*
 * All Rights Reserved (c) MoriyaShiine
 */

package moriyashiine.dracomelette.common;

import eu.midnightdust.lib.config.MidnightConfig;
import moriyashiine.dracomelette.common.init.ModItems;
import moriyashiine.dracomelette.common.init.ModSoundEvents;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class Dracomelette implements ModInitializer {
	public static final String MOD_ID = "dracomelette";

	@Override
	public void onInitialize() {
		MidnightConfig.init(MOD_ID, ModConfig.class);
		ModItems.init();
		ModSoundEvents.init();
	}

	public static Identifier id(String value) {
		return new Identifier(MOD_ID, value);
	}
}
