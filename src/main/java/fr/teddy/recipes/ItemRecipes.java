package fr.teddy.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.teddy.tutorialmod.TutorialMod;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class ItemRecipes {

    public static void addRecipes() {
        GameRegistry.addRecipe(new ItemStack(TutorialMod.itemTutorial), new Object[] {"XXX", "XXX", "XXX", 'X', TutorialMod.tutorialBlock});
    }

}
