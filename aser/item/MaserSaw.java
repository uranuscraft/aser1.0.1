package aser.item;

import aser.core.Base;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mekanism.api.EnumColor;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class MaserSaw extends ItemEletric {

	public MaserSaw(int par1, double maxElectricity, float voltage) {
		super(par1, 200000000, 120);
		setUnlocalizedName("saw");
		setCreativeTab(CreativeTabs.tabTools);
	}
	 @Override
	    public boolean hitEntity(ItemStack itemstack, EntityLivingBase hitEntity, EntityLivingBase player)
	    {
	    	if(getEnergy(itemstack) >= 2000)
	    	{
	    		PotionEffect potion = new PotionEffect(19, 300);
	    		
	    		hitEntity.addPotionEffect(potion);
	    		
	    		hitEntity.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)player), 10);
	    		
	    		
	    			
	    			setEnergy(itemstack, getEnergy(itemstack) - 2000);
	    	}
	    	else {
	    		hitEntity.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)player), 4);
	    	}
	    	
	        return false;
	    }
	 
	 
	 
	 
	 
	 @Override
	    public boolean onBlockDestroyed(ItemStack itemstack, World world, int id, int x, int y, int z, EntityLivingBase entityliving)
	    {
	        if(id == Block.wood.blockID && getEnergy(itemstack) >= 2000 ) {
	        	world.getBlockId(x, y, z);
	        	int place = 0;
	        	int poszblock = 0;
	        	int posxblock = 0;
	        	int posyblock = 0;
	        	int posyxblock = 0;
	        	int posyzblock = 0;
	        	
	        	int posxyzblock = 0;
	        	setEnergy(itemstack, getEnergy(itemstack) - 2000);
	        	do{
	        		place++;
	        		posxblock = world.getBlockId(x + place, y, z);
	        		
	        		world.destroyBlock(x + place, y, z, true);
	        	
	        	}while(posxblock == Block.wood.blockID || posxblock == Block.leaves.blockID);
	        	
	        	
	        	place = 0;
	        	do{
	        		place++;
	        		
	        		 poszblock = world.getBlockId(x, y, z + place);
	        		
	        		 world.destroyBlock(x, y, z + place, true);
	        	
	        	}while(poszblock == Block.wood.blockID || poszblock == Block.leaves.blockID);
	        	place = 0;
	        	do{
	        		place++;
	        		
	        		posyblock = world.getBlockId(x, y + place, z);
	        		world.destroyBlock(x, y + place, z, true);
	        	
	        	}while(posyblock == Block.wood.blockID || posyblock == Block.leaves.blockID);
	        	place = 0;
	        	do{
	        		place++;
	        		
	        		posyxblock = world.getBlockId(x + place, y + place, z);
	        		world.destroyBlock(x + place, y + place, z, true);
	        	
	        	
	        	}while(posyxblock == Block.wood.blockID || posyxblock == Block.leaves.blockID);
	        	place = 0;
	        	do{
	        		place++;
	        		
	        		posyxblock = world.getBlockId(x + 1, y + place, z);
	        		world.destroyBlock(x + 1, y + place, z, true);
	        	
	        	
	        	}while(posyxblock == Block.wood.blockID || posyxblock == Block.leaves.blockID);
	        	place = 0;
	        	do{
	        		place++;
	        		
	        		posyxblock = world.getBlockId(x, y + place, z + 1);
	        		world.destroyBlock(x, y + place, z + 1, true);
	        	
	        	
	        	}while(posyxblock == Block.wood.blockID || posyxblock == Block.leaves.blockID);
	        	place = 0;
	        	do{
	        		place++;
	        		
	        		posyxblock = world.getBlockId(x + 1, y + place, z + 1);
	        		world.destroyBlock(x + 1, y + place, z + 1, true);
	        	
	        	
	        	}while(posyxblock == Block.wood.blockID || posyxblock == Block.leaves.blockID);
	        	place = 0;
	        	do{
	        		place++;
	        		
	        		posyxblock = world.getBlockId(x - 1, y + place, z);
	        		world.destroyBlock(x - 1, y + place, z, true);
	        	
	        	
	        	}while(posyxblock == Block.wood.blockID || posyxblock == Block.leaves.blockID);
	        	place = 0;
	        	do{
	        		place++;
	        		
	        		posyxblock = world.getBlockId(x, y + place, z - 1);
	        		world.destroyBlock(x, y + place, z - 1, true);
	        	
	        	
	        	}while(posyxblock == Block.wood.blockID || posyxblock == Block.leaves.blockID);
	        	place = 0;
	        	do{
	        		place++;
	        		
	        		posyxblock = world.getBlockId(x - 1, y + place, z - 1);
	        		world.destroyBlock(x - 1, y + place, z - 1, true);
	        	
	        	
	        	}while(posyxblock == Block.wood.blockID || posyxblock == Block.leaves.blockID);
	        
	        	place = 0;
	        	do{
	        		place++;
	        		
	        		posyzblock = world.getBlockId(x, y + place, z + place);
	        		
	        	
	        		world.destroyBlock(x, y + place, z + place, true);
	        	
	        	}while(posyzblock == Block.wood.blockID || posyzblock == Block.leaves.blockID);
	        	place = 0;
	        	do{
	        		place++;
	        		
	        		posxyzblock = world.getBlockId(x + place, y + place, z + place);
	        	
	        	
	        		world.destroyBlock(x + place, y + place, z + place, true);
	        	}while(posxyzblock == Block.wood.blockID || posxyzblock == Block.leaves.blockID);
	        
	        
	        
	        	
	        	
	        	int neg = 0;
	        	
	        	place = 0;
	        	do{
	        		place++;
	        		
	        		neg--;
	        		posxblock = world.getBlockId(x + neg, y, z);
	        		
	        	
	        	
	        	}while(posxblock == Block.wood.blockID || posxblock == Block.leaves.blockID);
	        	place = 0;
	        	
	        	neg = 0;
	        	
	        	do{
	        		place++;
	        		neg--;
	        		 poszblock = world.getBlockId(x, y, z + neg);
	        		 world.destroyBlock(x, y, z + neg, true);
	        	
	        	
	        	}while(poszblock == Block.wood.blockID || poszblock == Block.leaves.blockID);
	        	place = 0;
	        	
	        	neg = 0;
	        	do{
	        		place++;
	        		neg--;
	        		posyblock = world.getBlockId(x, y + place, z);
	        		world.destroyBlock(x, y + place, z, true);
	        	
	        	}while(posyblock == Block.wood.blockID || posyblock == Block.leaves.blockID);
	        	place = 0;
	        	
	        	neg = 0;
	        	
	        	do{
	        		place++;
	        		neg--;
	        		posyxblock = world.getBlockId(x + neg, y + place, z);
	        		
	        		world.destroyBlock(x + neg, y + place, z, true);
	        	
	        	}while(posyxblock == Block.wood.blockID || posyxblock == Block.leaves.blockID);
	        
	        	neg = 0;
	        	place = 0;
	        	do{
	        		place++;
	        		neg--;
	        		posyzblock = world.getBlockId(x, y + place, z + neg);
	        		
	        	
	        		world.destroyBlock(x, y + place, z + neg, true);
	        	
	        	}while(posyzblock == Block.wood.blockID || posyzblock == Block.leaves.blockID);
	        	place = 0;
	        	neg = 0;
	        	do{
	        		place++;
	        		neg--;
	        		posxyzblock = world.getBlockId(x + neg, y + place, z + neg);
	        	
	        	world.destroyBlock(x + neg, y + place, z + neg, true);
	        	
	        	}while(posxyzblock == Block.wood.blockID || posxyzblock == Block.leaves.blockID);
	        	return true;
	        }
	        else {
	        return false;
	        }
	        }
	 
	 @SideOnly(Side.CLIENT)
		public void registerIcons(IconRegister par1IconRegister)
		{
		    this.itemIcon = par1IconRegister.registerIcon(Base.modid + ":" + (this.getUnlocalizedName().substring(5)));
		}



	 public float getStrVsBlock(ItemStack itemstack, Block block)
	    {
	    	return getEnergy(itemstack) != 0 ? getEfficiency(itemstack) : 1F;
	    }
	    

	 public int getEfficiency(ItemStack itemStack)
	    {
			if(itemStack.stackTagCompound == null)
			{
				return 2;
			}
			
			int efficiency = 2;
			
			if(itemStack.stackTagCompound.getTag("efficiency") != null)
			{
				efficiency = itemStack.stackTagCompound.getInteger("efficiency");
			}
			
			return efficiency;
	    }
	 @Override
	    public boolean isFull3D()
	    {
	        return true;
	    }
	 @Override
	    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
	    {
			if(!world.isRemote && entityplayer.isSneaking())
			{
				incrementEfficiency(itemstack);
	    		entityplayer.addChatMessage(EnumColor.DARK_BLUE + "[Mekanism] " + EnumColor.GREY + "Efficiency bumped to " + getEfficiency(itemstack));
			}
			
	        return itemstack;
	    }


	 public void incrementEfficiency(ItemStack itemStack)
	    {
			if(itemStack.stackTagCompound == null)
			{
				itemStack.setTagCompound(new NBTTagCompound());
				itemStack.stackTagCompound.setInteger("efficiency", 20);
			}
			
			itemStack.stackTagCompound.setInteger("efficiency", getIncremented(getEfficiency(itemStack)));
	    }
	 public int getIncremented(int previous)
	    {
	    	if(previous == 0)
	    	{
	    		return 2;
	    	}
	    	else if(previous == 2)
	    	{
	    		return 8;
	    	}
	    	else if(previous == 8)
	    	{
	    		return 24;
	    	}
	    	else if(previous == 24)
	    	{
	    		return 64;
	    	}
	    	else if(previous == 64)
	    	{
	    		return 100;
	    	}
	    	else if(previous == 100)
	    	{
	    		return 0;
	    	}
	    	
	    	return 0;
	    }
	    

}
