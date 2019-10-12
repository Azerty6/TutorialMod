package fr.teddy.armors;

import fr.teddy.utils.References;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;

public class ArmorItem extends ItemArmor {

    public static String PARTS_NAMES;
    protected ArmorPartBase armorPart;
    protected int armorPartId;

    public ArmorItem(ArmorMaterial material, int type, ArmorPartBase armorPart) {
        super(material, 0, type);
        this.armorPart = armorPart;
        this.armorPartId = type;
    }

    public boolean getIsRepairable(ItemStack input, ItemStack repair) {
        if (repair.getItem() == this) {
            return this.armorPart.getIsRepairable(repair);
        }
        return false;
    }


}
