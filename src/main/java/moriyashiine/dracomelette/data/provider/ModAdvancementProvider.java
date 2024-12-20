/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.dracomelette.data.provider;

import moriyashiine.dracomelette.common.Dracomelette;
import moriyashiine.dracomelette.common.init.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
	public ModAdvancementProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
		super(output, registryLookup);
	}

	@Override
	public void generateAdvancement(RegistryWrapper.WrapperLookup registryLookup, Consumer<AdvancementEntry> consumer) {
		consumer.accept(Advancement.Builder.create()
				.parent(Identifier.tryParse("end/dragon_egg"))
				.display(ModItems.DRACOMELETTE,
						Text.translatable("advancements.dracomelette.end.dracomelette.title"),
						Text.translatable("advancements.dracomelette.end.dracomelette.description"),
						null,
						AdvancementFrame.TASK,
						true,
						true,
						false)
				.criterion("has_dracomelette", InventoryChangedCriterion.Conditions.items(ModItems.DRACOMELETTE))
				.build(consumer, Dracomelette.id("end/dracomelette").toString()));
	}
}
