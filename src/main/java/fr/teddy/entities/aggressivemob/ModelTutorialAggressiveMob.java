package fr.teddy.entities.aggressivemob;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTutorialAggressiveMob extends ModelBase {

    ModelRenderer body;
    ModelRenderer leftArm;
    ModelRenderer rightArm;

    public ModelTutorialAggressiveMob() {
        this.textureHeight = 32;
        this.textureWidth = 32;
        this.body = new ModelRenderer(this, 0, 0);
        this.body.addBox(16, 16, 16, -8, 23, -8);
        this.body.setTextureSize(16, 16);
        this.leftArm = new ModelRenderer(this, 0, 0);
        this.leftArm.addBox(16, 2, 2, 0, 35, 0);
        this.leftArm.setTextureSize(16, 2);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.body.render(f5);
        this.leftArm.render(f5);
    }

}
