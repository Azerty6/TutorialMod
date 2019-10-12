package fr.teddy.items;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.teddy.tutorialmod.TutorialMod;
import fr.teddy.utils.References;
import net.minecraft.item.Item;

public class ItemTutorial extends Item {

    public ItemTutorial() {
        this.setUnlocalizedName("tutorial");
        this.setTextureName(References.MOD_ID + ":tutorial");
        this.setCreativeTab(TutorialMod.tutorialCreativeTabs);
        GameRegistry.registerItem(this, "item_tutorial");
    }
}
