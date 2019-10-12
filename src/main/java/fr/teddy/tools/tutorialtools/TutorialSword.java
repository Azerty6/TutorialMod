package fr.teddy.tools.tutorialtools;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.teddy.tutorialmod.TutorialMod;
import fr.teddy.utils.References;
import net.minecraft.item.ItemSword;

public class TutorialSword extends ItemSword {

    public TutorialSword(ToolMaterial material) {
        super(material);
        GameRegistry.registerItem(this, "tutorial_sword");
        this.setUnlocalizedName("tutorial_sword");
        this.setTextureName(References.MOD_ID + ":tutorial_sword");
        this.setCreativeTab(TutorialMod.tutorialCreativeTabs);
    }

}
