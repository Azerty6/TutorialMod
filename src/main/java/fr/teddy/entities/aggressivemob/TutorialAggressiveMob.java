package fr.teddy.entities.aggressivemob;

import cpw.mods.fml.common.registry.EntityRegistry;
import fr.teddy.tutorialmod.TutorialMod;
import fr.teddy.utils.References;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class TutorialAggressiveMob extends EntityMob {

    public static void init() {
        EntityRegistry.registerGlobalEntityID(TutorialAggressiveMob.class, "tutorial_aggressive_mob", EntityRegistry.findGlobalUniqueEntityId(), References.COLORS.get("BLUE"), References.COLORS.get("RED"));
        EntityRegistry.registerModEntity(TutorialAggressiveMob.class, "tutorial_aggressive_mob", 420, TutorialMod.instance, 100, 1, true);
    }

    public TutorialAggressiveMob(World world) {
        super(world);
    }

    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6D);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(3D);
        EntityRegistry.registerGlobalEntityID(TutorialAggressiveMob.class, "tutorial_aggressive_mob", EntityRegistry.findGlobalUniqueEntityId(), References.COLORS.get("BLUE"), References.COLORS.get("RED"));
        EntityRegistry.registerModEntity(TutorialAggressiveMob.class, "tutorial_aggressive_mob", 420, TutorialMod.instance, 100, 1, true);
    }

    public Item getDropItem() {
        return Item.getItemFromBlock(TutorialMod.tutorialBlock);
    }


}
