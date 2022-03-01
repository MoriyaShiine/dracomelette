package moriyashiine.dracomelette.common.registry;

import moriyashiine.dracomelette.common.Dracomelette;
import moriyashiine.dracomelette.common.item.DracomeletteItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ModItems {
	public static final Item DRACOMELETTE = new DracomeletteItem(new FabricItemSettings().group(ItemGroup.FOOD).rarity(Rarity.EPIC).food(ModFoodComponents.DRACOMELETTE));

	public static void init() {
		Registry.register(Registry.ITEM, new Identifier(Dracomelette.MOD_ID, "dracomelette"), DRACOMELETTE);
	}
}
