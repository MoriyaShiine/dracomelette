/*
 * All Rights Reserved (c) MoriyaShiine
 */

package moriyashiine.dracomelette.common.registry;

import moriyashiine.dracomelette.common.Dracomelette;
import moriyashiine.dracomelette.common.item.DracomeletteItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Rarity;

public class ModItems {
	public static final Item DRACOMELETTE = new DracomeletteItem(new FabricItemSettings().rarity(Rarity.EPIC).food(ModFoodComponents.DRACOMELETTE));

	public static void init() {
		Registry.register(Registries.ITEM, Dracomelette.id("dracomelette"), DRACOMELETTE);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> entries.addAfter(Items.CHORUS_FRUIT, DRACOMELETTE));
	}
}
