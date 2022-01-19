
package net.mcreator.cryptomod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

public class BasicGPUItem extends Item {
	public BasicGPUItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_MISC).durability(250).rarity(Rarity.COMMON));
		setRegistryName("basic_gpu");
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}
}
