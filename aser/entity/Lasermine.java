package aser.entity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class Lasermine extends EntityThrowable {

	public Lasermine(World par1World) {
		super(par1World);
		
	}
	public Lasermine(World world, EntityPlayer player) {
		super(world, player);
	}
	
	public Lasermine(World world, int par1, int par2, int par3) {
		super(world, par1, par2, par3);
	}
	
	
	float explosionRadius = 1.25f;
	@Override
	protected void onImpact(MovingObjectPosition movingobjectposition) {
		
		
		worldObj.destroyBlock((int)this.posX,(int)this.posY,(int) this.posZ, true);
		worldObj.playSoundEffect((double)1 + 0.5D, (double)1 + 0.5D, (double)1 + 0.5D, "fire.ignite", 1.0F, 1.0F * 0.4F + 0.8F);
		worldObj.destroyBlock((int)this.posX + 1,(int)this.posY,(int) this.posZ, true);
		worldObj.playSoundEffect((double)1 + 0.5D, (double)1 + 0.5D, (double)1 + 0.5D, "fire.ignite", 1.0F, 1.0F * 0.4F + 0.8F);
		worldObj.destroyBlock((int)this.posX - 1,(int)this.posY,(int) this.posZ, true);
		worldObj.playSoundEffect((double)1 + 0.5D, (double)1 + 0.5D, (double)1 + 0.5D, "fire.ignite", 1.0F, 1.0F * 0.4F + 0.8F);
		worldObj.destroyBlock((int)this.posX + 1,(int)this.posY + 1,(int) this.posZ, true);
		worldObj.playSoundEffect((double)1 + 0.5D, (double)1 + 0.5D, (double)1 + 0.5D, "fire.ignite", 1.0F, 1.0F * 0.4F + 0.8F);
		worldObj.destroyBlock((int)this.posX + 1,(int)this.posY - 1,(int) this.posZ, true);
		worldObj.playSoundEffect((double)1 + 0.5D, (double)1 + 0.5D, (double)1 + 0.5D, "fire.ignite", 1.0F, 1.0F * 0.4F + 0.8F);
		worldObj.destroyBlock((int)this.posX - 1,(int)this.posY + 1,(int) this.posZ, true);
		worldObj.playSoundEffect((double)1 + 0.5D, (double)1 + 0.5D, (double)1 + 0.5D, "fire.ignite", 1.0F, 1.0F * 0.4F + 0.8F);
		worldObj.destroyBlock((int)this.posX - 1,(int)this.posY - 1,(int) this.posZ, true);
		worldObj.playSoundEffect((double)1 + 0.5D, (double)1 + 0.5D, (double)1 + 0.5D, "fire.ignite", 1.0F, 1.0F * 0.4F + 0.8F);
		
		
		
		
		worldObj.destroyBlock((int)this.posX,(int)this.posY,(int) this.posZ + 1, true);
		worldObj.playSoundEffect((double)1 + 0.5D, (double)1 + 0.5D, (double)1 + 0.5D, "fire.ignite", 1.0F, 1.0F * 0.4F + 0.8F);
		worldObj.destroyBlock((int)this.posX,(int)this.posY,(int) this.posZ - 1, true);
		worldObj.playSoundEffect((double)1 + 0.5D, (double)1 + 0.5D, (double)1 + 0.5D, "fire.ignite", 1.0F, 1.0F * 0.4F + 0.8F);
		worldObj.destroyBlock((int)this.posX,(int)this.posY + 1,(int) this.posZ + 1, true);
		worldObj.playSoundEffect((double)1 + 0.5D, (double)1 + 0.5D, (double)1 + 0.5D, "fire.ignite", 1.0F, 1.0F * 0.4F + 0.8F);
		worldObj.destroyBlock((int)this.posX,(int)this.posY + 1,(int) this.posZ - 1, true);
		worldObj.playSoundEffect((double)1 + 0.5D, (double)1 + 0.5D, (double)1 + 0.5D, "fire.ignite", 1.0F, 1.0F * 0.4F + 0.8F);
		worldObj.destroyBlock((int)this.posX,(int)this.posY - 1,(int) this.posZ + 1, true);
		worldObj.playSoundEffect((double)1 + 0.5D, (double)1 + 0.5D, (double)1 + 0.5D, "fire.ignite", 1.0F, 1.0F * 0.4F + 0.8F);
		worldObj.destroyBlock((int)this.posX,(int)this.posY - 1,(int) this.posZ + 1, true);
		
		
		
		worldObj.destroyBlock((int)this.posX + 1,(int)this.posY,(int) this.posZ +1, true);
		worldObj.playSoundEffect((double)1 + 0.5D, (double)1 + 0.5D, (double)1 + 0.5D, "fire.ignite", 1.0F, 1.0F * 0.4F + 0.8F);
		worldObj.destroyBlock((int)this.posX - 1,(int)this.posY,(int) this.posZ + 1, true);
		worldObj.playSoundEffect((double)1 + 0.5D, (double)1 + 0.5D, (double)1 + 0.5D, "fire.ignite", 1.0F, 1.0F * 0.4F + 0.8F);
		worldObj.destroyBlock((int)this.posX + 1,(int)this.posY,(int) this.posZ - 1, true);
		worldObj.playSoundEffect((double)1 + 0.5D, (double)1 + 0.5D, (double)1 + 0.5D, "fire.ignite", 1.0F, 1.0F * 0.4F + 0.8F);
		worldObj.destroyBlock((int)this.posX - 1,(int)this.posY,(int) this.posZ - 1, true);
		worldObj.playSoundEffect((double)1 + 0.5D, (double)1 + 0.5D, (double)1 + 0.5D, "fire.ignite", 1.0F, 1.0F * 0.4F + 0.8F);
		
		
		
		
		worldObj.destroyBlock((int)this.posX + 1,(int)this.posY + 1,(int) this.posZ +1, true);
		worldObj.playSoundEffect((double)1 + 0.5D, (double)1 + 0.5D, (double)1 + 0.5D, "fire.ignite", 1.0F, 1.0F * 0.4F + 0.8F);
		worldObj.destroyBlock((int)this.posX - 1,(int)this.posY + 1,(int) this.posZ + 1, true);
		worldObj.playSoundEffect((double)1 + 0.5D, (double)1 + 0.5D, (double)1 + 0.5D, "fire.ignite", 1.0F, 1.0F * 0.4F + 0.8F);
		worldObj.destroyBlock((int)this.posX + 1,(int)this.posY + 1,(int) this.posZ - 1, true);
		worldObj.playSoundEffect((double)1 + 0.5D, (double)1 + 0.5D, (double)1 + 0.5D, "fire.ignite", 1.0F, 1.0F * 0.4F + 0.8F);
		worldObj.destroyBlock((int)this.posX - 1,(int)this.posY + 1,(int) this.posZ - 1, true);
		worldObj.playSoundEffect((double)1 + 0.5D, (double)1 + 0.5D, (double)1 + 0.5D, "fire.ignite", 1.0F, 1.0F * 0.4F + 0.8F);
		worldObj.destroyBlock((int)this.posX + 1,(int)this.posY - 1,(int) this.posZ +1, true);
		worldObj.playSoundEffect((double)1 + 0.5D, (double)1 + 0.5D, (double)1 + 0.5D, "fire.ignite", 1.0F, 1.0F * 0.4F + 0.8F);
		worldObj.destroyBlock((int)this.posX - 1,(int)this.posY - 1,(int) this.posZ + 1, true);
		worldObj.playSoundEffect((double)1 + 0.5D, (double)1 + 0.5D, (double)1 + 0.5D, "fire.ignite", 1.0F, 1.0F * 0.4F + 0.8F);
		worldObj.destroyBlock((int)this.posX + 1,(int)this.posY - 1,(int) this.posZ - 1, true);
		worldObj.playSoundEffect((double)1 + 0.5D, (double)1 + 0.5D, (double)1 + 0.5D, "fire.ignite", 1.0F, 1.0F * 0.4F + 0.8F);
		worldObj.destroyBlock((int)this.posX - 1,(int)this.posY - 1,(int) this.posZ - 1, true);
		
		
		worldObj.destroyBlock((int)this.posX,(int)this.posY + 1,(int) this.posZ, true);
		worldObj.playSoundEffect((double)1 + 0.5D, (double)1 + 0.5D, (double)1 + 0.5D, "fire.ignite", 1.0F, 1.0F * 0.4F + 0.8F);
		worldObj.destroyBlock((int)this.posX,(int)this.posY - 1,(int) this.posZ, true);
		worldObj.playSoundEffect((double)1 + 0.5D, (double)1 + 0.5D, (double)1 + 0.5D, "fire.ignite", 1.0F, 1.0F * 0.4F + 0.8F);
		this.setDead();	
	}
	@Override
	protected float getGravityVelocity() 
	{
	return 0;
	}
	
	
	
}
