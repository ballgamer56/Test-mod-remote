package net.mcreator.cryptomod.procedures;

import net.minecraftforge.fmllegacy.server.ServerLifecycleHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.ChatType;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;
import net.minecraft.Util;

import java.util.Iterator;

public class CryptoWorldPlayerEntersDimensionProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList().broadcastMessage(new TextComponent(("" + (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD))),
						ChatType.SYSTEM, Util.NIL_UUID);
		}
		if (entity instanceof ServerPlayer _player) {
			Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("crypto:crypto_start"));
			AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
			if (!_ap.isDone()) {
				Iterator _iterator = _ap.getRemainingCriteria().iterator();
				while (_iterator.hasNext())
					_player.getAdvancements().award(_adv, (String) _iterator.next());
			}
		}
	}
}
