package moriyashiine.dracomelette.common.item;

import moriyashiine.dracomelette.common.Dracomelette;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ChorusFruitItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class DracomeletteItem extends ChorusFruitItem {
	public DracomeletteItem(Settings settings) {
		super(settings);
	}
	
	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		return world.random.nextFloat() < Dracomelette.config.teleportChance ? super.finishUsing(stack, world, user) : Items.COOKED_PORKCHOP.finishUsing(stack, world, user);
	}
}
