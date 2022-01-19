
package net.mcreator.cryptomod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

public class NextGenGPUItem extends Item {
	public NextGenGPUItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_MISC).durability(2500).rarity(Rarity.EPIC));
		setRegistryName("next_gen_gpu");
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}
}
