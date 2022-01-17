
package net.mcreator.testmod.network;

import net.minecraftforge.fmllegacy.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.testmod.world.inventory.RigGuiMenu;
import net.mcreator.testmod.procedures.CSelect4Procedure;
import net.mcreator.testmod.procedures.CSelect3Procedure;
import net.mcreator.testmod.procedures.CSelect2Procedure;
import net.mcreator.testmod.procedures.CSelect1Procedure;
import net.mcreator.testmod.procedures.CSelect0Procedure;
import net.mcreator.testmod.TestModMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RigGuiButtonMessage {
	private final int buttonID, x, y, z;

	public RigGuiButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public RigGuiButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(RigGuiButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(RigGuiButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = RigGuiMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			CSelect0Procedure.execute(world, x, y, z);
		}
		if (buttonID == 1) {

			CSelect2Procedure.execute(world, x, y, z);
		}
		if (buttonID == 2) {

			CSelect1Procedure.execute(world, x, y, z);
		}
		if (buttonID == 3) {

			CSelect3Procedure.execute(world, x, y, z);
		}
		if (buttonID == 4) {

			CSelect4Procedure.execute(world, x, y, z);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		TestModMod.addNetworkMessage(RigGuiButtonMessage.class, RigGuiButtonMessage::buffer, RigGuiButtonMessage::new, RigGuiButtonMessage::handler);
	}
}
