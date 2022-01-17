
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

import net.mcreator.testmod.world.inventory.RigGuiMenu;
import net.mcreator.testmod.procedures.Rigselect4Procedure;
import net.mcreator.testmod.procedures.Rigselect3Procedure;
import net.mcreator.testmod.procedures.Rigselect2Procedure;
import net.mcreator.testmod.procedures.Rigselect1Procedure;
import net.mcreator.testmod.procedures.Rigselect0Procedure;

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
		this.imageWidth = 393;
		this.imageHeight = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("test_mod:textures/rig_gui.png");

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
			RenderSystem.setShaderTexture(0, new ResourceLocation("test_mod:textures/garrow0.png"));
			this.blit(ms, this.leftPos + 322, this.topPos + 33, 0, 0, 16, 16, 16, 16);
		}
		if (Rigselect1Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("test_mod:textures/garrow1.png"));
			this.blit(ms, this.leftPos + 322, this.topPos + 60, 0, 0, 16, 16, 16, 16);
		}
		if (Rigselect2Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("test_mod:textures/garrow2.png"));
			this.blit(ms, this.leftPos + 322, this.topPos + 87, 0, 0, 16, 16, 16, 16);
		}
		if (Rigselect3Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("test_mod:textures/garrow3.png"));
			this.blit(ms, this.leftPos + 322, this.topPos + 114, 0, 0, 16, 16, 16, 16);
		}
		if (Rigselect4Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("test_mod:textures/garrow4.png"));
			this.blit(ms, this.leftPos + 322, this.topPos + 141, 0, 0, 16, 16, 16, 16);
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
		this.font.draw(poseStack, "Output", 16, 42, -12829636);
		this.font.draw(poseStack, "Graphic cards", 205, 33, -12829636);
		this.font.draw(poseStack, "CPU", 205, 69, -12829636);
		this.font.draw(poseStack, "Coin selection", 313, 15, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 340, this.topPos + 33, 46, 20, new TextComponent("Doge"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 340, this.topPos + 87, 40, 20, new TextComponent("SOL"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 340, this.topPos + 60, 40, 20, new TextComponent("Uni"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 340, this.topPos + 114, 40, 20, new TextComponent("BTC"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 340, this.topPos + 141, 40, 20, new TextComponent("ETH"), e -> {
		}));
	}
}
