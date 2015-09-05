package aser.entity;

import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Set;

import cofh.api.energy.IEnergyHandler;
import ic2.api.energy.tile.IEnergyAcceptor;
import ic2.api.energy.tile.IEnergyEmitter;
import ic2.api.energy.tile.IEnergyTile;
import mekanism.api.energy.IStrictEnergyAcceptor;
import mekanism.api.transmitters.TransmissionType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import aser.entity.ASMHelper.RuntimeInterface;
import buildcraft.api.power.IPowerReceptor;
import buildcraft.api.power.PowerHandler;
import buildcraft.api.power.PowerHandler.PowerReceiver;
import buildcraft.api.power.PowerHandler.Type;
import universalelectricity.compatibility.Compatibility;
import universalelectricity.core.block.IConnector;
import universalelectricity.core.electricity.ElectricityPack;
import universalelectricity.core.vector.Vector3;
import universalelectricity.core.vector.VectorHelper;
import universalelectricity.prefab.tile.TileEntityConductor;
import mekanism.api.transmitters.ITransmitter;
import mekanism.api.transmitters.TransmissionType;
public abstract class Cable extends TileEntityConductor implements IStrictEnergyAcceptor, IEnergyHandler
{
    protected boolean isAddedToEnergyNet;
    public Object powerHandler;
    public float buildcraftBuffer = Compatibility.BC3_RATIO * 50;

    public Cable()
    {
        this.initBC();
    }

    private void initBC()
    {
        if (Compatibility.isBuildcraftLoaded())
        {
            if (this instanceof IPowerReceptor)
            {
                this.powerHandler = new PowerHandler((IPowerReceptor) this, Type.PIPE);
                ((PowerHandler) this.powerHandler).configure(0, this.buildcraftBuffer, this.buildcraftBuffer, this.buildcraftBuffer * 2);
                ((PowerHandler) this.powerHandler).configurePowerPerdition(0, 0);
            }
        }
    }

    @Override
    public TileEntity[] getAdjacentConnections()
    {
        if (this.adjacentConnections == null)
        {
            this.adjacentConnections = new TileEntity[6];

            for (byte i = 0; i < 6; i++)
            {
                ForgeDirection side = ForgeDirection.getOrientation(i);
                TileEntity tileEntity = VectorHelper.getTileEntityFromSide(this.worldObj, new Vector3(this), side);

                if (tileEntity instanceof IConnector)
                {
                    if (((IConnector) tileEntity).canConnect(side.getOpposite()))
                    {
                        this.adjacentConnections[i] = tileEntity;
                    }
                }
                else if (Compatibility.isIndustrialCraft2Loaded() && tileEntity instanceof IEnergyTile)
                {
                    if (tileEntity instanceof IEnergyAcceptor)
                    {
                        if (((IEnergyAcceptor) tileEntity).acceptsEnergyFrom(this, side.getOpposite()))
                        {
                            this.adjacentConnections[i] = tileEntity;
                            continue;
                        }
                    }

                    if (tileEntity instanceof IEnergyEmitter)
                    {
                        if (((IEnergyEmitter) tileEntity).emitsEnergyTo(tileEntity, side.getOpposite()))
                        {
                            this.adjacentConnections[i] = tileEntity;
                            continue;
                        }
                    }

                    this.adjacentConnections[i] = tileEntity;
                }
                else if (Compatibility.isBuildcraftLoaded() && tileEntity instanceof IPowerReceptor)
                {
                    if (((IPowerReceptor) tileEntity).getPowerReceiver(side.getOpposite()) != null)
                    {
                        this.adjacentConnections[i] = tileEntity;
                    }
                }
            }
        }

        return this.adjacentConnections;
    }

    @Override
    public boolean canUpdate()
    {
        return true;
    }

    @Override
    public void updateEntity()
    {
        if (!this.isAddedToEnergyNet)
        {
            if (!this.worldObj.isRemote)
            {
                if (Compatibility.isIndustrialCraft2Loaded())
                {
                    this.initIC();
                }
            }

            this.isAddedToEnergyNet = true;
        }
    }

    @Override
    public void invalidate()
    {
        this.unloadTileIC2();
        super.invalidate();
    }

