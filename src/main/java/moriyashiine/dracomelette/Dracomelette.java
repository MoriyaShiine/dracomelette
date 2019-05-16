package moriyashiine.dracomelette;

import net.minecraft.block.BlockDragonEgg;
import net.minecraft.block.BlockMagma;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.Random;

@SuppressWarnings({"unused", "deprecation"})
@Mod(modid = Dracomelette.MODID, name = Dracomelette.NAME, version = Dracomelette.VERSION)
public class Dracomelette {
	public static final String MODID = "dracomelette", NAME = "Dracomelette", VERSION = "1.0";

	@SidedProxy(serverSide = "moriyashiine.dracomelette.CommonProxy", clientSide = "moriyashiine.dracomelette.ClientProxy")
	public static CommonProxy proxy;

	public ModConfig config;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		config = new ModConfig(event.getSuggestedConfigurationFile());
		Item item = new ItemFood(20, 1, false) {
			@Override
			protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
				if (!world.isRemote) {
					player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, (20 * 90), 3));
					player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, (20 * 90), 3));
					player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, (20 * 90), 2));

					Random rand = player.getRNG();
					if (rand.nextFloat() < config.teleportChance) {
						for (int i = 0; i < 16; i++) {
							if (player.attemptTeleport(player.posX + rand.nextInt(16) - 8, player.posY + rand.nextInt(16) - 8, player.posZ + rand.nextInt(16) - 8)) {
								if (player.isRiding()) player.dismountRidingEntity();
								world.playSound(null, player.getPosition(), SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT, SoundCategory.BLOCKS, 1, 1);
								player.getCooldownTracker().setCooldown(this, 20);
								break;
							}
						}
					}
				}
			}
		}.setAlwaysEdible().setRegistryName(new ResourceLocation(MODID, "dracomelette")).setTranslationKey(MODID + ".dracomelette");
		ForgeRegistries.ITEMS.register(item);
		proxy.registerTexture(item);
		ForgeRegistries.BLOCKS.register(new BlockMagma() {
			@Override
			public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
				super.updateTick(world, pos, state, rand);
				if (!world.isRemote && world.getBlockState(pos.up()).getBlock() instanceof BlockDragonEgg) {
					world.playSound(null, pos, SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1, 1);
					if (rand.nextFloat() < config.breakChance)
						world.setBlockState(pos.up(), Blocks.AIR.getDefaultState());
					InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY() + 1.8, pos.getZ(), new ItemStack(item));
				}
			}
		}.setHardness(Blocks.MAGMA.getBlockHardness(null, null, null)).setResistance(Blocks.MAGMA.getExplosionResistance(null) * 5).setRegistryName(Blocks.MAGMA.getRegistryName()).setTranslationKey(Blocks.MAGMA.getTranslationKey().substring(5)));
	}
}