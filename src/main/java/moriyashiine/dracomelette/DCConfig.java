package moriyashiine.dracomelette;

import blue.endless.jankson.Comment;
import io.github.cottonmc.cotton.config.annotations.ConfigFile;

@ConfigFile(name = Dracomelette.MODID)
public class DCConfig {
	public static final DCConfig INSTANCE = new DCConfig();
	
	@Comment(value = "The chance a given Dragon Egg will break when producing a Dracomelette")
	public float breakChance = 1 / 3f;
	
	@Comment(value = "The chance to teleport when eating a Dracomelette")
	public float teleportChance = 0.5f;
}