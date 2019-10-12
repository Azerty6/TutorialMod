package fr.teddy.gui.slots;

import fr.teddy.tutorialmod.TutorialMod;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class TutorialUnclaimFinderMachineTutorialUnclaimFinderSlot extends Slot {


    public TutorialUnclaimFinderMachineTutorialUnclaimFinderSlot(IInventory inventory, int id, int x, int y) {
        super(inventory, id, x, y);
    }

    @Override
    public boolean isItemValid(ItemStack itemStack) {
        return itemStack != null && (itemStack.getItem() == TutorialMod.tutorialUnclaimFinderGreen || itemStack.getItem() == TutorialMod.tutorialUnclaimFinderYellow);
    }

    @Override
    public ItemStack decrStackSize(int amount) {
        return super.decrStackSize(amount);
    }

}
