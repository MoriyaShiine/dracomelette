/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.dracomelette.common.init;

import moriyashiine.dracomelette.common.Dracomelette;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Rarity;

import java.util.function.Function;

public class ModItems {
	public static final Item DRACOMELETTE = register("dracomelette", Item::new, new Item.Settings().rarity(Rarity.EPIC).food(ModFoodComponents.DRACOMELETTE, ModConsumableComponents.DRACOMELETTE).useCooldown(1));

	private static Item register(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
		return Items.register(RegistryKey.of(RegistryKeys.ITEM, Dracomelette.id(name)), factory, settings);
	}

	public static void init() {
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> entries.addAfter(Items.CHORUS_FRUIT, DRACOMELETTE));
	}
}
