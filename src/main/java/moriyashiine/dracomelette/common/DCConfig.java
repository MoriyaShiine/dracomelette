package moriyashiine.dracomelette.common;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;

@Config(name = Dracomelette.MODID)
public class DCConfig implements ConfigData {
	public float breakChance = 1 / 3f;
	
	public float teleportChance = 0.5f;
	
	public boolean spawnMultipleEggs = false;
}
