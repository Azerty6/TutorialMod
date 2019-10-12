package fr.teddy.blocks.tileentity;


import fr.teddy.blocks.TutorialSecretBlock;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TutorialSecretBlockTileEntity extends TileEntity {

    protected Block block;

    public TutorialSecretBlockTileEntity(Block block) {
        this.block = block;
    }

    public void onBlockActivated (World world) {

        Block block;
        int metadata = this.getBlockMetadata();
        int x = (int) Math.floor(this.xCoord), y = (int) Math.floor(this.yCoord), z = (int) Math.floor(this.zCoord);
        if (metadata <= 1) {
            y += (metadata == 0 ? -1 : 1);
        } else if (metadata <= 3) {
            z += (metadata == 2 ? 1 : -1);
        } else {
            x += (metadata == 4 ? -1 : 1);
        }
        System.out.println(this.xCoord + ", " + this.yCoord + "," + this.zCoord);
        for (int i = 0; i < 6; i++) {
            ((TutorialSecretBlock)(this.block)).icon[i] = world.getBlock(x, y, z).getIcon(i, metadata);
        }
    }





}
