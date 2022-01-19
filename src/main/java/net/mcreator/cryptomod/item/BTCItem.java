
package net.mcreator.cryptomod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

public class BTCItem extends Item {
	public BTCItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(64).fireResistant().rarity(Rarity.EPIC));
		setRegistryName("btc");
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}

	@Override
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}
}
