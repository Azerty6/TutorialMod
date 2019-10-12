package fr.teddy.armors.tutorialarmor;

import fr.teddy.armors.ArmorItem;
import fr.teddy.armors.ArmorPartBase;
import fr.teddy.tutorialmod.TutorialMod;
import fr.teddy.utils.References;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

public class TutoArmorItem extends ArmorItem {

    public static final String[] PARTS_NAMES = new String[] {"helmet", "chestplate", "leggings", "boots"};

    public TutoArmorItem(ArmorMaterial material, int type, ArmorPartBase armorPart) {
        super(material, type, armorPart);
        this.setUnlocalizedName("tutorial_armor_" + TutoArmorItem.PARTS_NAMES[this.armorPartId]);
        this.setTextureName(References.MOD_ID + ":tutorial_armor_" + TutoArmorItem.PARTS_NAMES[this.armorPartId]);
        this.setCreativeTab(TutorialMod.tutorialCreativeTabs);
    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return References.MOD_ID + ":textures/items/tutorial_armor_" + TutoArmorItem.PARTS_NAMES[this.armorPartId] + ".png";
    }



}
