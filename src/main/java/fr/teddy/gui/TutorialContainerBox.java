package fr.teddy.gui;

import fr.teddy.blocks.tileentity.TutorialBoxTileEntity;
import net.minecraft.block.BlockContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class TutorialContainerBox extends Container {

    protected TutorialBoxTileEntity tileEntity;

    public TutorialContainerBox(TutorialBoxTileEntity tileEntity, InventoryPlayer inventory) {
        this.tileEntity = tileEntity;
        this.tileEntity.openInventory();
        this.addBoxSlots();
        this.bindPlayerInventory(inventory);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return this.tileEntity.isUseableByPlayer(player);
    }

    protected void addBoxSlots() {
        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 9; x++) {
                this.addSlotToContainer(new Slot(this.tileEntity, y*9 + x, x*18 + 5, y*18 + 17));
            }
        }
    }

    protected void bindPlayerInventory(InventoryPlayer inventory) {
        for (int x = 0; x < 9; x++) {
            this.addSlotToContainer(new Slot(inventory, x, x*18 + 5, 200));
        }
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x< 9; x++) {
                this.addSlotToContainer(new Slot(inventory, y*9 + x + 9, x*18 + 5, y*18 + 140));
            }
        }
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int index) {
        ItemStack itemStack = null;
        Slot slot = (Slot)this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack1 = slot.getStack().copy();
            itemStack = itemStack1.copy();
            if (index < this.tileEntity.getSizeInventory()) {
                if (!this.mergeItemStack(itemStack1, this.tileEntity.getSizeInventory(), this.inventorySlots.size(), true)) {
                    return null;
                }
            } else if (!this.mergeItemStack(itemStack1, 0, this.tileEntity.getSizeInventory(), false)) {
                return null;
            }
            if (itemStack1.stackSize == 0) {
                slot.putStack((ItemStack)null);
            } else {
                slot.onSlotChanged();
            }
            slot.onPickupFromSlot(player, itemStack1);
        }
        return itemStack;
    }

    public void onContainerClosed(EntityPlayer player) {
        super.onContainerClosed(player);
        this.tileEntity.closeInventory();
    }



}
