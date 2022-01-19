
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cryptomod.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.cryptomod.client.gui.WalletScreen;
import net.mcreator.cryptomod.client.gui.SandGuiScreen;
import net.mcreator.cryptomod.client.gui.RigGuiScreen;
import net.mcreator.cryptomod.client.gui.MANAGuiScreen;
import net.mcreator.cryptomod.client.gui.KUBGuiScreen;
import net.mcreator.cryptomod.client.gui.GPUAssemblerScreen;
import net.mcreator.cryptomod.client.gui.FabScreen;
import net.mcreator.cryptomod.client.gui.ETHGuiScreen;
import net.mcreator.cryptomod.client.gui.BnbguiScreen;
import net.mcreator.cryptomod.client.gui.BinanceScreen;
import net.mcreator.cryptomod.client.gui.BasicCFabScreen;
import net.mcreator.cryptomod.client.gui.AssemblerScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CryptoModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(CryptoModMenus.WALLET, WalletScreen::new);
			MenuScreens.register(CryptoModMenus.ETH_GUI, ETHGuiScreen::new);
			MenuScreens.register(CryptoModMenus.FAB, FabScreen::new);
			MenuScreens.register(CryptoModMenus.BASIC_C_FAB, BasicCFabScreen::new);
			MenuScreens.register(CryptoModMenus.PLASTICMAKER, GPUAssemblerScreen::new);
			MenuScreens.register(CryptoModMenus.ASSEMBLER, AssemblerScreen::new);
			MenuScreens.register(CryptoModMenus.RIG_GUI, RigGuiScreen::new);
			MenuScreens.register(CryptoModMenus.BNBGUI, BnbguiScreen::new);
			MenuScreens.register(CryptoModMenus.SAND_GUI, SandGuiScreen::new);
			MenuScreens.register(CryptoModMenus.KUB_GUI, KUBGuiScreen::new);
			MenuScreens.register(CryptoModMenus.MANA_GUI, MANAGuiScreen::new);
			MenuScreens.register(CryptoModMenus.BINANCE, BinanceScreen::new);
		});
	}
}
