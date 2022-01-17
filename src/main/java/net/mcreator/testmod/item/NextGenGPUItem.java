
package net.mcreator.testmod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

public class NextGenGPUItem extends Item {
	public NextGenGPUItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_MISC).durability(500).rarity(Rarity.EPIC));
		setRegistryName("next_gen_gpu");
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}
}
