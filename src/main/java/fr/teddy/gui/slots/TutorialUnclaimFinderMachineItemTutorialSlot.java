package fr.teddy.gui.slots;

import fr.teddy.tutorialmod.TutorialMod;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class TutorialUnclaimFinderMachineItemTutorialSlot extends Slot {
	
	public static final int MAX_ITEMS_IN_SLOT = 1;

    public TutorialUnclaimFinderMachineItemTutorialSlot(IInventory inventory, int id, int x, int y) {
        super(inventory, id, x, y);
    }

    @Override
    public boolean isItemValid(ItemStack itemStack) {
        return itemStack != null && itemStack.getItem() == TutorialMod.itemTutorial;
    }

    @Override
    public ItemStack decrStackSize(int amount) {
        return super.decrStackSize(amount);
    }

    public String toString() {
    	return "Id" + this.getSlotIndex() + "Item Stack : " + this.getStack();
    }

}
