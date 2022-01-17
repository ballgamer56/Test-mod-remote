
package net.mcreator.testmod.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class CpuItem extends Item {

	public CpuItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(64).rarity(Rarity.COMMON));
		setRegistryName("cpu");
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}

}
