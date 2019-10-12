package fr.teddy.armors.tutorialarmor;

import fr.teddy.armors.BootsArmorItem;
import net.minecraft.item.ItemArmor;

public class TutoBoots extends BootsArmorItem {

    public TutoBoots(ItemArmor.ArmorMaterial material) {
        this.item = new TutoArmorItem(material, TutoBoots.ARMOR_PART_ID, this);
    }

}
