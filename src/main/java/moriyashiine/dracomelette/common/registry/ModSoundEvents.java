package moriyashiine.dracomelette.common.registry;

import moriyashiine.dracomelette.common.Dracomelette;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSoundEvents {
	public static final SoundEvent BLOCK_DRAGON_EGG_COOK = new SoundEvent(new Identifier(Dracomelette.MOD_ID, "block.dragon_egg.cook"));
	
	public static void init() {
		Registry.register(Registry.SOUND_EVENT, BLOCK_DRAGON_EGG_COOK.getId(), BLOCK_DRAGON_EGG_COOK);
	}
}
