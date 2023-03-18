/*
 * All Rights Reserved (c) MoriyaShiine
 */

package moriyashiine.dracomelette.mixin;

import moriyashiine.dracomelette.common.ModConfig;
import moriyashiine.dracomelette.common.registry.ModItems;
import moriyashiine.dracomelette.common.registry.ModSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.DragonEggBlock;
import net.minecraft.block.MagmaBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MagmaBlock.class)
public class MagmaBlockMixin {
	@Inject(method = "randomTick", at = @At("HEAD"))
	private void dracomelette$cookDragonEgg(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {
		if (!world.isClient && world.getBlockState(pos.up()).getBlock() instanceof DragonEggBlock) {
			world.playSound(null, pos.up(), ModSoundEvents.BLOCK_DRAGON_EGG_COOK, SoundCategory.BLOCKS, 1, 1);
			ItemScatterer.spawn(world, pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5, new ItemStack(ModItems.DRACOMELETTE));
			if (random.nextFloat() < ModConfig.breakChance) {
				world.breakBlock(pos.up(), false);
			}
		}
	}
}
