
package net.mcreator.testmod.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class FanItem extends Item {

	public FanItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(64).rarity(Rarity.COMMON));
		setRegistryName("fan");
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}

}
