package fr.teddy.tools.tutorialtools;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.teddy.tutorialmod.TutorialMod;
import fr.teddy.utils.References;
import net.minecraft.item.ItemSpade;

public class TutorialShovel extends ItemSpade {

    public TutorialShovel(ToolMaterial material) {
        super(material);
        GameRegistry.registerItem(this, "tutorial_shovel");
        this.setUnlocalizedName("tutorial_shovel");
        this.setTextureName(References.MOD_ID + ":tutorial_shovel");
        this.setCreativeTab(TutorialMod.tutorialCreativeTabs);
    }

}
