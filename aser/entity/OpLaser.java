package aser.entity;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class OpLaser extends EntityThrowable {
	
	public OpLaser(World par1World, EntityLivingBase par2EntityLivingBase) {
		super(par1World, par2EntityLivingBase);
		
	}
	
	@Override
	protected void onImpact(MovingObjectPosition movingobjectposition) {
		 int id = worldObj.getBlockId(movingobjectposition.blockX, movingobjectposition.blockY, movingobjectposition.blockZ);
	       
	         
	    	   
	    	   if(id==Block.anvil.blockID)
               {
	    		   int newId = Block.blockIron.blockID;
                   worldObj.setBlock(movingobjectposition.blockX, movingobjectposition.blockY, movingobjectposition.blockZ, newId);
    	           this.setDead();
               }
               else if(id==Block.sand.blockID ){
            	   int newId = Block.glass.blockID;
            	  worldObj.setBlock(movingobjectposition.blockX, movingobjectposition.blockY, movingobjectposition.blockZ, newId);
    	           this.setDead();
               }
               else if(id==Block.ice.blockID ){
            	  int newId = Block.waterStill.blockID;
            	   worldObj.setBlock(movingobjectposition.blockX, movingobjectposition.blockY, movingobjectposition.blockZ, newId);
    	           this.setDead();
               }
               else if(id==Block.stone.blockID ){
            	   int newId = Block.lavaStill.blockID;
            	   worldObj.setBlock(movingobjectposition.blockX, movingobjectposition.blockY, movingobjectposition.blockZ, newId);
    	           this.setDead();
               }
               else if(id==Block.stoneBrick.blockID ){
            	   int newId = Block.lavaStill.blockID;
            	   worldObj.setBlock(movingobjectposition.blockX, movingobjectposition.blockY, movingobjectposition.blockZ, newId);
    	           this.setDead();
               }
               else if(id==Block.cobblestone.blockID ){
            	   int newId = Block.lavaStill.blockID;
            	   worldObj.setBlock(movingobjectposition.blockX, movingobjectposition.blockY, movingobjectposition.blockZ, newId);
    	           this.setDead();
               }
               else if(id==Block.cobblestoneMossy.blockID ){
            	   int newId = Block.lavaStill.blockID;
            	   worldObj.setBlock(movingobjectposition.blockX, movingobjectposition.blockY, movingobjectposition.blockZ, newId);
    	           this.setDead();
               }
               else if(id==Block.cobblestoneWall.blockID ){
            	   int newId = Block.lavaStill.blockID;
            	   worldObj.setBlock(movingobjectposition.blockX, movingobjectposition.blockY, movingobjectposition.blockZ, newId);
    	           this.setDead();
               }
               else
               {
            	  int newId = Block.lavaMoving.blockID;
            	   worldObj.setBlock(movingobjectposition.blockX, movingobjectposition.blockY, movingobjectposition.blockZ, newId);
    	           this.setDead();
               }
	    	   
	    	   
	          
	           
	       }
		
	
	@Override
	protected float getGravityVelocity() 
	{
	return 0;
	}
}
