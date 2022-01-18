
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.testmod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.block.Block;

import net.mcreator.testmod.block.UniswapOreBlock;
import net.mcreator.testmod.block.SolanaOreBlock;
import net.mcreator.testmod.block.MiningRigBlock;
import net.mcreator.testmod.block.MilkPlasticBlock;
import net.mcreator.testmod.block.ExBlock;
import net.mcreator.testmod.block.ETHOreBlock;
import net.mcreator.testmod.block.DogeOreBlock;
import net.mcreator.testmod.block.CryptoWorldPortalFrameBlock;
import net.mcreator.testmod.block.CryptoWorldPortalBlock;
import net.mcreator.testmod.block.CryptStoneBlock;
import net.mcreator.testmod.block.CoolantBlock;
import net.mcreator.testmod.block.ChipFabBlock;
import net.mcreator.testmod.block.BasiccchipfabBlock;
import net.mcreator.testmod.block.BTCOreBlock;
import net.mcreator.testmod.block.AssemblerBlockBlock;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TestModModBlocks {
	private static final List<Block> REGISTRY = new ArrayList<>();
	public static final Block CRYPT_STONE = register(new CryptStoneBlock());
	public static final Block CRYPTO_WORLD_PORTAL = register(new CryptoWorldPortalBlock());
	public static final Block COOLANT = register(new CoolantBlock());
	public static final Block DOGE_ORE = register(new DogeOreBlock());
	public static final Block ETH_ORE = register(new ETHOreBlock());
	public static final Block CHIP_FAB = register(new ChipFabBlock());
	public static final Block BASICCCHIPFAB = register(new BasiccchipfabBlock());
	public static final Block CRYPTO_WORLD_PORTAL_FRAME = register(new CryptoWorldPortalFrameBlock());
	public static final Block BTC_ORE = register(new BTCOreBlock());
	public static final Block MILK_PLASTIC = register(new MilkPlasticBlock());
	public static final Block SOLANA_ORE = register(new SolanaOreBlock());
	public static final Block UNISWAP_ORE = register(new UniswapOreBlock());
	public static final Block ASSEMBLER_BLOCK = register(new AssemblerBlockBlock());
	public static final Block MINING_RIG = register(new MiningRigBlock());
	public static final Block EX = register(new ExBlock());

	private static Block register(Block block) {
		REGISTRY.add(block);
		return block;
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Block[0]));
	}
}
