
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.testmod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.testmod.item.UsdtcoinItem;
import net.mcreator.testmod.item.UniswapcoinItem;
import net.mcreator.testmod.item.USDT9Item;
import net.mcreator.testmod.item.USDT81Item;
import net.mcreator.testmod.item.USDT729Item;
import net.mcreator.testmod.item.USDT6561Item;
import net.mcreator.testmod.item.SolanacoinItem;
import net.mcreator.testmod.item.SiliconItem;
import net.mcreator.testmod.item.SandcoinItem;
import net.mcreator.testmod.item.SANDWallItem;
import net.mcreator.testmod.item.Rigaxe2Item;
import net.mcreator.testmod.item.PlasticItem;
import net.mcreator.testmod.item.Picklv3Item;
import net.mcreator.testmod.item.PickLv2Item;
import net.mcreator.testmod.item.NextGenGPUItem;
import net.mcreator.testmod.item.ManacoinItem;
import net.mcreator.testmod.item.MANAWalletItem;
import net.mcreator.testmod.item.KubcoinItem;
import net.mcreator.testmod.item.KUBWallItem;
import net.mcreator.testmod.item.HardwareWalletItem;
import net.mcreator.testmod.item.GraphicPick1Item;
import net.mcreator.testmod.item.FanItem;
import net.mcreator.testmod.item.FabChipItem;
import net.mcreator.testmod.item.EthwalletItem;
import net.mcreator.testmod.item.EthereumItem;
import net.mcreator.testmod.item.DogecoinItem;
import net.mcreator.testmod.item.CryptoWorldItem;
import net.mcreator.testmod.item.CryptoMiningPickaxeItem;
import net.mcreator.testmod.item.CpuItem;
import net.mcreator.testmod.item.CoolantItem;
import net.mcreator.testmod.item.Cchip4Item;
import net.mcreator.testmod.item.Cchip3Item;
import net.mcreator.testmod.item.BoardItem;
import net.mcreator.testmod.item.BnbwalletItem;
import net.mcreator.testmod.item.BnbcoinItem;
import net.mcreator.testmod.item.BetterGPUItem;
import net.mcreator.testmod.item.BetterChipItem;
import net.mcreator.testmod.item.BasicchipItem;
import net.mcreator.testmod.item.BasicGPUItem;
import net.mcreator.testmod.item.BTCItem;
import net.mcreator.testmod.item.AdvanceGPUItem;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TestModModItems {
	private static final List<Item> REGISTRY = new ArrayList<>();
	public static final Item CRYPT_STONE = register(TestModModBlocks.CRYPT_STONE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item CRYPTO_WORLD = register(new CryptoWorldItem());
	public static final Item COOLANT_BUCKET = register(new CoolantItem());
	public static final Item DOGECOIN = register(new DogecoinItem());
	public static final Item DOGE_ORE = register(TestModModBlocks.DOGE_ORE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item CRYPTO_MINING_PICKAXE = register(new CryptoMiningPickaxeItem());
	public static final Item HARDWARE_WALLET = register(new HardwareWalletItem());
	public static final Item PICK_LV_2 = register(new PickLv2Item());
	public static final Item ETH_ORE = register(TestModModBlocks.ETH_ORE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item ETHEREUM = register(new EthereumItem());
	public static final Item ETHWALLET = register(new EthwalletItem());
	public static final Item CHIP_FAB = register(TestModModBlocks.CHIP_FAB, CreativeModeTab.TAB_DECORATIONS);
	public static final Item SILICON = register(new SiliconItem());
	public static final Item FAB_CHIP = register(new FabChipItem());
	public static final Item BASICCHIP = register(new BasicchipItem());
	public static final Item BASICCCHIPFAB = register(TestModModBlocks.BASICCCHIPFAB, CreativeModeTab.TAB_DECORATIONS);
	public static final Item BETTER_CHIP = register(new BetterChipItem());
	public static final Item CRYPTO_WORLD_PORTAL_FRAME = register(TestModModBlocks.CRYPTO_WORLD_PORTAL_FRAME, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item CCHIP_3 = register(new Cchip3Item());
	public static final Item CCHIP_4 = register(new Cchip4Item());
	public static final Item PICKLV_3 = register(new Picklv3Item());
	public static final Item BTC_ORE = register(TestModModBlocks.BTC_ORE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item BTC = register(new BTCItem());
	public static final Item GRAPHIC_PICK_1 = register(new GraphicPick1Item());
	public static final Item PLASTIC = register(new PlasticItem());
	public static final Item MILK_PLASTIC = register(TestModModBlocks.MILK_PLASTIC, CreativeModeTab.TAB_DECORATIONS);
	public static final Item SOLANACOIN = register(new SolanacoinItem());
	public static final Item UNISWAPCOIN = register(new UniswapcoinItem());
	public static final Item FAN = register(new FanItem());
	public static final Item SOLANA_ORE = register(TestModModBlocks.SOLANA_ORE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item CPU = register(new CpuItem());
	public static final Item UNISWAP_ORE = register(TestModModBlocks.UNISWAP_ORE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item ASSEMBLER_BLOCK = register(TestModModBlocks.ASSEMBLER_BLOCK, CreativeModeTab.TAB_DECORATIONS);
	public static final Item BASIC_GPU = register(new BasicGPUItem());
	public static final Item RIGAXE_2 = register(new Rigaxe2Item());
	public static final Item BETTER_GPU = register(new BetterGPUItem());
	public static final Item MINING_RIG = register(TestModModBlocks.MINING_RIG, CreativeModeTab.TAB_DECORATIONS);
	public static final Item KUBCOIN = register(new KubcoinItem());
	public static final Item MANACOIN = register(new ManacoinItem());
	public static final Item SANDCOIN = register(new SandcoinItem());
	public static final Item USDTCOIN = register(new UsdtcoinItem());
	public static final Item BNBCOIN = register(new BnbcoinItem());
	public static final Item ADVANCE_GPU = register(new AdvanceGPUItem());
	public static final Item NEXT_GEN_GPU = register(new NextGenGPUItem());
	public static final Item BOARD = register(new BoardItem());
	public static final Item USDT_9 = register(new USDT9Item());
	public static final Item USDT_81 = register(new USDT81Item());
	public static final Item USDT_729 = register(new USDT729Item());
	public static final Item USDT_6561 = register(new USDT6561Item());
	public static final Item BNBWALLET = register(new BnbwalletItem());
	public static final Item SAND_WALL = register(new SANDWallItem());
	public static final Item KUB_WALL = register(new KUBWallItem());
	public static final Item MANA_WALLET = register(new MANAWalletItem());

	private static Item register(Item item) {
		REGISTRY.add(item);
		return item;
	}

	private static Item register(Block block, CreativeModeTab tab) {
		return register(new BlockItem(block, new Item.Properties().tab(tab)).setRegistryName(block.getRegistryName()));
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Item[0]));
	}
}
