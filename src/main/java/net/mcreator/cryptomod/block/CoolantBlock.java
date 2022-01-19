
package net.mcreator.cryptomod.block;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

import net.mcreator.cryptomod.init.CryptoModFluids;

public class CoolantBlock extends LiquidBlock {
	public CoolantBlock() {
		super(CryptoModFluids.COOLANT, BlockBehaviour.Properties.of(Material.WATER).strength(100f)

		);
		setRegistryName("coolant");
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}
}
