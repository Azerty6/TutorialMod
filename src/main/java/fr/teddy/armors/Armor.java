package fr.teddy.armors;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;

public class Armor {

    protected ItemArmor.ArmorMaterial material;
    protected HelmetArmorItem helmet;
    protected ChestPlateArmorItem chestPlate;
    protected LeggingsArmorItem leggings;
    protected BootsArmorItem boots;

    public void register(String[] names) {
        GameRegistry.registerItem(this.helmet.item, names[0]);
        GameRegistry.registerItem(this.chestPlate.item, names[1]);
        GameRegistry.registerItem(this.leggings.item, names[2]);
        GameRegistry.registerItem(this.boots.item, names[3]);
    }

}
