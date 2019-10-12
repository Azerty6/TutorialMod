package fr.teddy.tools.tutorialtools;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.teddy.tutorialmod.TutorialMod;
import fr.teddy.utils.References;
import net.minecraft.item.ItemAxe;

public class TutorialAxe extends ItemAxe {

    public TutorialAxe(ToolMaterial material) {
        super(material);
        GameRegistry.registerItem(this, "tutorial_axe");
        this.setUnlocalizedName("tutorial_axe");
        this.setTextureName(References.MOD_ID + ":tutorial_axe");
        this.setCreativeTab(TutorialMod.tutorialCreativeTabs);
    }

}
