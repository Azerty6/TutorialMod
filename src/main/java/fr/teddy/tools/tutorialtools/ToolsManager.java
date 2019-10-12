package fr.teddy.tools.tutorialtools;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class ToolsManager {

    protected Item.ToolMaterial tutoTool = EnumHelper.addToolMaterial("tutorialTool", 3, 2000, 100.0F, 10.0F, 20);
    public Item tutorialSword, tutorialPickaxe, tutorialAxe, tutorialShovel, tutorialHoe;

    public ToolsManager() {
        this.tutorialSword = new TutorialSword(this.tutoTool);
        this.tutorialPickaxe = new TutorialPickaxe(this.tutoTool);
        this.tutorialAxe = new TutorialAxe(this.tutoTool);
        this.tutorialShovel = new TutorialShovel(this.tutoTool);
        this.tutorialHoe = new TutorialHoe(this.tutoTool);
    }

}
