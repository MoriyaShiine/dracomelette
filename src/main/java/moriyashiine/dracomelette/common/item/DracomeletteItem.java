/*
 * All Rights Reserved (c) MoriyaShiine
 */

package moriyashiine.dracomelette.common.item;

import moriyashiine.dracomelette.common.ModConfig;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class DracomeletteItem extends Item {
	public DracomeletteItem(Settings settings) {
		super(settings);
	}

	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		if (world.random.nextFloat() < ModConfig.teleportChance) {
			return Items.CHORUS_FRUIT.finishUsing(stack, world, user);
		}
		return super.finishUsing(stack, world, user);
	}
}
