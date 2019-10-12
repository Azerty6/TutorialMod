package fr.teddy.gui;

import fr.teddy.blocks.tileentity.TutorialUnclaimFinderMachineTileEntity;
import fr.teddy.gui.slots.TutorialUnclaimFinderMachineItemTutorialSlot;
import fr.teddy.gui.slots.TutorialUnclaimFinderMachineResultSlot;
import fr.teddy.gui.slots.TutorialUnclaimFinderMachineTutorialUnclaimFinderSlot;
import fr.teddy.tutorialmod.TutorialMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TutorialContainerUnclaimFinderMachine extends Container {

    protected TutorialUnclaimFinderMachineTileEntity tileEntity;

    public TutorialContainerUnclaimFinderMachine(TutorialUnclaimFinderMachineTileEntity tileEntity, InventoryPlayer inventory) {
        this.tileEntity = tileEntity;
        this.tileEntity.openInventory();
        this.addMachineSlots();
        this.bindPlayerInventory(inventory);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return this.tileEntity.isUseableByPlayer(player);
    }

    protected void addMachineSlots() {
        this.addSlotToContainer(new TutorialUnclaimFinderMachineItemTutorialSlot(this.tileEntity, 0, 21, 11));
        this.addSlotToContainer(new TutorialUnclaimFinderMachineItemTutorialSlot(this.tileEntity, 1, 56, 11));
        this.addSlotToContainer(new TutorialUnclaimFinderMachineItemTutorialSlot(this.tileEntity, 2, 21, 45));
        this.addSlotToContainer(new TutorialUnclaimFinderMachineItemTutorialSlot(this.tileEntity, 3, 56, 45));
        this.addSlotToContainer(new TutorialUnclaimFinderMachineTutorialUnclaimFinderSlot(this.tileEntity, 4, 127, 50));
        this.addSlotToContainer(new TutorialUnclaimFinderMachineResultSlot(this.tileEntity, 5, 50, 117));
    }

    protected void bindPlayerInventory(InventoryPlayer inventory) {
        for (int x = 0; x < 3; x++) {
        	System.out.println(x);
            this.addSlotToContainer(new Slot(inventory, x, x*32 + 88, 236));
        }
        for (int x = 0; x < 3; x++) {
        	System.out.println(x + 3);
            this.addSlotToContainer(new Slot(inventory, x + 3, x*39 + 21, 204));
        }
        for (int x = 0; x < 3; x++) {
        	System.out.println(x + 6);
            this.addSlotToContainer(new Slot(inventory, x + 6, x*39 + 142, 204));
        }
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
            	System.out.println(y*3 + x + 9);
                this.addSlotToContainer(new Slot(inventory, y*3 + x + 9, x*25 + 187, y*24 + 3));
            }
        }
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
            	System.out.println(y*3 + x + 18);
                this.addSlotToContainer(new Slot(inventory, y*3 + x + 18, x*25 + 187, y*24 + 78));
            }
        }
        for (int x = 0; x < 9; x++) {
        	System.out.println(x+27);
            this.addSlotToContainer(new Slot(inventory, x + 30, x*25 + 37, 157));
        }
    }

    @Override
  
    public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex) {
        ItemStack itemStack = null;
        Slot slot = (Slot)this.inventorySlots.get(slotIndex);
        if (slot != null && slot.getHasStack()) {
        	itemStack = slot.getStack();
            if(slotIndex < this.tileEntity.getSizeInventory()) {
            	itemStack = this.mergeItemStacks(itemStack, this.tileEntity.getSizeInventory(), this.inventorySlots.size());
            } else {
            	itemStack = this.mergeItemStacks(itemStack, 0, this.tileEntity.getSizeInventory());
            }
            System.out.println(itemStack);
            slot.putStack(itemStack);
            System.out.println(slot);
            this.inventorySlots.set(slotIndex, slot);
        }
        return itemStack;
    }
    
    public ItemStack mergeItemStacks(ItemStack itemStack, int start, int stop) {
    	for (int i = start; i < stop; i++) {
    		Slot slot = this.getSlot(i);
    			if (slot.isItemValid(itemStack)) {
    	    		while ((!slot.getHasStack() || (slot.getStack().stackSize < slot.getSlotStackLimit() && slot.getStack().stackSize < slot.getStack().getMaxStackSize())) && itemStack != null) {
    	    			ItemStack currentItemStack = slot.getStack();
    	    			if (currentItemStack == null) {
    	    				currentItemStack = new ItemStack(itemStack.getItem());
    	    			} else {
    	    				currentItemStack.stackSize += 1;
    	    			}
    	    			slot.putStack(currentItemStack);
    	    			if (itemStack.stackSize == 1) {
    	    				itemStack = null;
    	    			} else {
    	    				itemStack.stackSize -= 1;
    	    			}
    	    		}
    			}
    	}
    	return itemStack;
    }
    
    public void onContainerClosed(EntityPlayer player) {
        super.onContainerClosed(player);
        this.tileEntity.closeInventory();
    }

    @Override
    public void retrySlotClick(int p1, int p2, boolean p3, EntityPlayer p4) {

    }

}
