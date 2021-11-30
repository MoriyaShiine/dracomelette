package moriyashiine.dracomelette.common;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import moriyashiine.dracomelette.common.registry.ModItems;
import moriyashiine.dracomelette.common.registry.ModSoundEvents;
import net.fabricmc.api.ModInitializer;

public class Dracomelette implements ModInitializer {
	public static final String MOD_ID = "dracomelette";
	
	public static ModConfig config;
	
	@Override
	public void onInitialize() {
		AutoConfig.register(ModConfig.class, GsonConfigSerializer::new);
		config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
		ModItems.init();
		ModSoundEvents.init();
	}
}
