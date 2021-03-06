package moriyashiine.dracomelette.common;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import moriyashiine.dracomelette.common.item.DracomeletteItem;
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
	
	public static DCConfig config;
	
	public static final Item DRACOMELETTE = new DracomeletteItem(new Item.Settings().group(ItemGroup.FOOD).rarity(Rarity.EPIC).food(new FoodComponent.Builder().hunger(20).saturationModifier(1).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1800, 3), 1).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 1800, 2), 1).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 1800, 3), 1).build()));
	
	@Override
	public void onInitialize() {
		AutoConfig.register(DCConfig.class, GsonConfigSerializer::new);
		config = AutoConfig.getConfigHolder(DCConfig.class).getConfig();
		Registry.register(Registry.ITEM, new Identifier(MODID, "dracomelette"), DRACOMELETTE);
	}
}
