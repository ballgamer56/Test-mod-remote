
package net.mcreator.cryptomod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

public class AdvanceGPUItem extends Item {
	public AdvanceGPUItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_MISC).durability(1000).rarity(Rarity.RARE));
		setRegistryName("advance_gpu");
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}
}
