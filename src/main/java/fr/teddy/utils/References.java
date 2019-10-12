package fr.teddy.utils;

import java.awt.*;
import java.util.Hashtable;

public class References {
    public static final String MOD_ID = "tutorialmod";
    public static final String VERSION = "1.0";
    public static final String NAME = "Tutorial Mod";
    public static final Hashtable<String, Integer> COLORS = new Hashtable<String, Integer>();

    public static void init() {
        References.COLORS.put("RED", new Color(255, 0, 0).getRGB());
        References.COLORS.put("GREEN", new Color(0, 255, 0).getRGB());
        References.COLORS.put("BLUE", new Color(0, 0, 255).getRGB());
    }

}
