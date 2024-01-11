/*
 * All Rights Reserved (c) MoriyaShiine
 */

package moriyashiine.dracomelette.mixin;

import moriyashiine.dracomelette.common.ModConfig;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.boss.dragon.EnderDragonFight;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.UUID;

@Mixin(value = EnderDragonFight.class, priority = 499)
public class EnderDragonFightMixin {
	@Shadow
	@Nullable
	private UUID dragonUuid;

	@Shadow
	private boolean previouslyKilled;

	@Inject(method = "dragonKilled", at = @At("HEAD"))
	private void dracomelette$respawnDragonEgg(EnderDragonEntity dragon, CallbackInfo ci) {
		if (ModConfig.spawnMultipleEggs && dragon.getUuid().equals(dragonUuid)) {
			previouslyKilled = false;
		}
	}
}
