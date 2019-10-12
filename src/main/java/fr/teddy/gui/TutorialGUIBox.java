package fr.teddy.gui;

import fr.teddy.blocks.tileentity.TutorialBoxTileEntity;
import fr.teddy.utils.References;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class TutorialGUIBox extends GuiContainer {

    protected static final ResourceLocation texture = new ResourceLocation(References.MOD_ID, "textures/gui/container/tutorial_box.png");
    protected TutorialBoxTileEntity tileEntity;
    protected IInventory playerInventory;

    public TutorialGUIBox(TutorialBoxTileEntity tileEntity, InventoryPlayer inventory) {
        super(new TutorialContainerBox(tileEntity, inventory));
        this.tileEntity = tileEntity;
        this.playerInventory = inventory;
        this.allowUserInput = false;
        this.ySize = 220;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialRenderTick, int x, int y) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(TutorialGUIBox.texture);
        int posX = (this.width - this.xSize) / 2;
        int posY = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(posX, posY, 0, 0, this.xSize, this.ySize);
    }

    protected void drawGuiContainerForegroundLayer(int x, int y) {
        String tileEntityName = this.tileEntity.hasCustomInventoryName() ? this.tileEntity.getInventoryName() : I18n.format(this.tileEntity.getInventoryName());
        this.fontRendererObj.drawString(tileEntityName, (this.xSize - this.fontRendererObj.getStringWidth(tileEntityName)) / 2, 6, 0);
        String inventoryName = this.playerInventory.hasCustomInventoryName() ? this.playerInventory.getInventoryName() : I18n.format(this.playerInventory.getInventoryName());
        this.fontRendererObj.drawString(inventoryName, (this.xSize - this.fontRendererObj.getStringWidth(tileEntityName)) / 2, this.ySize - 96, 0);
    }

}
