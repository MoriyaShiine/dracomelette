package moriyashiine.dracomelette;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

/** File created by mason on 4/18/20 **/
public class DCConfig {
	public static final DCConfig INSTANCE;
	static final ForgeConfigSpec SPEC;
	
	static {
		final Pair<DCConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(DCConfig::new);
		INSTANCE = specPair.getLeft();
		SPEC = specPair.getRight();
	}
	
	public final ForgeConfigSpec.ConfigValue<Float> breakChance, teleportChance;
	
	private DCConfig(ForgeConfigSpec.Builder builder) {
		breakChance = builder.comment("The chance a given Dragon Egg will break when producing a Dracomelette").define("breakChance", 1 / 3f);
		teleportChance = builder.comment("The chance to teleport when eating a Dracomelette").define("teleportChance", 0.5f);
	}
}