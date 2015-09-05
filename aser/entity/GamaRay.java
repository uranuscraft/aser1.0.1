package aser.entity;

import aser.item.Graser;
import aser.item.LaserPointer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class GamaRay extends EntityThrowable {

	public GamaRay(World world, EntityLivingBase entity) {
		super(world, entity);

	}

	@Override
	protected void onImpact(MovingObjectPosition movingobjectposition) {
		// TODO Auto-generated method stub
		EnumMovingObjectType hit = movingobjectposition.typeOfHit;
		if(hit.equals(hit.ENTITY)) {
			Entity entity = movingobjectposition.entityHit;
			Graser.onuse((EntityLivingBase)entity);
			worldObj.playSoundEffect((double)1 + 0.5D, (double)1 + 0.5D, (double)1 + 0.5D, "fire.ignite", 1.0F, 1.0F * 0.4F + 0.8F);
		}
	}

}
