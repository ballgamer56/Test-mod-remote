
package net.mcreator.testmod.world.features.ores;

public class UniswapOreFeature extends OreFeature {

	public static final UniswapOreFeature FEATURE = (UniswapOreFeature) new UniswapOreFeature().setRegistryName("test_mod:uniswap_ore");
	public static final ConfiguredFeature<?, ?> CONFIGURED_FEATURE = FEATURE
			.configured(new OreConfiguration(UniswapOreFeatureRuleTest.INSTANCE, TestModModBlocks.UNISWAP_ORE.defaultBlockState(), 8))
			.range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.absolute(0), VerticalAnchor.absolute(200)))).squared().count(1);

	public static final Set<ResourceLocation> GENERATE_BIOMES = Set.of(new ResourceLocation("test_mod:cryptic_sphere"));

	public UniswapOreFeature() {
		super(OreConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<OreConfiguration> context) {
		WorldGenLevel world = context.level();
		ResourceKey<Level> dimensionType = world.getLevel().dimension();
		boolean dimensionCriteria = false;

		if (dimensionType == ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("test_mod:crypto_world")))
			dimensionCriteria = true;

		if (!dimensionCriteria)
			return false;

		return super.place(context);
	}

	private static class UniswapOreFeatureRuleTest extends RuleTest {

		static final UniswapOreFeatureRuleTest INSTANCE = new UniswapOreFeatureRuleTest();
		static final com.mojang.serialization.Codec<UniswapOreFeatureRuleTest> codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);

		static final RuleTestType<UniswapOreFeatureRuleTest> CUSTOM_MATCH = Registry.register(Registry.RULE_TEST,
				new ResourceLocation("test_mod:uniswap_ore_match"), () -> codec);

		public boolean test(BlockState blockAt, Random random) {
			boolean blockCriteria = false;

			if (blockAt.getBlock() == TestModModBlocks.CRYPT_STONE)
				blockCriteria = true;

			return blockCriteria;
		}

		protected RuleTestType<?> getType() {
			return CUSTOM_MATCH;
		}

	}

}
