package fr.teddy.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.teddy.tutorialmod.TutorialMod;
import fr.teddy.utils.References;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class TutorialBlock extends Block {

    public TutorialBlock() {
        super(Material.rock);
        this.setBlockName("tutorial_block");
        this.setBlockTextureName(References.MOD_ID + ":tutorial_block");
        this.setCreativeTab(TutorialMod.tutorialCreativeTabs);
        GameRegistry.registerBlock(this, "tutorial_block");
    }

}
