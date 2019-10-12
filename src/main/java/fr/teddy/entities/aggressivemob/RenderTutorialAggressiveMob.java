package fr.teddy.entities.aggressivemob;

import fr.teddy.utils.References;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelEnderman;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderEnderman;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderTutorialAggressiveMob extends Render {

    public final ResourceLocation texture = new ResourceLocation(References.MOD_ID, "textures/entity/tutorial_aggressive_mob.png");
    protected ModelTutorialAggressiveMob model;

    public RenderTutorialAggressiveMob(ModelTutorialAggressiveMob model) {
        this.model = model;
    }

    @Override
    public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return null;
    }



}
