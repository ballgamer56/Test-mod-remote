
package net.mcreator.testmod.fluid;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.FluidAttributes;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.testmod.init.TestModModItems;
import net.mcreator.testmod.init.TestModModFluids;
import net.mcreator.testmod.init.TestModModBlocks;

public abstract class CoolantFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> TestModModFluids.COOLANT,
			() -> TestModModFluids.FLOWING_COOLANT,
			FluidAttributes.builder(new ResourceLocation("test_mod:blocks/coolantstatic2"), new ResourceLocation("test_mod:blocks/coolantstatic2"))

					.sound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.empty")))).explosionResistance(100f)

							.bucket(() -> TestModModItems.COOLANT_BUCKET).block(() -> (LiquidBlock) TestModModBlocks.COOLANT);

	private CoolantFluid() {
		super(PROPERTIES);
	}

	public static class Source extends CoolantFluid {
		public Source() {
			super();
			setRegistryName("coolant");
		}

		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends CoolantFluid {
		public Flowing() {
			super();
			setRegistryName("flowing_coolant");
		}

		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}
