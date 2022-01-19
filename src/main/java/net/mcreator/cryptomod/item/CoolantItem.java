
package net.mcreator.cryptomod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BucketItem;

import net.mcreator.cryptomod.init.CryptoModFluids;

public class CoolantItem extends BucketItem {
	public CoolantItem() {
		super(() -> CryptoModFluids.COOLANT,
				new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON).tab(CreativeModeTab.TAB_MISC));
		setRegistryName("coolant_bucket");
	}
}
