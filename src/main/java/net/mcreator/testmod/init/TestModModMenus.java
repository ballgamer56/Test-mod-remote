
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.testmod.init;

import net.minecraftforge.fmllegacy.network.IContainerFactory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.AbstractContainerMenu;

import net.mcreator.testmod.world.inventory.WalletMenu;
import net.mcreator.testmod.world.inventory.GPUAssemblerMenu;
import net.mcreator.testmod.world.inventory.FabMenu;
import net.mcreator.testmod.world.inventory.ETHGuiMenu;
import net.mcreator.testmod.world.inventory.BasicCFabMenu;
import net.mcreator.testmod.world.inventory.AssemblerMenu;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TestModModMenus {
	private static final List<MenuType<?>> REGISTRY = new ArrayList<>();
	public static final MenuType<WalletMenu> WALLET = register("wallet", (id, inv, extraData) -> new WalletMenu(id, inv, extraData));
	public static final MenuType<ETHGuiMenu> ETH_GUI = register("eth_gui", (id, inv, extraData) -> new ETHGuiMenu(id, inv, extraData));
	public static final MenuType<FabMenu> FAB = register("fab", (id, inv, extraData) -> new FabMenu(id, inv, extraData));
	public static final MenuType<BasicCFabMenu> BASIC_C_FAB = register("basic_c_fab", (id, inv, extraData) -> new BasicCFabMenu(id, inv, extraData));
	public static final MenuType<GPUAssemblerMenu> PLASTICMAKER = register("plasticmaker",
			(id, inv, extraData) -> new GPUAssemblerMenu(id, inv, extraData));
	public static final MenuType<AssemblerMenu> ASSEMBLER = register("assembler", (id, inv, extraData) -> new AssemblerMenu(id, inv, extraData));

	private static <T extends AbstractContainerMenu> MenuType<T> register(String registryname, IContainerFactory<T> containerFactory) {
		MenuType<T> menuType = new MenuType<T>(containerFactory);
		menuType.setRegistryName(registryname);
		REGISTRY.add(menuType);
		return menuType;
	}

	@SubscribeEvent
	public static void registerContainers(RegistryEvent.Register<MenuType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new MenuType[0]));
	}
}
