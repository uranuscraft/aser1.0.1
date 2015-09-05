package aser.entity;

import java.util.EnumSet;

import net.minecraftforge.common.ForgeDirection;
import aser.block.Transformers;

public class LVTransformer extends Transformer {

	@Override
    public float getRequest(ForgeDirection direction)
    {
        return this.getInputDirections().contains(direction) ? this.getMaxEnergyStored() - this.getEnergyStored() : 0;
    }

    @Override
    public float getProvide(ForgeDirection direction)
    {
        return this.getOutputDirections().contains(direction) ? Math.min(1.3F, this.getEnergyStored()) : 0;
    }

    @Override
    public EnumSet<ForgeDirection> getInputDirections()
    {
        return EnumSet.of(ForgeDirection.getOrientation(this.getBlockMetadata() - Transformers.HV_METADATA + 2).getOpposite(), ForgeDirection.UNKNOWN);
    }

    @Override
    public EnumSet<ForgeDirection> getOutputDirections()
    {
       
    	
    	return EnumSet.of(ForgeDirection.getOrientation(this.getBlockMetadata() - Transformers.HV_METADATA + 2), ForgeDirection.UNKNOWN);
    }

    @Override
    public float getMaxEnergyStored()
    {
        return 2500;
    }
@Override 
public float getVoltage() {
	return 60;
}

}
