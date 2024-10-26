/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.dracomelette.mixin;

import moriyashiine.dracomelette.common.ModConfig;
import moriyashiine.dracomelette.common.init.ModItems;
import moriyashiine.dracomelette.common.init.ModSoundEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.MagmaBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MagmaBlock.class)
public class MagmaBlockMixin extends Block {
	public MagmaBlockMixin(Settings settings) {
		super(settings);
	}

	@Inject(method = "getStateForNeighborUpdate", at = @At("HEAD"))
	private void dracomelette$scheduleCook(BlockState state, WorldView world, ScheduledTickView tickView, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, Random random, CallbackInfoReturnable<BlockState> cir) {
		if (direction == Direction.UP && neighborState.isOf(Blocks.DRAGON_EGG)) {
			tickView.scheduleBlockTick(pos, this, 20);
		}
	}

	@Inject(method = "scheduledTick", at = @At("HEAD"))
	private void dracomelette$cookDragonEgg(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {
		if (!world.isClient) {
			BlockPos up = pos.up();
			if (world.getBlockState(up).isOf(Blocks.DRAGON_EGG)) {
				world.scheduleBlockTick(pos, this, random.nextBetween(20, 200));
				world.playSound(null, up, ModSoundEvents.BLOCK_DRAGON_EGG_COOK, SoundCategory.BLOCKS, 1, 1);
				ItemScatterer.spawn(world, up.getX() + 0.5, up.getY() + 0.5, up.getZ() + 0.5, ModItems.DRACOMELETTE.getDefaultStack());
				if (random.nextFloat() < ModConfig.breakChance) {
					world.breakBlock(up, false);
				}
			}
		}
	}
}
