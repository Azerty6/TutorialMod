package fr.teddy.armors;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ArmorPartBase {

    public static int ARMOR_PART_ID;
    protected Item item;

    public Item getItem() {
        return this.item;
    }

    public boolean getIsRepairable(ItemStack repair) {
        return true;
    }

}
