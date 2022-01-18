
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.testmod.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.testmod.client.gui.WalletScreen;
import net.mcreator.testmod.client.gui.SandGuiScreen;
import net.mcreator.testmod.client.gui.RigGuiScreen;
import net.mcreator.testmod.client.gui.MANAGuiScreen;
import net.mcreator.testmod.client.gui.KUBGuiScreen;
import net.mcreator.testmod.client.gui.GPUAssemblerScreen;
import net.mcreator.testmod.client.gui.FabScreen;
import net.mcreator.testmod.client.gui.ETHGuiScreen;
import net.mcreator.testmod.client.gui.BnbguiScreen;
import net.mcreator.testmod.client.gui.BinanceScreen;
import net.mcreator.testmod.client.gui.BasicCFabScreen;
import net.mcreator.testmod.client.gui.AssemblerScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TestModModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(TestModModMenus.WALLET, WalletScreen::new);
			MenuScreens.register(TestModModMenus.ETH_GUI, ETHGuiScreen::new);
			MenuScreens.register(TestModModMenus.FAB, FabScreen::new);
			MenuScreens.register(TestModModMenus.BASIC_C_FAB, BasicCFabScreen::new);
			MenuScreens.register(TestModModMenus.PLASTICMAKER, GPUAssemblerScreen::new);
			MenuScreens.register(TestModModMenus.ASSEMBLER, AssemblerScreen::new);
			MenuScreens.register(TestModModMenus.RIG_GUI, RigGuiScreen::new);
			MenuScreens.register(TestModModMenus.BNBGUI, BnbguiScreen::new);
			MenuScreens.register(TestModModMenus.SAND_GUI, SandGuiScreen::new);
			MenuScreens.register(TestModModMenus.KUB_GUI, KUBGuiScreen::new);
			MenuScreens.register(TestModModMenus.MANA_GUI, MANAGuiScreen::new);
			MenuScreens.register(TestModModMenus.BINANCE, BinanceScreen::new);
		});
	}
}
