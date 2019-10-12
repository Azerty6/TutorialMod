package fr.teddy.structures;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import java.util.Random;

public class TutorialWorldGeneratorPillar {

    public void generate(World world, int x, int y, int z) {
        for (int i = y; i < 255; i++) {
            world.setBlock(x, i, z, Blocks.cobblestone);
        }
    }

}
