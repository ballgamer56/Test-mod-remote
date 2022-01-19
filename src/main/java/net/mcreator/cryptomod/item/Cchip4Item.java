
package net.mcreator.cryptomod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

public class Cchip4Item extends Item {
	public Cchip4Item() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(64).rarity(Rarity.COMMON));
		setRegistryName("cchip_4");
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}
}
