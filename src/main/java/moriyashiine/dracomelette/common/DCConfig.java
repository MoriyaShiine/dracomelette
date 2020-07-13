package moriyashiine.dracomelette.common;

import blue.endless.jankson.Comment;
import io.github.cottonmc.cotton.config.annotations.ConfigFile;

@ConfigFile(name = Dracomelette.MODID)
public class DCConfig {
	public static final DCConfig INSTANCE = new DCConfig();
	
	@Comment("The chance a given Dragon Egg will break when producing a Dracomelette")
	public float breakChance = 1 / 3f;
	
	@Comment("The chance to teleport when eating a Dracomelette")
	public float teleportChance = 0.5f;
	
	@Comment("Should the Ender Dragon spawn eggs after the initial kill")
	public boolean spawnMultipleEggs = false;
}