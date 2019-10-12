package fr.teddy.armors.tutorialarmor;

import fr.teddy.armors.LeggingsArmorItem;
import net.minecraft.item.ItemArmor;

public class TutoLeggings extends LeggingsArmorItem {

    public TutoLeggings(ItemArmor.ArmorMaterial material) {
        this.item = new TutoArmorItem(material, TutoLeggings.ARMOR_PART_ID, this);
    }

}
