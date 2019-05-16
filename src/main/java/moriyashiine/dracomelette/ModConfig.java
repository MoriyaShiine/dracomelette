package moriyashiine.dracomelette;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ModConfig extends Configuration {
	public final float breakChance, teleportChance;

	public ModConfig(File file) {
		super(file);
		load();
		breakChance = getFloat("breakChance", "misc", 0.3f, 0, 1, "The chance (0-1) that the Dragon Egg will be destroyed when cooked.");
		teleportChance = getFloat("teleportChance", "misc", 0.5f, 0, 1, "The chance that the player will teleport after eating a Dracomelette.");
		save();
	}
}