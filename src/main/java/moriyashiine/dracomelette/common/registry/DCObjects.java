package moriyashiine.dracomelette.common.registry;

import moriyashiine.dracomelette.DCConfig;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;
import java.util.Random;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DCObjects {
	public static final Item dracomelette = new Item(new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().hunger(20).saturation(1).effect(() -> new EffectInstance(Effects.ABSORPTION, 1800, 3), 1).effect(() -> new EffectInstance(Effects.REGENERATION, 1800, 3), 1).effect(() -> new EffectInstance(Effects.RESISTANCE, 1800, 2), 1).build())) {
		@Override
		@Nonnull
		public ItemStack onItemUseFinish(@Nonnull ItemStack stack, @Nonnull World world, @Nonnull LivingEntity livingEntity) {
			if (!world.isRemote) {
				Random random = livingEntity.getRNG();
				if (random.nextFloat() <= DCConfig.INSTANCE.teleportChance.get()) {
					for (int i = 0; i < 16; i++) {
						if (livingEntity.attemptTeleport(livingEntity.getPosX() + random.nextInt(16) - 8, livingEntity.getPosX() + random.nextInt(16) - 8, livingEntity.getPosX() + random.nextInt(16) - 8, true)) {
							livingEntity.stopRiding();
							world.playSound(null, livingEntity.getPosition(), SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT, SoundCategory.PLAYERS, 1, 1);
							break;
						}
					}
				}
			}
			return super.onItemUseFinish(stack, world, livingEntity);
		}
	}.setRegistryName("dracomelette");
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().register(dracomelette);
	}
}
