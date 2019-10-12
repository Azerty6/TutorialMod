package fr.teddy.items;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.teddy.structures.TutorialWorldGeneratorPillar;
import fr.teddy.tutorialmod.TutorialMod;
import fr.teddy.utils.References;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;


public class TutorialPillar extends Item {

    protected TutorialWorldGeneratorPillar pillarGenerator;

    public TutorialPillar() {
        this.pillarGenerator = new TutorialWorldGeneratorPillar();
        this.hasSubtypes = true;
        this.maxStackSize = 1;
        this.setMaxDamage(5);
        this.setCreativeTab(TutorialMod.tutorialCreativeTabs);
        this.setUnlocalizedName("tutorial_pillar");
        this.setTextureName(References.MOD_ID + ":tutorial_pillar");
        GameRegistry.registerItem(this, "tutorial_pillar");
    }

    public int getMetadata(int metadata) {
        return metadata;
    }

    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
        item.damageItem(1, player);
        final int xPilar = (int)Math.floor(player.posX), yPilar = (int)Math.floor(player.posY), zPilar = (int)Math.floor(player.posZ);
        class TutorialPilarRightClickThread implements Runnable {
            private World world;
            private int x, y, z;
            private EntityPlayer player;
            public TutorialPilarRightClickThread(World world, int x, int y, int z, EntityPlayer player) {
                super();
                this.world = world;
                this.x = x;
                this.y = y;
                this.z = z;
                this.player = player;
            }
            @Override
            public void run() {
                while (player.posY < 255) {
                    player.motionY = 1;
                    try {
						Thread.currentThread().sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
                pillarGenerator.generate(this.world, this.x, this.y, this.z);
            }
        }
        new Thread(new TutorialPilarRightClickThread(world, xPilar, yPilar, zPilar, player)).start();
        return item;
    }

    public boolean isFull3D() {
        return false;
    }

}
