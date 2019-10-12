package fr.teddy.items;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.teddy.gui.TutorialRenderEventHandler;
import fr.teddy.tutorialmod.TutorialMod;
import fr.teddy.utils.References;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

import static java.lang.Math.sqrt;

public class TutorialUnclaimFinder extends Item {

    public static final String[] subItems = new String[] {"green", "yellow", "red"};
    public static final int[] numberChunksToScan = {1, 9, 25};
    private int metadata;

    public TutorialUnclaimFinder(int metadata) {
        this.metadata = metadata;
        this.hasSubtypes = true;
        this.maxStackSize = 1;
        this.setMaxDamage(100);
        this.setCreativeTab(TutorialMod.tutorialCreativeTabs);
        this.setUnlocalizedName("tutorial_unclaim_finder");
        this.setTextureName(References.MOD_ID + ":tutorial_unclaim_finder_" + TutorialUnclaimFinder.subItems[metadata]);
        GameRegistry.registerItem(this, "tutorial_unclaim_finder_" + TutorialUnclaimFinder.subItems[metadata]);
    }

    public int getMetadata(int metadata) {
        return metadata;
    }

    public String getUnlocalizedName(ItemStack stack) {
        if (this.metadata < 0 || this.metadata >= TutorialUnclaimFinder.subItems.length) {
            this.metadata = 0;
        }
        return super.getUnlocalizedName() + "_" + TutorialUnclaimFinder.subItems[this.metadata];
    }

    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
        item.damageItem(1, player);

        Chunk currentChunk = world.getChunkFromChunkCoords(player.chunkCoordX, player.chunkCoordZ);
        Chunk[] chunks = new Chunk[TutorialUnclaimFinder.numberChunksToScan[this.metadata]];
        int sideLength = (int)sqrt(TutorialUnclaimFinder.numberChunksToScan[this.metadata]);
        for (int i = 0, x = - ((sideLength - 1) / 2); i < sideLength; i++, x++) {
            for (int j = 0, y = - ((sideLength - 1) / 2); j < sideLength; j++, y++) {
                chunks[j * sideLength + i] = world.getChunkFromChunkCoords(currentChunk.xPosition + x, currentChunk.zPosition + y);
            }
        }
        int tileEntityNb = 0;
        for (Chunk chunk : chunks) {
            tileEntityNb += chunk.chunkTileEntityMap.size();
        }
        TutorialRenderEventHandler.INSTANCE.setNbTileEntities(tileEntityNb);
        return item;
    }

    public boolean isFull3D() {
        return false;
    }

}
