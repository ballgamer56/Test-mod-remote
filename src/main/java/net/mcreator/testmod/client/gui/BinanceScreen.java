
package net.mcreator.testmod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.testmod.world.inventory.BinanceMenu;
import net.mcreator.testmod.procedures.Pair8Procedure;
import net.mcreator.testmod.procedures.Pair7Procedure;
import net.mcreator.testmod.procedures.Pair6Procedure;
import net.mcreator.testmod.procedures.Pair5Procedure;
import net.mcreator.testmod.procedures.Pair4Procedure;
import net.mcreator.testmod.procedures.Pair3Procedure;
import net.mcreator.testmod.procedures.Pair2Procedure;
import net.mcreator.testmod.procedures.Pair1Procedure;
import net.mcreator.testmod.procedures.Pair0Procedure;
import net.mcreator.testmod.network.BinanceButtonMessage;
import net.mcreator.testmod.TestModMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class BinanceScreen extends AbstractContainerScreen<BinanceMenu> {
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public BinanceScreen(BinanceMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 250;
		this.imageHeight = 235;
	}

	private static final ResourceLocation texture = new ResourceLocation("test_mod:textures/binance.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.setShaderTexture(0, new ResourceLocation("test_mod:textures/trade.png"));
		this.blit(ms, this.leftPos + 25, this.topPos + 27, 0, 0, 128, 96, 128, 96);

		if (Pair0Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("test_mod:textures/bnbpair.png"));
			this.blit(ms, this.leftPos + 174, this.topPos + 21, 0, 0, 64, 24, 64, 24);
		}
		if (Pair1Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("test_mod:textures/btcpair.png"));
			this.blit(ms, this.leftPos + 174, this.topPos + 21, 0, 0, 64, 24, 64, 24);
		}
		if (Pair2Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("test_mod:textures/dogepair.png"));
			this.blit(ms, this.leftPos + 174, this.topPos + 21, 0, 0, 64, 24, 64, 24);
		}
		if (Pair3Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("test_mod:textures/ethpair.png"));
			this.blit(ms, this.leftPos + 174, this.topPos + 21, 0, 0, 64, 24, 64, 24);
		}
		if (Pair4Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("test_mod:textures/kubpair.png"));
			this.blit(ms, this.leftPos + 174, this.topPos + 21, 0, 0, 64, 24, 64, 24);
		}
		if (Pair5Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("test_mod:textures/manapair.png"));
			this.blit(ms, this.leftPos + 174, this.topPos + 21, 0, 0, 64, 24, 64, 24);
		}
		if (Pair6Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("test_mod:textures/sandpair.png"));
			this.blit(ms, this.leftPos + 174, this.topPos + 21, 0, 0, 64, 24, 64, 24);
		}
		if (Pair7Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("test_mod:textures/unipair.png"));
			this.blit(ms, this.leftPos + 174, this.topPos + 21, 0, 0, 64, 24, 64, 24);
		}
		if (Pair8Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("test_mod:textures/solpair.png"));
			this.blit(ms, this.leftPos + 174, this.topPos + 21, 0, 0, 64, 24, 64, 24);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "*not actual price", 249, 225, -1);
		this.font.draw(poseStack, "Trading Pair", 176, 7, -12829636);
		this.font.draw(poseStack, "Price", 192, 51, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new Button(this.leftPos + 173, this.topPos + 209, 67, 20, new TextComponent("Exchange"), e -> {
			if (true) {
				TestModMod.PACKET_HANDLER.sendToServer(new BinanceButtonMessage(0, x, y, z));
				BinanceButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 121, this.topPos + 129, 46, 20, new TextComponent("Next"), e -> {
			if (true) {
				TestModMod.PACKET_HANDLER.sendToServer(new BinanceButtonMessage(1, x, y, z));
				BinanceButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 129, 67, 20, new TextComponent("Previous"), e -> {
			if (true) {
				TestModMod.PACKET_HANDLER.sendToServer(new BinanceButtonMessage(2, x, y, z));
				BinanceButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
	}
}
