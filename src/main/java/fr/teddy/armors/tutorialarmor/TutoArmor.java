package fr.teddy.armors.tutorialarmor;

import fr.teddy.armors.Armor;
import net.minecraftforge.common.util.EnumHelper;

public class TutoArmor extends Armor {

    public TutoArmor () {
        super();
        this.material = EnumHelper.addArmorMaterial("tutorialarmor", 25, new int[] {4, 6, 5, 4}, 20);
        this.helmet = new TutoHelmet(this.material);
        this.chestPlate = new TutoChestPlate(this.material);
        this.leggings = new TutoLeggings(this.material);
        this.boots = new TutoBoots(this.material);
        this.register(new String[] {"tutorial_helmet", "tutorial_chestplate", "tutorial_leggings", "tutorial_boots"});
    }

}
