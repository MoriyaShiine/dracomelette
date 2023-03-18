/*
 * All Rights Reserved (c) MoriyaShiine
 */

package moriyashiine.dracomelette.common;

import eu.midnightdust.lib.config.MidnightConfig;

public class ModConfig extends MidnightConfig {
	@Entry
	public static boolean spawnMultipleEggs = false;

	@Entry(min = 0, max = 1, isSlider = true)
	public static float breakChance = 0.25F;
	@Entry(min = 0, max = 1, isSlider = true)
	public static float teleportChance = 0.5F;
}
