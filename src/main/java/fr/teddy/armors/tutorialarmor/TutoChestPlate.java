package fr.teddy.armors.tutorialarmor;

import fr.teddy.armors.ChestPlateArmorItem;
import net.minecraft.item.ItemArmor;

public class TutoChestPlate extends ChestPlateArmorItem {

    public TutoChestPlate(ItemArmor.ArmorMaterial material) {
        this.item = new TutoArmorItem(material, TutoChestPlate.ARMOR_PART_ID, this);
    }

}
