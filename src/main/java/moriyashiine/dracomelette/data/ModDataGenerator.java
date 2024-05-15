/*
 * All Rights Reserved (c) MoriyaShiine
 */

package moriyashiine.dracomelette.data;

import moriyashiine.dracomelette.data.provider.ModAdvancementProvider;
import moriyashiine.dracomelette.data.provider.ModModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModAdvancementProvider::new);
		pack.addProvider(ModModelProvider::new);
	}
}
