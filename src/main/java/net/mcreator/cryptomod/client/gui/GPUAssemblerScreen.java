
package net.mcreator.cryptomod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.cryptomod.world.inventory.GPUAssemblerMenu;
import net.mcreator.cryptomod.procedures.PlasticProgress1Procedure;
import net.mcreator.cryptomod.procedures.PlasticProgress0Procedure;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class GPUAssemblerScreen extends AbstractContainerScreen<GPUAssemblerMenu> {
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public GPUAssemblerScreen(GPUAssemblerMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 235;
	}

	private static final ResourceLocation texture = new ResourceLocation("crypto:textures/plasticmaker.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("crypto:textures/sieve.png"));
		this.blit(ms, this.leftPos + 39, this.topPos + 78, 0, 0, 96, 16, 96, 16);

		if (PlasticProgress0Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("crypto:textures/blade1.png"));
			this.blit(ms, this.leftPos + 69, this.topPos + 41, 0, 0, 32, 32, 32, 32);
		}
		if (PlasticProgress1Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("crypto:textures/blade2.png"));
			this.blit(ms, this.leftPos + 69, this.topPos + 41, 0, 0, 32, 32, 32, 32);
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
		this.font.draw(poseStack, "Plastic Maker", 52, 3, -12829636);
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
	}
}