    @Override
    public void onChunkUnload()
    {
        this.unloadTileIC2();
        super.onChunkUnload();
    }

    protected void initIC()
    {
        if (Compatibility.isIndustrialCraft2Loaded() && !this.worldObj.isRemote)
        {
            try
            {
                Class<?> tileLoadEvent = Class.forName("ic2.api.energy.event.EnergyTileLoadEvent");
                Class<?> energyTile = Class.forName("ic2.api.energy.tile.IEnergyTile");
                Constructor<?> constr = tileLoadEvent.getConstructor(energyTile);
                Object o = constr.newInstance(this);

                if (o != null && o instanceof Event)
                {
                    MinecraftForge.EVENT_BUS.post((Event) o);
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    private void unloadTileIC2()
    {
        if (this.isAddedToEnergyNet && this.worldObj != null)
        {
            if (!this.worldObj.isRemote && Compatibility.isIndustrialCraft2Loaded())
            {
                try
                {
                    Class<?> tileLoadEvent = Class.forName("ic2.api.energy.event.EnergyTileUnloadEvent");
                    Class<?> energyTile = Class.forName("ic2.api.energy.tile.IEnergyTile");
                    Constructor<?> constr = tileLoadEvent.getConstructor(energyTile);
                    Object o = constr.newInstance(this);

                    if (o != null && o instanceof Event)
                    {
                        MinecraftForge.EVENT_BUS.post((Event) o);
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            this.isAddedToEnergyNet = false;
        }
    }

    @RuntimeInterface(clazz = "ic2.api.energy.tile.IEnergySink", modID = "IC2")
    public double demandedEnergyUnits()
    {
        if (this.getNetwork() == null)
        {
            return 0.0;
        }

        return this.getNetwork().getRequest(this).getWatts() * Compatibility.TO_IC2_RATIO;
    }

    @RuntimeInterface(clazz = "ic2.api.energy.tile.IEnergySink", modID = "IC2")
    public double injectEnergyUnits(ForgeDirection directionFrom, double amount)
    {
        TileEntity tile = VectorHelper.getTileEntityFromSide(this.worldObj, new Vector3(this), directionFrom);
        ElectricityPack pack = ElectricityPack.getFromWatts((float) (amount * Compatibility.IC2_RATIO), 120);
        return this.getNetwork().produce(pack, this, tile) * Compatibility.TO_IC2_RATIO;
    }

    @RuntimeInterface(clazz = "ic2.api.energy.tile.IEnergySink", modID = "IC2")
    public int getMaxSafeInput()
    {
        return Integer.MAX_VALUE;
    }

    @RuntimeInterface(clazz = "ic2.api.energy.tile.IEnergyAcceptor", modID = "IC2")
    public boolean acceptsEnergyFrom(TileEntity emitter, ForgeDirection direction)
    {
        return true;
    }

    /**
     * BuildCraft functions
     */
    @RuntimeInterface(clazz = "buildcraft.api.power.IPowerReceptor", modID = "BuildCraft|Energy")
    public PowerReceiver getPowerReceiver(ForgeDirection side)
    {
        return ((PowerHandler) this.powerHandler).getPowerReceiver();
    }

    @RuntimeInterface(clazz = "buildcraft.api.power.IPowerReceptor", modID = "BuildCraft|Energy")
    public void doWork(PowerHandler workProvider)
    {
        Set<TileEntity> ignoreTiles = new HashSet<TileEntity>();
        ignoreTiles.add(this);

        for (ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS)
        {
            TileEntity tile = new Vector3(this).modifyPositionFromSide(direction).getTileEntity(this.worldObj);
            ignoreTiles.add(tile);
        }

        ElectricityPack pack = ElectricityPack.getFromWatts(workProvider.useEnergy(0, this.getNetwork().getRequest(this).getWatts() * Compatibility.TO_BC_RATIO, true) * Compatibility.BC3_RATIO, 120);
        this.getNetwork().produce(pack, ignoreTiles.toArray(new TileEntity[0]));
    }

    @RuntimeInterface(clazz = "buildcraft.api.power.IPowerReceptor", modID = "BuildCraft|Energy")
    public World getWorld()
    {
        return this.getWorldObj();
    }

   
    @Override
	public boolean canInterface(ForgeDirection from) 
	{
		return true;
	}

}
