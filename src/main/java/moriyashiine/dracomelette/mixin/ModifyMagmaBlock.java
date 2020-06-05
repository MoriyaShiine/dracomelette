package moriyashiine.dracomelette.mixin;

import moriyashiine.dracomelette.DCConfig;
import moriyashiine.dracomelette.common.registry.DCObjects;
import net.minecraft.block.BlockState;
import net.minecraft.block.DragonEggBlock;
import net.minecraft.block.MagmaBlock;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(MagmaBlock.class)
public class ModifyMagmaBlock {
	@Inject(method = "randomTick", at = @At("HEAD"))
	private void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo info) {
		if (!world.isRemote && world.getBlockState(pos.up()).getBlock() instanceof DragonEggBlock) {
			world.playSound(null, pos.up(), SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1, 1);
			if (random.nextFloat() < DCConfig.INSTANCE.breakChance.get()) {
				world.destroyBlock(pos.up(), false);
			}
			InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY() + 2.8, pos.getZ(), new ItemStack(DCObjects.dracomelette));
		}
	}
}