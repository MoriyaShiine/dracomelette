package moriyashiine.dracomelette.mixin;

import moriyashiine.dracomelette.DCConfig;
import moriyashiine.dracomelette.Dracomelette;
import net.minecraft.block.BlockState;
import net.minecraft.block.DragonEggBlock;
import net.minecraft.block.MagmaBlock;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(MagmaBlock.class)
public class ModifyMagmaBlock {
	@Inject(method = "randomTick", at = @At("HEAD"))
	private void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo info) {
		if (!world.isClient && world.getBlockState(pos.up()).getBlock() instanceof DragonEggBlock) {
			world.playSound(null, pos.up(), SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1, 1);
			if (random.nextFloat() < DCConfig.INSTANCE.breakChance) {
				world.breakBlock(pos.up(), false);
			}
			world.spawnEntity(new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5, new ItemStack(Dracomelette.dracomelette)));
		}
	}
}