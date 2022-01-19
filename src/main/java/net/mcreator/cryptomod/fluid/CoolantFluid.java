
package net.mcreator.cryptomod.fluid;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.FluidAttributes;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.cryptomod.init.CryptoModItems;
import net.mcreator.cryptomod.init.CryptoModFluids;
import net.mcreator.cryptomod.init.CryptoModBlocks;

public abstract class CoolantFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> CryptoModFluids.COOLANT,
			() -> CryptoModFluids.FLOWING_COOLANT,
			FluidAttributes.builder(new ResourceLocation("crypto:blocks/coolantstatic2"), new ResourceLocation("crypto:blocks/coolantstatic2"))

					.sound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.empty")))).explosionResistance(100f)

							.bucket(() -> CryptoModItems.COOLANT_BUCKET).block(() -> (LiquidBlock) CryptoModBlocks.COOLANT);

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
