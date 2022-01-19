
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cryptomod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.cryptomod.block.entity.MiningRigBlockEntity;
import net.mcreator.cryptomod.block.entity.MilkPlasticBlockEntity;
import net.mcreator.cryptomod.block.entity.ExBlockEntity;
import net.mcreator.cryptomod.block.entity.ChipFabBlockEntity;
import net.mcreator.cryptomod.block.entity.BasiccchipfabBlockEntity;
import net.mcreator.cryptomod.block.entity.AssemblerBlockBlockEntity;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CryptoModBlockEntities {
	private static final List<BlockEntityType<?>> REGISTRY = new ArrayList<>();
	public static final BlockEntityType<?> CHIP_FAB = register("crypto:chip_fab", CryptoModBlocks.CHIP_FAB, ChipFabBlockEntity::new);
	public static final BlockEntityType<?> BASICCCHIPFAB = register("crypto:basiccchipfab", CryptoModBlocks.BASICCCHIPFAB,
			BasiccchipfabBlockEntity::new);
	public static final BlockEntityType<?> MILK_PLASTIC = register("crypto:milk_plastic", CryptoModBlocks.MILK_PLASTIC, MilkPlasticBlockEntity::new);
	public static final BlockEntityType<?> ASSEMBLER_BLOCK = register("crypto:assembler_block", CryptoModBlocks.ASSEMBLER_BLOCK,
			AssemblerBlockBlockEntity::new);
	public static final BlockEntityType<?> MINING_RIG = register("crypto:mining_rig", CryptoModBlocks.MINING_RIG, MiningRigBlockEntity::new);
	public static final BlockEntityType<?> EX = register("crypto:ex", CryptoModBlocks.EX, ExBlockEntity::new);

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
