package fr.teddy.gui;

import fr.teddy.utils.References;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class TutorialGUIKill extends GuiScreen {
	
	public static final int X_SIZE = 200;
	public static final int Y_SIZE = 200;
	public class ButtonsID {
		public static final int KILL = 0;
		public static final int CANCEL = 1;
	}
	protected Minecraft minecraft;
	protected EntityPlayer player;



	public TutorialGUIKill(Minecraft minecraft, EntityPlayer player) {
		this.minecraft = minecraft;
		this.player = player;
		this.minecraft.displayGuiScreen(this);
	}

	@Override
	public void initGui() {
		int topLeftCornerGuiX = (this.width - TutorialGUIKill.X_SIZE) / 2;
		int topLeftCornerGuiY = (this.height - TutorialGUIKill.Y_SIZE) / 2;
		this.labelList.clear();
		this.buttonList.clear();
		this.buttonList.add(new GuiButton(ButtonsID.KILL, topLeftCornerGuiX, topLeftCornerGuiY + 50, 50, 20, I18n.format("texts.tutorial_gui_kill.kill_me")));
		this.buttonList.add(new GuiButton(ButtonsID.CANCEL, topLeftCornerGuiX, topLeftCornerGuiY + 150, 100, 20, I18n.format("texts.tutorial_gui_kill.no")));
	}

	@Override
	public void actionPerformed(GuiButton button) {
		switch (button.id) {
			case TutorialGUIKill.ButtonsID.KILL:
				this.mc.thePlayer.sendChatMessage("/kill");
				break;
			case TutorialGUIKill.ButtonsID.CANCEL:
				this.minecraft.displayGuiScreen(null);
				this.minecraft.setIngameFocus();
				this.minecraft.getSoundHandler().resumeSounds();
				break;
		}
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

	@Override
	public void drawScreen(int a, int b, float c) {
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glColor3f(1.0f, 1.0f, 1.0f);
		this.drawBackground(0);
		super.drawScreen(a, b, c);
		this.drawForeground();
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		GL11.glDisable(GL11.GL_LIGHTING);
	}

	@Override
	public void drawBackground(int a) {
		mc.renderEngine.bindTexture(new ResourceLocation(References.MOD_ID + ":/textures/gui/background_tutorial_kill.png"));
		this.drawTexturedModalRect((this.width - TutorialGUIKill.X_SIZE) / 2, (this.height - TutorialGUIKill.Y_SIZE) / 2, 0, 0, TutorialGUIKill.X_SIZE, TutorialGUIKill.Y_SIZE);
	}

	public void drawForeground() {
        int topGuiX = this.width  / 2;
        int topGuiY = (this.height - TutorialGUIKill.Y_SIZE) / 2;
        this.fontRendererObj.drawString(I18n.format("texts.tutorial_gui_kill.kill"), topGuiX, topGuiY, 0xffffff);
	}

	@Override
	public void updateScreen() {
		if (this.player.isDead) {
			this.player.closeScreen();
		}
	}

}
