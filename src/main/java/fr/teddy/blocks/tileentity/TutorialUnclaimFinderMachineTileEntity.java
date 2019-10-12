package fr.teddy.blocks.tileentity;

import fr.teddy.tutorialmod.TutorialMod;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TutorialUnclaimFinderMachineTileEntity extends TileEntity implements IInventory {

    // 0, 1, 2, 3 : the 4 tutorial items
    // 4 : the unclaim finder to upgrade
    // 5 : the unclaim finder upgraded
    protected ItemStack[] contents = new ItemStack[6];
    public static final Item[][] VALID_ITEMS = new Item[][]{
            new Item[] {TutorialMod.itemTutorial},
            new Item[] {TutorialMod.itemTutorial},
            new Item[] {TutorialMod.itemTutorial},
            new Item[] {TutorialMod.itemTutorial},
            new Item[] {TutorialMod.tutorialUnclaimFinderGreen, TutorialMod.tutorialUnclaimFinderYellow},
            new Item[] {}
    };

    @Override
    public int getSizeInventory() {
        return this.contents.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return this.contents[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount) {
        if (slot >= 0 || slot < this.getSizeInventory()) {
            if (this.contents[slot] != null) {
                ItemStack itemstack;
                if (this.contents[slot].stackSize <= amount) {
                    itemstack = this.contents[slot];
                    this.contents[slot] = null;
                    this.markDirty();
                    return itemstack;
                } else {
                    itemstack = this.contents[slot].splitStack(amount);
                    if (this.contents[slot].stackSize == 0) {
                        this.contents[slot] = null;
                    }
                    this.markDirty();
                    return itemstack;
                }
            }
        }
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        if (slot >= 0 || slot < this.getSizeInventory()) {
            if (this.contents[slot] != null) {
                ItemStack itemstack = this.contents[slot];
                this.contents[slot] = null;
                return itemstack;
            }
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack) {

        if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()) {
        	itemStack.stackSize = this.getInventoryStackLimit();
        }
        this.contents[slot] = itemStack;
        this.markDirty();
    }

    @Override
    public String getInventoryName() {
        return "tile.tutorial_unclaim_finder_machine";
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 1;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : true;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemStack) {
    	System.out.println("On passe par la !!!");
        if (itemStack != null) {
            if (slot >= 0 && slot < this.getSizeInventory()) {
                for (Item item : TutorialUnclaimFinderMachineTileEntity.VALID_ITEMS[slot]) {
                    if (itemStack.getItem() == item) {
                    	if (this.contents[slot].stackSize < this.getInventoryStackLimit()) {
                    		return true;
                    	}
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void updateEntity() {
        super.updateEntity();
        boolean canUpgrade = true;
        for (int slot = 0; slot < this.getSizeInventory() - 1; slot++) {
            if (this.contents[slot] == null) {
                canUpgrade = false;
            }
        }
        if (canUpgrade && this.contents[5] == null) {
            Item newUnclaimFinder;
            if (this.contents[4].getItem() == TutorialMod.tutorialUnclaimFinderGreen) {
                newUnclaimFinder = TutorialMod.tutorialUnclaimFinderYellow;
            } else {
                newUnclaimFinder = TutorialMod.tutorialUnclaimFinderRed;
            }
            this.contents[5] = new ItemStack(newUnclaimFinder);
            for (int slot = 0; slot < this.getSizeInventory() - 1; slot++) {
                this.contents[slot] = null;
            }
        }
    }
    
    public ItemStack[] getContents() {
    	return this.contents;
    }
}
