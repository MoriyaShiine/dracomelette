/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.dracomelette.common;

import eu.midnightdust.lib.config.MidnightConfig;

public class ModConfig extends MidnightConfig {
	@Entry
	public static boolean spawnMultipleEggs = true;

	@Entry(min = 0, max = 1, isSlider = true)
	public static float breakChance = 0.2F;
	@Entry(min = 0, max = 1, isSlider = true)
	public static float teleportChance = 0.5F;
}
