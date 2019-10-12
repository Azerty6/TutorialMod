package fr.teddy.blocks.tileentity;

import fr.teddy.tutorialmod.TutorialMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

public class TutorialBoxTileEntity extends TileEntity implements IInventory {

    protected ItemStack[] content = new ItemStack[54];
    private String customName;

    public TutorialBoxTileEntity(World world) {
        this.setContent(0, new ItemStack(TutorialMod.itemTutorial));
    }

    protected ItemStack getContent(int id) {
        if (id < this.getSizeInventory()) {
            return content[id];
        }
        return null;
    }

    protected void setContent(int id, ItemStack itemStack) {
        if (id < this.getSizeInventory()) {
            this.content[id] = itemStack;
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        if (compound.hasKey("CustomName", Constants.NBT.TAG_STRING)) {
            this.customName = compound.getString("CustomName");
        }
        NBTTagList nbtTagList = compound.getTagList("Items", Constants.NBT.TAG_COMPOUND);
        this.content = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < nbtTagList.tagCount(); i++) {
            NBTTagCompound nbtTagCompound = nbtTagList.getCompoundTagAt(i);
            int j = nbtTagCompound.getByte("Slot") & 255;
            if (j >= 0 && j < this.content.length) {
                this.content[j] = ItemStack.loadItemStackFromNBT(nbtTagCompound);
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        NBTTagList nbtTagList = new NBTTagList();
        for (int i = 0; i < this.getSizeInventory(); i++) {
            if (this.getContent(i) != null) {
                NBTTagCompound tmp = new NBTTagCompound();
                tmp.setByte("Slot", (byte)i);
                this.getContent(i).writeToNBT(tmp);
                nbtTagList.appendTag(tmp);
            }
        }
        nbt.setTag("Inventory", nbtTagList);
        this.markDirty();
    }

    @Override
    public int getSizeInventory() {
        return this.content.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        if (slot < this.getSizeInventory()) {
            ItemStack i = this.getContent(slot);
            return this.getContent(slot);
        }
        return null;
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount) {
        if (slot < this.getSizeInventory()) {
            if (this.getContent(slot) != null) {
                ItemStack itemStack;
                if (this.getContent(slot).stackSize <= amount) {
                    itemStack = this.getContent(slot);
                    this.setContent(slot, null);
                } else {
                    itemStack = this.getContent(slot).splitStack(amount);
                    if (this.getContent(slot).stackSize == 0) {
                        this.setContent(slot, null);
                    }
                }
                this.markDirty();
                return itemStack;
            }
        }
        return null;
    }

    public ItemStack getStackInSlotOnClosing(int slot) {
        if (this.content[slot] != null) {
            ItemStack itemStack = this.content[slot];
            this.content[slot] = null;
            return itemStack;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
        if (slot < this.getSizeInventory()) {
            this.content[slot] = stack;
        }
        if (stack != null && stack.stackSize > this.getInventoryStackLimit()) {
            stack.stackSize = this.getInventoryStackLimit();
        }
        this.markDirty();
    }

    @Override
    public String getInventoryName() {
        return this.hasCustomInventoryName() ? this.customName : "tile.tutorial_box";
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) == this;
    }

    @Override
    public boolean hasCustomInventoryName() {
        return this.customName != null;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        return true;
    }





}
