
package net.mcreator.cryptomod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

public class BoardItem extends Item {
	public BoardItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_MISC).durability(250).rarity(Rarity.COMMON));
		setRegistryName("board");
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}
}
