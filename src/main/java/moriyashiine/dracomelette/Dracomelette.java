package moriyashiine.dracomelette;

import io.github.cottonmc.cotton.config.ConfigManager;
import moriyashiine.dracomelette.item.DracomeletteItem;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class Dracomelette implements ModInitializer {
	public static final String MODID = "dracomelette";
	
	public static final Item dracomelette = new DracomeletteItem(new Item.Settings().group(ItemGroup.FOOD).rarity(Rarity.EPIC).food(new FoodComponent.Builder().hunger(20).saturationModifier(1).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1800, 3), 1).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 1800, 2), 1).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 1800, 3), 1).build()));
	
	@Override
	public void onInitialize() {
		ConfigManager.loadConfig(DCConfig.class);
		Registry.register(Registry.ITEM, new Identifier(MODID, "dracomelette"), dracomelette);
	}
}
