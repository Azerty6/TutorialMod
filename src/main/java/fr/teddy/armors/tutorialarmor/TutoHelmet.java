package fr.teddy.armors.tutorialarmor;

import fr.teddy.armors.HelmetArmorItem;
import net.minecraft.item.ItemArmor;

public class TutoHelmet extends HelmetArmorItem {

    public TutoHelmet(ItemArmor.ArmorMaterial material) {
        this.item = new TutoArmorItem(material, TutoHelmet.ARMOR_PART_ID, this);
    }
}
