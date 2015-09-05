package aser.entity;

import aser.item.LaserPointer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class LaserPoint extends EntityThrowable {

	public LaserPoint(World world, EntityLivingBase entity) {
		super(world, entity);

	}

	public LaserPoint(World world, int x, int y, int z) {
		super(world,x,y,z);
	}

	@Override
	protected void onImpact(MovingObjectPosition movingobjectposition) {
		
		EnumMovingObjectType hit = movingobjectposition.typeOfHit;
		
	
		if(hit.equals(hit.ENTITY)) {
			Entity entity = movingobjectposition.entityHit;
			LaserPointer.onUse((EntityLivingBase)entity);
			worldObj.playSoundEffect((double)1 + 0.5D, (double)1 + 0.5D, (double)1 + 0.5D, "fire.ignite", 1.0F, 1.0F * 0.4F + 0.8F);
		}
		
	
	
	
	}
	@Override
	protected float getGravityVelocity() 
	{
	return 0;
	}
}
