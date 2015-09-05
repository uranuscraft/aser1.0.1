package aser.item;

import java.util.List;

import ic2.api.item.IElectricItemManager;
import ic2.api.item.ISpecialElectricItem;
import universalelectricity.core.electricity.ElectricityDisplay;
import universalelectricity.core.electricity.ElectricityDisplay.ElectricUnit;
import universalelectricity.core.item.IItemElectric;
import cofh.api.energy.IEnergyContainerItem;
import aser.core.Base;
import mekanism.api.EnumColor;
import mekanism.api.energy.IEnergizedItem;
import mekanism.common.util.MekanismUtils;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemEletric extends Item implements IEnergizedItem, IItemElectric, ISpecialElectricItem, IEnergyContainerItem{
	/** The maximum amount of energy this item can hold. */
	public double MAX_ELECTRICITY;
	
	/** How fast this item can transfer energy. */
	public float VOLTAGE;
	public ItemEletric(int par1,double maxElectricity, float voltage) {
		super(par1);
		MAX_ELECTRICITY = maxElectricity;
		VOLTAGE = voltage;
		setMaxStackSize(1);
		setMaxDamage(100);
		setNoRepair();
	}
	
	
	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer entityplayer, List list, boolean flag)
	{
		list.add(EnumColor.AQUA + "Stored Energy: " + EnumColor.GREY + getEnergyDisplay(getEnergy(itemstack)));
		list.add(EnumColor.AQUA + "Voltage: " + EnumColor.GREY + getVoltage(itemstack) + "v");
	}
	
	
	@Override
	public void registerIcons(IconRegister register)
	{
		itemIcon = register.registerIcon(Base.modid + getUnlocalizedName().replace("item.", ""));
	}
	@Override
	public float getVoltage(ItemStack itemStack) 
	{
		return VOLTAGE;
	}
	
	@Override
	public boolean canProvideEnergy(ItemStack itemStack)
	{
		return canSend(itemStack);
	}

	@Override
	public int getChargedItemId(ItemStack itemStack)
	{
		return itemID;
	}

	@Override
	public int getEmptyItemId(ItemStack itemStack)
	{
		return itemID;
	}

	@Override
	public int getMaxCharge(ItemStack itemStack)
	{
		return 0;
	}

	@Override
	public int getTier(ItemStack itemStack)
	{
		return 4;
	}

	@Override
	public int getTransferLimit(ItemStack itemStack)
	{
		return 0;
	}

	@Override
	public double getEnergy(ItemStack itemStack) 
	{
		if(itemStack.stackTagCompound == null) 
		{ 
			return 0; 
		}
		
		double electricityStored = itemStack.stackTagCompound.getDouble("electricity");
		itemStack.setItemDamage((int)Math.max(1, (Math.abs(((electricityStored/getMaxEnergy(itemStack))*100)-100))));
		
		return electricityStored;
	}

	@Override
	public void setEnergy(ItemStack itemStack, double amount) 
	{
		if(itemStack.stackTagCompound == null)
		{
			itemStack.setTagCompound(new NBTTagCompound());
		}

		double electricityStored = Math.max(Math.min(amount, getMaxEnergy(itemStack)), 0);
		itemStack.stackTagCompound.setDouble("electricity", electricityStored);
		itemStack.setItemDamage((int)Math.max(1, (Math.abs(((electricityStored/getMaxEnergy(itemStack))*100)-100))));
	}

	@Override
	public double getMaxEnergy(ItemStack itemStack) 
	{
		return MAX_ELECTRICITY;
	}

	@Override
	public double getMaxTransfer(ItemStack itemStack) 
	{
		return getMaxEnergy(itemStack)*0.005;
	}

	@Override
	public boolean canReceive(ItemStack itemStack) 
	{
		return true;
	}

	@Override
	public boolean canSend(ItemStack itemStack)
	{
		return true;
	}
	
	@Override
	public void onCreated(ItemStack itemstack, World world, EntityPlayer entityplayer)
	{
		itemstack = getUnchargedItem();
	}
	public ItemStack getUnchargedItem()
	{
		ItemStack charged = new ItemStack(this);
		charged.setItemDamage(100);
		return charged;
	}
	@Override
	public void getSubItems(int i, CreativeTabs tabs, List list)
	{
		ItemStack discharged = new ItemStack(this);
		discharged.setItemDamage(100);
		list.add(discharged);
		ItemStack charged = new ItemStack(this);
		setEnergy(charged, ((IEnergizedItem)charged.getItem()).getMaxEnergy(charged));
		list.add(charged);
	}
	
	
	@Override
	public int receiveEnergy(ItemStack theItem, int energy, boolean simulate)
	{
		if(canReceive(theItem))
		{
			double energyNeeded = getMaxEnergy(theItem)-getEnergy(theItem);
			double toReceive = Math.min(energy*this.FROM_TE, energyNeeded);
			
			if(!simulate)
			{
				setEnergy(theItem, getEnergy(theItem) + toReceive);
			}
			
			return (int)Math.round(toReceive*this.TO_TE);
		}
		
		return 0;
	}

	@Override
	public int extractEnergy(ItemStack theItem, int energy, boolean simulate) 
	{
		if(canSend(theItem))
		{
			double energyRemaining = getEnergy(theItem);
			double toSend = Math.min((energy*this.FROM_TE), energyRemaining);
			
			if(!simulate)
			{
				setEnergy(theItem, getEnergy(theItem) - toSend);
			}
			
			return (int)Math.round(toSend*this.TO_TE);
		}
		
		return 0;
	}

	@Override
	public int getEnergyStored(ItemStack theItem)
	{
		return (int)Math.round(getEnergy(theItem)*this.TO_TE);
	}

	@Override
	public int getMaxEnergyStored(ItemStack theItem)
	{
		return (int)Math.round(getMaxEnergy(theItem)*this.TO_TE);
	}
	
	@Override
	public boolean isMetadataSpecific()
	{
		return false;
	}

	@Override
	public float recharge(ItemStack itemStack, float energy, boolean doRecharge) 
	{
		if(canReceive(itemStack))
		{
			double energyNeeded = getMaxEnergy(itemStack)-getEnergy(itemStack);
			double toReceive = Math.min(energy*this.FROM_UE, energyNeeded);
			
			if(doRecharge)
			{
				setEnergy(itemStack, getEnergy(itemStack) + toReceive);
			}
			
			return (float)(toReceive*this.TO_UE);
		}
		
		return 0;
	}

	@Override
	public float discharge(ItemStack itemStack, float energy, boolean doDischarge) 
	{
		if(canSend(itemStack))
		{
			double energyRemaining = getEnergy(itemStack);
			double toSend = Math.min((energy*this.FROM_UE), energyRemaining);
			
			if(doDischarge)
			{
				setEnergy(itemStack, getEnergy(itemStack) - toSend);
			}
			
			return (float)(toSend*this.TO_UE);
		}
		
		return 0;
	}

	@Override
	public float getElectricityStored(ItemStack theItem) 
	{
		return (float)(getEnergy(theItem)*this.TO_UE);
	}

	@Override
	public float getMaxElectricityStored(ItemStack theItem) 
	{
		return (float)(getMaxEnergy(theItem)*this.TO_UE);
	}

	@Override
	public void setElectricity(ItemStack itemStack, float joules) 
	{
		setEnergy(itemStack, joules*this.TO_UE);
	}

	@Override
	public float getTransfer(ItemStack itemStack)
	{
		return (float)(getMaxTransfer(itemStack)*this.TO_UE);
	}

	@Override
	public IElectricItemManager getManager(ItemStack itemStack) 
	{
		return IC2ItemManager.getManager(this);
	}
public static double ENERGY_PER_REDSTONE = 10000;
public static String getEnergyDisplay(double energy)
{
	return ElectricityDisplay.getDisplayShort((float)(energy*ItemEletric.TO_UE), ElectricUnit.JOULES);
}
	public static double TO_IC2;
	public static double TO_BC;
	public static double TO_TE;
	public static double TO_UE = .001;
	public static double FROM_IC2;
	public static double FROM_BC;
	public static double FROM_TE;
	public static double FROM_UE = 1000;
	
	public ItemStack getChargedItem()
	{
		ItemStack charged = new ItemStack(this);
		charged.setItemDamage(0);
		return charged;
	}
}
