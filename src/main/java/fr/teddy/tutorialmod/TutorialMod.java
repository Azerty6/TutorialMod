package fr.teddy.tutorialmod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import fr.teddy.armors.tutorialarmor.TutoArmor;
import fr.teddy.blocks.TutorialBlock;
import fr.teddy.blocks.TutorialBox;
//import fr.teddy.blocks.TutorialSecretBlock;
import fr.teddy.blocks.TutorialUnclaimFinderMachine;
import fr.teddy.creativetabs.TutorialCreativeTabs;
import fr.teddy.entities.aggressivemob.TutorialAggressiveMob;
import fr.teddy.gui.TutorialGUIHandler;
import fr.teddy.gui.TutorialRenderEventHandler;
import fr.teddy.items.ItemTutorial;
import fr.teddy.items.TutorialPillar;
import fr.teddy.items.TutorialUnclaimFinder;
import fr.teddy.proxy.CommonProxy;
import fr.teddy.recipes.ItemRecipes;
import fr.teddy.tools.tutorialtools.ToolsManager;
import fr.teddy.utils.References;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;


@Mod(modid = References.MOD_ID, name = References.NAME,version = References.VERSION)
public class TutorialMod {

    @Instance(References.MOD_ID)
    public static TutorialMod instance;
    @SidedProxy(clientSide = "fr.teddy.proxy.ClientProxy", serverSide = "fr.teddy.proxy.CommonProxy")
    public static CommonProxy proxy;
    public static Item itemTutorial;
    public static Item tutorialUnclaimFinderGreen;
    public static Item tutorialUnclaimFinderYellow;
    public static Item tutorialUnclaimFinderRed;
    public static Item tutorialPillar;
    public static TutoArmor tutorialArmor;
    public static ToolsManager tutorialTools;
    public static Block tutorialBlock;
    public static  Block tutorialBox;
    // Do not use this block : it can crash the game (not finished)
    //public static Block tutorialSecretBlock;
    public static Block tutorialUnclaimFinderMachine;
    public static EntityMob tutorialAggressiveMob;
    public static CreativeTabs tutorialCreativeTabs = new TutorialCreativeTabs();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        References.init();
        TutorialMod.itemTutorial = new ItemTutorial();
        TutorialMod.tutorialUnclaimFinderGreen = new TutorialUnclaimFinder(0);
        TutorialMod.tutorialUnclaimFinderYellow = new TutorialUnclaimFinder(1);
        TutorialMod.tutorialUnclaimFinderRed = new TutorialUnclaimFinder(2);
        TutorialMod.tutorialPillar = new TutorialPillar();
        TutorialMod.tutorialArmor = new TutoArmor();
        TutorialMod.tutorialTools = new ToolsManager();
        TutorialMod.tutorialBlock = new TutorialBlock();
        TutorialMod.tutorialBox = new TutorialBox();
        TutorialMod.tutorialUnclaimFinderMachine = new TutorialUnclaimFinderMachine();
        //TutorialMod.tutorialSecretBlock = new TutorialSecretBlock();
        TutorialMod.tutorialAggressiveMob = new TutorialAggressiveMob(Minecraft.getMinecraft().theWorld);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        TutorialMod.proxy.registerRender();
        TutorialAggressiveMob.init();
        NetworkRegistry.INSTANCE.registerGuiHandler(TutorialMod.instance, new TutorialGUIHandler());
        ItemRecipes.addRecipes();
        MinecraftForge.EVENT_BUS.register(TutorialRenderEventHandler.INSTANCE);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
