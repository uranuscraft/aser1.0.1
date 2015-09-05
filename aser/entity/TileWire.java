package aser.entity;

import ic2.api.energy.tile.IEnergySink;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import universalelectricity.core.block.IElectrical;
import universalelectricity.core.electricity.ElectricityPack;
import buildcraft.api.power.IPowerReceptor;
import buildcraft.api.power.PowerHandler.PowerReceiver;
import buildcraft.api.power.PowerHandler.Type;
import cofh.api.energy.IEnergyHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import aser.item.ItemEletric;
import mekanism.api.Object3D;
import mekanism.api.energy.IStrictEnergyAcceptor;
import mekanism.api.transmitters.ITransmitter;
import mekanism.common.Mekanism;
import mekanism.common.tileentity.TileEntityUniversalCable;
import mekanism.common.util.MekanismUtils;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import mekanism.api.Object3D;
import mekanism.api.energy.IStrictEnergyAcceptor;
import mekanism.api.transmitters.DynamicNetwork;
import mekanism.api.transmitters.ITransmitter;


public class TileWire extends Cable {

	public float resistance;
    public float amperage;
    private double lastPowerScale = 0;
	private double joulesTransmitted = 0;
	private double joulesLastTick = 0;
	
	public double clientEnergyScale = 0;
    public TileWire()
    {
        this(0.05F, 360.0F);
    }

    public TileWire(float resistance, float amperage)
    {
        this.resistance = resistance;
        this.amperage = amperage;
    }

    @Override
    public float getResistance()
    {
        return this.resistance;
    }

    @Override
    public float getCurrentCapacity()
    {
        return this.amperage;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        this.resistance = nbt.getFloat("resistance");
        this.amperage = nbt.getFloat("amperage");
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        nbt.setFloat("resistance", this.resistance);
        nbt.setFloat("amperage", this.amperage);
    }

	@Override
	public double transferEnergyToAcceptor(ForgeDirection side, double amount) {
		// TODO Auto-generated method stub
		return 40;
	}

	@Override
	public boolean canReceiveEnergy(ForgeDirection side) {
		return true;
		
	
	}

	@Override
	public double getEnergy() {
		// TODO Auto-generated method stub
		return Energy;
	}
public static double Energy;
	@Override
	public void setEnergy(double energy) {
		// TODO Auto-generated method stub
		Energy = energy;
	}

	@Override
	public double getMaxEnergy() {
		
		return 10000000;
	}


	

	@Override
	public int extractEnergy(ForgeDirection from, int maxExtract,
			boolean simulate) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getEnergyStored(ForgeDirection from) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxEnergyStored(ForgeDirection from) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int receiveEnergy(ForgeDirection from, int maxReceive,
			boolean simulate) {
		// TODO Auto-generated method stub
		return 0;
	}

	





	



}
