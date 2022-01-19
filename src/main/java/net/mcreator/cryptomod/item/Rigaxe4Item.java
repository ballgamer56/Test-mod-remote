
package net.mcreator.cryptomod.item;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.core.BlockPos;

import net.mcreator.cryptomod.init.CryptoModBlocks;

import java.util.List;

import com.google.common.collect.Multimap;
import com.google.common.collect.ImmutableMultimap;

public class Rigaxe4Item extends Item {
	public Rigaxe4Item() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).durability(4321));
		setRegistryName("rigaxe_4");
	}

	@Override
	public float getDestroySpeed(ItemStack itemstack, BlockState blockstate) {
		return List.of(CryptoModBlocks.CRYPT_STONE, CryptoModBlocks.DOGE_ORE, CryptoModBlocks.ETH_ORE, CryptoModBlocks.BTC_ORE,
				CryptoModBlocks.UNISWAP_ORE, CryptoModBlocks.SOLANA_ORE).contains(blockstate.getBlock()) ? 250f : 1;
	}

	@Override
	public boolean mineBlock(ItemStack stack, Level world, BlockState state, BlockPos pos, LivingEntity entity) {
		stack.hurtAndBreak(1, entity, i -> i.broadcastBreakEvent(EquipmentSlot.MAINHAND));
		return true;
	}

	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity entity, LivingEntity sourceentity) {
		stack.hurtAndBreak(2, sourceentity, i -> i.broadcastBreakEvent(EquipmentSlot.MAINHAND));
		return true;
	}

	@Override
	public int getEnchantmentValue() {
		return 1;
	}

	@Override
	public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot equipmentSlot) {
		if (equipmentSlot == EquipmentSlot.MAINHAND) {
			ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
			builder.putAll(super.getDefaultAttributeModifiers(equipmentSlot));
			builder.put(Attributes.ATTACK_DAMAGE,
					new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", 2f, AttributeModifier.Operation.ADDITION));
			builder.put(Attributes.ATTACK_SPEED,
					new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", -3, AttributeModifier.Operation.ADDITION));
			return builder.build();
		}
		return super.getDefaultAttributeModifiers(equipmentSlot);
	}
}
