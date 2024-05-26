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
import net.minecraft.world.WorldAccess;
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
	private void dracomelette$scheduleCook(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos, CallbackInfoReturnable<BlockState> cir) {
		if (direction == Direction.UP && neighborState.isOf(Blocks.DRAGON_EGG)) {
			world.scheduleBlockTick(pos, this, 20);
		}
	}

	@Inject(method = "scheduledTick", at = @At("HEAD"))
	private void dracomelette$cookDragonEgg(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {
		if (!world.isClient && world.getBlockState(pos.up()).isOf(Blocks.DRAGON_EGG)) {
			world.scheduleBlockTick(pos, this, random.nextBetween(20, 200));
			world.playSound(null, pos.up(), ModSoundEvents.BLOCK_DRAGON_EGG_COOK, SoundCategory.BLOCKS, 1, 1);
			ItemScatterer.spawn(world, pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5, ModItems.DRACOMELETTE.getDefaultStack());
			if (random.nextFloat() < ModConfig.breakChance) {
				world.breakBlock(pos.up(), false);
			}
		}
	}
}
