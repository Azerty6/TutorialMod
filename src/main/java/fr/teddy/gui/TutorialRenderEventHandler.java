package fr.teddy.gui;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.teddy.items.TutorialUnclaimFinder;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

@SideOnly(Side.CLIENT)
public class TutorialRenderEventHandler {

    public static final TutorialRenderEventHandler INSTANCE = new TutorialRenderEventHandler();
    protected int nbTileEntities = -1;      // When the number of tile entities is undefined, nbTileEntities = -1
    protected Minecraft minecraft = Minecraft.getMinecraft();

    // UNCLAIM FINDER

    @SubscribeEvent
    public void renderUnclaimFinder(RenderGameOverlayEvent event) {
        ItemStack currentItemStack = this.minecraft.thePlayer.getCurrentEquippedItem();
        if (currentItemStack != null) {
            if (currentItemStack.getItem() instanceof TutorialUnclaimFinder) {
                this.minecraft.fontRenderer.drawString("Nombre de 'tile entity' dans la zone : " + (this.nbTileEntities != -1 ? this.nbTileEntities : "non défini"), 10, 10, 0xFFFFFF);
                //this.minecraft.entityRenderer.itemRenderer.
            }
        }
    }

    public void setNbTileEntities(int nb) {
        if (nb >= 0) {
            this.nbTileEntities = nb;
        }
    }

}
