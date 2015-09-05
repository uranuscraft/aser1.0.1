package aser.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import universalelectricity.core.electricity.ElectricityDisplay;
import universalelectricity.core.electricity.ElectricityDisplay.ElectricUnit;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import aser.block.Wire;

public class ItemWire extends ItemBlock
{
    public ItemWire(int id)
    {
        super(id);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
        switch (par1ItemStack.getItemDamage())
        {
        case 0:
            par3List.add("Resistance: " + ElectricityDisplay.getDisplay(0.05F, ElectricUnit.RESISTANCE));
            par3List.add("Max Amps: " + ElectricityDisplay.getDisplay(360.0F, ElectricUnit.AMPERE));
            break;
        case 1:
            par3List.add("Resistance: " + ElectricityDisplay.getDisplay(0.04F, ElectricUnit.RESISTANCE));
            par3List.add("Max Amps: " + ElectricityDisplay.getDisplay(60.0F, ElectricUnit.AMPERE));
            break;
        case 2:
            par3List.add("Resistance: " + ElectricityDisplay.getDisplay(0.02F, ElectricUnit.RESISTANCE));
            par3List.add("Max Amps: " + ElectricityDisplay.getDisplay(600.0F, ElectricUnit.AMPERE));
            break;
        case 3:
            par3List.add("Resistance: " + ElectricityDisplay.getDisplay(0.10F, ElectricUnit.RESISTANCE));
            par3List.add("Max Amps: " + ElectricityDisplay.getDisplay(20.0F, ElectricUnit.AMPERE));
            break;
        case 4:
            par3List.add("Resistance: " + ElectricityDisplay.getDisplay(0.00F, ElectricUnit.RESISTANCE));
            par3List.add("Max Amps: " + ElectricityDisplay.getDisplay(Float.POSITIVE_INFINITY, ElectricUnit.AMPERE));
            break;
        default:
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(int par1)
    {
        return Block.blocksList[this.getBlockID()].getIcon(0, par1);
    }

    @Override
    public String getUnlocalizedName(ItemStack par1ItemStack)
    {
        String name = "";

        switch (par1ItemStack.getItemDamage())
        {
        case 0:
            name = Wire.names[0];
            break;
        case 1:
            name = Wire.names[1];
            break;
        case 2:
            name = Wire.names[2];
            break;
        case 3:
            name = Wire.names[3];
            break;   
        case 4:
            name = Wire.names[4];
            break;
            
        default:
            name = "null";
            break;
        }

        return "tile." + name;
    }

    

    @Override
    public int getMetadata(int damage)
    {
        return damage;
    }

}
