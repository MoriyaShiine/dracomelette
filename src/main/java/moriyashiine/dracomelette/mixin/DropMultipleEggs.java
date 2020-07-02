package moriyashiine.dracomelette.mixin;

import moriyashiine.dracomelette.DCConfig;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.boss.dragon.EnderDragonFight;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EnderDragonFight.class)
public class DropMultipleEggs {
	@SuppressWarnings("FieldCanBeLocal")
	@Shadow
	private boolean previouslyKilled;
	
	@Inject(method = "dragonKilled", at = @At("HEAD"))
	private void dragonKilled(EnderDragonEntity dragon, CallbackInfo info) {
		if (DCConfig.INSTANCE.spawnMultipleEggs) {
			previouslyKilled = false;
		}
	}
}