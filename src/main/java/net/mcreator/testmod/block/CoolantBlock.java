
package net.mcreator.testmod.block;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

import net.mcreator.testmod.init.TestModModFluids;

public class CoolantBlock extends LiquidBlock {
	public CoolantBlock() {
		super(TestModModFluids.COOLANT, BlockBehaviour.Properties.of(Material.WATER).strength(100f)

		);
		setRegistryName("coolant");
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}
}
