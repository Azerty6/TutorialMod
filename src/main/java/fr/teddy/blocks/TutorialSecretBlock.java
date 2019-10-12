package fr.teddy.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.teddy.blocks.tileentity.TutorialSecretBlockTileEntity;
import fr.teddy.tutorialmod.TutorialMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class TutorialSecretBlock extends Block {

    public IIcon[] icon = new IIcon[6];

    public TutorialSecretBlock() {
        super(Material.rock);
        this.setCreativeTab(TutorialMod.tutorialCreativeTabs);
        GameRegistry.registerBlock(this, "tutorial_secret_block");
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        return null;
    }


    @Override
    public IIcon getIcon(int side, int metadata) {
        /*int x = (int)Math.floor(this.minX), y = (int)Math.floor(this.minY), z = (int)Math.floor(this.minZ);
        if (metadata <= 1) {
            y += (metadata == 0 ? -1 : 1);
        } else if (metadata <= 3) {
            z += (metadata == 2 ? 1 : -1);
        } else {
            x += (metadata == 4 ? -1 : 1);
        }
        World world = Minecraft.getMinecraft().theWorld;
        System.out.println(this.minX + ", " + this.minY + "," + this.minZ);
        return world.getBlock(x, y, z).getIcon(0, world.getBlockMetadata(x, y, z));*/return this.icon[side];
    }

    @Override
    public boolean hasTileEntity(int metadata) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata) {
        return new TutorialSecretBlockTileEntity(this);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        world.setBlockMetadataWithNotify(x, y, z, side, 124);
        ((TutorialSecretBlockTileEntity)world.getTileEntity(x, y, z)).onBlockActivated(world);
        return true;
    }

}
