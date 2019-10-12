package fr.teddy.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import fr.teddy.entities.aggressivemob.RenderTutorialAggressiveMob;
import fr.teddy.entities.aggressivemob.TutorialAggressiveMob;
import fr.teddy.events.KeyEvent;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.input.Keyboard;

public class ClientProxy extends CommonProxy{

    public static KeyBinding tutorialKeyGuiKill;

    public ClientProxy() {
        this.tutorialKeyGuiKill = new KeyBinding("tutorial_kill.key", Keyboard.KEY_K, "key.categories.gameplay");
        ClientRegistry.registerKeyBinding(this.tutorialKeyGuiKill);
        FMLCommonHandler.instance().bus().register(new KeyEvent(this));
    }

    public void init() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void registerRender() {
        //RenderingRegistry.registerEntityRenderingHandler(TutorialAggressiveMob.class, new RenderTutorialAggressiveMob());
    }



}
