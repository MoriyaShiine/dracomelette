package moriyashiine.dracomelette.common;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = Dracomelette.MOD_ID)
public class ModConfig implements ConfigData {
	public float breakChance = 1 / 4f;
	
	public float teleportChance = 0.5f;
	
	public boolean spawnMultipleEggs = false;
}
