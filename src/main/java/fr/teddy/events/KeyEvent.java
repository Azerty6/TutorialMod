package fr.teddy.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import fr.teddy.gui.TutorialGUIKill;
import fr.teddy.proxy.ClientProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

public class KeyEvent {

    protected ClientProxy proxy;

    public KeyEvent(ClientProxy proxy) {
        this.proxy = proxy;
    }

    @SubscribeEvent
    public void onKeyGuiEventPressed(InputEvent.KeyInputEvent event) {
        if (this.proxy.tutorialKeyGuiKill.isPressed()) {
            new TutorialGUIKill(Minecraft.getMinecraft(), Minecraft.getMinecraft().thePlayer);
        }
    }
}
