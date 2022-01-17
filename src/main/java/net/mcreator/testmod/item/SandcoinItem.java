
package net.mcreator.testmod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

public class SandcoinItem extends Item {
	public SandcoinItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(64).fireResistant().rarity(Rarity.COMMON));
		setRegistryName("sandcoin");
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
