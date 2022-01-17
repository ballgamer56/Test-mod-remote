
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.testmod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.testmod.block.entity.MilkPlasticBlockEntity;
import net.mcreator.testmod.block.entity.ChipFabBlockEntity;
import net.mcreator.testmod.block.entity.BasiccchipfabBlockEntity;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TestModModBlockEntities {
	private static final List<BlockEntityType<?>> REGISTRY = new ArrayList<>();
	public static final BlockEntityType<?> CHIP_FAB = register("test_mod:chip_fab", TestModModBlocks.CHIP_FAB, ChipFabBlockEntity::new);
	public static final BlockEntityType<?> BASICCCHIPFAB = register("test_mod:basiccchipfab", TestModModBlocks.BASICCCHIPFAB,
			BasiccchipfabBlockEntity::new);
	public static final BlockEntityType<?> MILK_PLASTIC = register("test_mod:milk_plastic", TestModModBlocks.MILK_PLASTIC,
			MilkPlasticBlockEntity::new);

	private static BlockEntityType<?> register(String registryname, Block block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		BlockEntityType<?> blockEntityType = BlockEntityType.Builder.of(supplier, block).build(null).setRegistryName(registryname);
		REGISTRY.add(blockEntityType);
		return blockEntityType;
	}

	@SubscribeEvent
	public static void registerTileEntity(RegistryEvent.Register<BlockEntityType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new BlockEntityType[0]));
	}
}
