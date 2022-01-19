
package net.mcreator.cryptomod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.cryptomod.world.inventory.RigGuiMenu;
import net.mcreator.cryptomod.procedures.Rigselect4Procedure;
import net.mcreator.cryptomod.procedures.Rigselect3Procedure;
import net.mcreator.cryptomod.procedures.Rigselect2Procedure;
import net.mcreator.cryptomod.procedures.Rigselect1Procedure;
import net.mcreator.cryptomod.procedures.Rigselect0Procedure;
import net.mcreator.cryptomod.network.RigGuiButtonMessage;
import net.mcreator.cryptomod.CryptoMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class RigGuiScreen extends AbstractContainerScreen<RigGuiMenu> {
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public RigGuiScreen(RigGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 250;
		this.imageHeight = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("crypto:textures/rig_gui.png");

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
		if (Rigselect0Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("crypto:textures/garrow0.png"));
			this.blit(ms, this.leftPos + 178, this.topPos + 60, 0, 0, 16, 16, 16, 16);
		}
		if (Rigselect1Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("crypto:textures/garrow1.png"));
			this.blit(ms, this.leftPos + 178, this.topPos + 87, 0, 0, 16, 16, 16, 16);
		}
		if (Rigselect2Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("crypto:textures/garrow2.png"));
			this.blit(ms, this.leftPos + 178, this.topPos + 114, 0, 0, 16, 16, 16, 16);
		}
		if (Rigselect3Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("crypto:textures/garrow3.png"));
			this.blit(ms, this.leftPos + 178, this.topPos + 141, 0, 0, 16, 16, 16, 16);
		}
		if (Rigselect4Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("crypto:textures/garrow4.png"));
			this.blit(ms, this.leftPos + 178, this.topPos + 168, 0, 0, 16, 16, 16, 16);
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
		this.font.draw(poseStack, "Mining Rig", 7, 6, -12829636);
		this.font.draw(poseStack, "Output", 61, 69, -12829636);
		this.font.draw(poseStack, "Graphic cards", 7, 33, -12829636);
		this.font.draw(poseStack, "CPU", 7, 69, -12829636);
		this.font.draw(poseStack, "Coin selection", 169, 42, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 196, this.topPos + 60, 46, 20, new TextComponent("Doge"), e -> {
			if (true) {
				CryptoMod.PACKET_HANDLER.sendToServer(new RigGuiButtonMessage(0, x, y, z));
				RigGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 196, this.topPos + 114, 40, 20, new TextComponent("SOL"), e -> {
			if (true) {
				CryptoMod.PACKET_HANDLER.sendToServer(new RigGuiButtonMessage(1, x, y, z));
				RigGuiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 196, this.topPos + 87, 40, 20, new TextComponent("Uni"), e -> {
			if (true) {
				CryptoMod.PACKET_HANDLER.sendToServer(new RigGuiButtonMessage(2, x, y, z));
				RigGuiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 196, this.topPos + 141, 40, 20, new TextComponent("BTC"), e -> {
			if (true) {
				CryptoMod.PACKET_HANDLER.sendToServer(new RigGuiButtonMessage(3, x, y, z));
				RigGuiButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 196, this.topPos + 168, 40, 20, new TextComponent("ETH"), e -> {
			if (true) {
				CryptoMod.PACKET_HANDLER.sendToServer(new RigGuiButtonMessage(4, x, y, z));
				RigGuiButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}));
	}
}
