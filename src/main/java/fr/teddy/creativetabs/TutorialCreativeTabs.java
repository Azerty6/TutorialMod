package fr.teddy.creativetabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.teddy.tutorialmod.TutorialMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TutorialCreativeTabs extends CreativeTabs {

    public static final String LABEL = "tutorial_creative_tabs";

    public TutorialCreativeTabs() {
        super(TutorialCreativeTabs.LABEL);
        this.setBackgroundImageName("tutorial_creative_tabs.png");
    }

    @Override
    public Item getTabIconItem() {
        return Item.getItemFromBlock(TutorialMod.tutorialBlock);
    }

    @Override
    public boolean hasSearchBar() {
        return true;
    }

}
