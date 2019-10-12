package fr.teddy.tools.tutorialtools;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.teddy.tutorialmod.TutorialMod;
import fr.teddy.utils.References;
import net.minecraft.item.ItemPickaxe;

public class TutorialPickaxe extends ItemPickaxe {

    public TutorialPickaxe(ToolMaterial material) {
        super(material);
        GameRegistry.registerItem(this, "tutorial_pickaxe");
        this.setUnlocalizedName("tutorial_pickaxe");
        this.setTextureName(References.MOD_ID + ":tutorial_pickaxe");
        this.setCreativeTab(TutorialMod.tutorialCreativeTabs);
    }

}
