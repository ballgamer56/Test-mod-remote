
package net.mcreator.cryptomod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

public class BetterGPUItem extends Item {
	public BetterGPUItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_MISC).durability(500).rarity(Rarity.UNCOMMON));
		setRegistryName("better_gpu");
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}
}
