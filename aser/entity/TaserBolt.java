package aser.entity;


import aser.item.Taser;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class TaserBolt extends EntityThrowable {

	public TaserBolt(World par1World, EntityLivingBase par2EntityLivingBase) {
		super(par1World, par2EntityLivingBase);
		
	}

	@Override
	protected void onImpact(MovingObjectPosition movingobjectposition) {
		EnumMovingObjectType hit = movingobjectposition.typeOfHit;
		
		
		if(hit.equals(hit.ENTITY)) {
			Entity entity = movingobjectposition.entityHit;
			Taser.onuse((EntityLivingBase)entity);
			worldObj.playSoundEffect((double)1 + 0.5D, (double)1 + 0.5D, (double)1 + 0.5D, "fire.ignite", 1.0F, 1.0F * 0.4F + 0.8F);
		}
		
	}

}
