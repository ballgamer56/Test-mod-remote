
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cryptomod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.core.Registry;

import net.mcreator.cryptomod.world.features.ores.UniswapOreFeature;
import net.mcreator.cryptomod.world.features.ores.SolanaOreFeature;
import net.mcreator.cryptomod.world.features.ores.ETHOreFeature;
import net.mcreator.cryptomod.world.features.ores.DogeOreFeature;
import net.mcreator.cryptomod.world.features.ores.BTCOreFeature;

import java.util.Set;
import java.util.Map;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CryptoModFeatures {
	private static final Map<Feature<?>, FeatureRegistration> REGISTRY = new HashMap<>();
	static {
		REGISTRY.put(DogeOreFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, DogeOreFeature.GENERATE_BIOMES,
				DogeOreFeature.CONFIGURED_FEATURE));
		REGISTRY.put(ETHOreFeature.FEATURE,
				new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, ETHOreFeature.GENERATE_BIOMES, ETHOreFeature.CONFIGURED_FEATURE));
		REGISTRY.put(BTCOreFeature.FEATURE,
				new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, BTCOreFeature.GENERATE_BIOMES, BTCOreFeature.CONFIGURED_FEATURE));
		REGISTRY.put(SolanaOreFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, SolanaOreFeature.GENERATE_BIOMES,
				SolanaOreFeature.CONFIGURED_FEATURE));
		REGISTRY.put(UniswapOreFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, UniswapOreFeature.GENERATE_BIOMES,
				UniswapOreFeature.CONFIGURED_FEATURE));
	}

	@SubscribeEvent
	public static void registerFeature(RegistryEvent.Register<Feature<?>> event) {
		event.getRegistry().registerAll(REGISTRY.keySet().toArray(new Feature[0]));
		REGISTRY.forEach((feature, registration) -> Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, feature.getRegistryName(),
				registration.configuredFeature()));
	}

	@Mod.EventBusSubscriber
	private static class BiomeFeatureLoader {
		@SubscribeEvent
		public static void addFeatureToBiomes(BiomeLoadingEvent event) {
			for (FeatureRegistration registration : REGISTRY.values()) {
				if (registration.biomes() == null || registration.biomes().contains(event.getName())) {
					event.getGeneration().getFeatures(registration.stage()).add(() -> registration.configuredFeature());
				}
			}
		}
	}

	private static record FeatureRegistration(GenerationStep.Decoration stage, Set<ResourceLocation> biomes,
			ConfiguredFeature<?, ?> configuredFeature) {
	}
}
