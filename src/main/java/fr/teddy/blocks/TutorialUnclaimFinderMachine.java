package fr.teddy.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.teddy.blocks.tileentity.TutorialUnclaimFinderMachineTileEntity;
import fr.teddy.tutorialmod.TutorialMod;
import fr.teddy.utils.References;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TutorialUnclaimFinderMachine extends BlockContainer {

    public TutorialUnclaimFinderMachine() {
        super(Material.rock);
        this.setBlockName("tutorial_unclaim_finder_machine");
        this.setBlockTextureName(References.MOD_ID + ":tutorial_unclaim_finder_machine");
        this.setCreativeTab(TutorialMod.tutorialCreativeTabs);
        GameRegistry.registerBlock(this, "tutorial_unclaim_finder_machine");
    }

    @Override
    public boolean hasTileEntity(int metadata) {
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return new TutorialUnclaimFinderMachineTileEntity();
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int metadata) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity instanceof IInventory) {
            IInventory inventory = (IInventory) tileEntity;
            for (int i = 0; i < inventory.getSizeInventory(); i++) {
                ItemStack itemStack = inventory.getStackInSlot(i);
                if (itemStack != null) {
                    EntityItem entityItem = new EntityItem(world, x, y, z, itemStack);
                }
            }
        }
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            return true;
        }
        System.out.println("On ouvre !");
        player.openGui(TutorialMod.instance, 0, world, x, y, z);
        return true;
    }

}
