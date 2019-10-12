package fr.teddy.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import fr.teddy.blocks.tileentity.TutorialBoxTileEntity;
import fr.teddy.blocks.tileentity.TutorialUnclaimFinderMachineTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TutorialGUIHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity instanceof TutorialBoxTileEntity) {
            return new TutorialContainerBox((TutorialBoxTileEntity)tileEntity, player.inventory);
        } else if (tileEntity instanceof TutorialUnclaimFinderMachineTileEntity) {
            return new TutorialContainerUnclaimFinderMachine((TutorialUnclaimFinderMachineTileEntity)tileEntity, player.inventory);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity instanceof TutorialBoxTileEntity) {
            return new TutorialGUIBox((TutorialBoxTileEntity)tileEntity, player.inventory);
        } else if (tileEntity instanceof TutorialUnclaimFinderMachineTileEntity) {
            return new TutorialGUIUnclaimFinderMachine((TutorialUnclaimFinderMachineTileEntity)tileEntity, player.inventory);
        }
        return null;
    }

}
