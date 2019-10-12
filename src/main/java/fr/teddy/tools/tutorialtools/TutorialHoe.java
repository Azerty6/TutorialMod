package fr.teddy.tools.tutorialtools;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.teddy.tutorialmod.TutorialMod;
import fr.teddy.utils.References;
import net.minecraft.item.ItemHoe;

public class TutorialHoe extends ItemHoe {

    public TutorialHoe(ToolMaterial material) {
        super(material);
        GameRegistry.registerItem(this, "tutorial_hoe");
        this.setUnlocalizedName("tutorial_hoe");
        this.setTextureName(References.MOD_ID + ":tutorial_hoe");
        this.setCreativeTab(TutorialMod.tutorialCreativeTabs);
    }

}
