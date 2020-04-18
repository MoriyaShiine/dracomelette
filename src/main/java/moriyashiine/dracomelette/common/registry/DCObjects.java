package moriyashiine.dracomelette.common.registry;

import moriyashiine.dracomelette.DCConfig;
import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;
import java.util.Random;

/** File created by mason on 4/18/20 **/
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DCObjects {
	public static final Item dracomelette = new Item(new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().hunger(20).saturation(1).effect(new EffectInstance(Effects.ABSORPTION, 1800, 3), 1).effect(new EffectInstance(Effects.REGENERATION, 1800, 3), 1).effect(new EffectInstance(Effects.RESISTANCE, 1800, 2), 1).build())) {
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
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().register(new DragonEggBlock(Block.Properties.from(Blocks.DRAGON_EGG).tickRandomly()) {
			@Override
			public void randomTick(@Nonnull BlockState state, @Nonnull ServerWorld world, @Nonnull BlockPos pos, @Nonnull Random random) {
				super.randomTick(state, world, pos, random);
				if (!world.isRemote && world.getBlockState(pos.down()).getBlock() instanceof MagmaBlock) {
					world.playSound(null, pos.down(), SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1, 1);
					if (random.nextFloat() < DCConfig.INSTANCE.breakChance.get()) {
						world.setBlockState(pos, Blocks.AIR.getDefaultState());
					}
					InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY() + 1.8, pos.getZ(), new ItemStack(dracomelette));
				}
			}
		}.setRegistryName(new ResourceLocation("minecraft", "dragon_egg")));
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().register(dracomelette);
	}
}