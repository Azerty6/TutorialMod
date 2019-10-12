package fr.teddy.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.teddy.blocks.tileentity.TutorialBoxTileEntity;
import fr.teddy.tutorialmod.TutorialMod;
import fr.teddy.utils.References;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;

public class TutorialBox extends BlockContainer {

    public TutorialBox() {
        super(Material.rock);
        this.setBlockName("tutorial_box");
        this.setBlockTextureName(References.MOD_ID + ":tutorial_box");
        this.setCreativeTab(TutorialMod.tutorialCreativeTabs);
        GameRegistry.registerBlock(this, "tutorial_box");
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        player.openGui(TutorialMod.instance, 0, world, x, y, z);
        return true;
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int metadata) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity instanceof IInventory) {
            IInventory inventory = (IInventory)tileEntity;
            for (int i = 0; i < inventory.getSizeInventory(); i++) {
                ItemStack itemStack = inventory.getStackInSlot(i);
                if (itemStack != null) {
                    new EntityItem(world, x, y, z, itemStack);
                }
            }
            world.func_147453_f(x, y, z, block);
        }
        super.breakBlock(world, x, y, z, block, metadata);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return new TutorialBoxTileEntity(world);
    }

    @Override
    public boolean hasTileEntity(int metadata) {
        return true;
    }

}
