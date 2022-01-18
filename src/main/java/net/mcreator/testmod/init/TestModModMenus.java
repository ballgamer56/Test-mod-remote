
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
import net.mcreator.testmod.world.inventory.SandGuiMenu;
import net.mcreator.testmod.world.inventory.RigGuiMenu;
import net.mcreator.testmod.world.inventory.MANAGuiMenu;
import net.mcreator.testmod.world.inventory.KUBGuiMenu;
import net.mcreator.testmod.world.inventory.GPUAssemblerMenu;
import net.mcreator.testmod.world.inventory.FabMenu;
import net.mcreator.testmod.world.inventory.ETHGuiMenu;
import net.mcreator.testmod.world.inventory.BnbguiMenu;
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
	public static final MenuType<RigGuiMenu> RIG_GUI = register("rig_gui", (id, inv, extraData) -> new RigGuiMenu(id, inv, extraData));
	public static final MenuType<BnbguiMenu> BNBGUI = register("bnbgui", (id, inv, extraData) -> new BnbguiMenu(id, inv, extraData));
	public static final MenuType<SandGuiMenu> SAND_GUI = register("sand_gui", (id, inv, extraData) -> new SandGuiMenu(id, inv, extraData));
	public static final MenuType<KUBGuiMenu> KUB_GUI = register("kub_gui", (id, inv, extraData) -> new KUBGuiMenu(id, inv, extraData));
	public static final MenuType<MANAGuiMenu> MANA_GUI = register("mana_gui", (id, inv, extraData) -> new MANAGuiMenu(id, inv, extraData));

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
