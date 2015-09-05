package aser.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import aser.core.Base;
import aser.entity.TaserBolt;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Taser extends ItemEletric{

	public Taser(int par1, double maxElectricity, float voltage) {
		super(par1, 200000000, 120);
		setUnlocalizedName("taser");
		setCreativeTab(CreativeTabs.tabTools);
	
	
	}
	 @SideOnly(Side.CLIENT)
		public void registerIcons(IconRegister par1IconRegister)
		{
		    this.itemIcon = par1IconRegister.registerIcon(Base.modid + ":" + (this.getUnlocalizedName().substring(5)));
		}
	 @Override
	    public boolean hitEntity(ItemStack itemstack, EntityLivingBase hitEntity, EntityLivingBase player)
	    {
		 if(getEnergy(itemstack) >= 2000)
	    	{
	    		
	    		onuse(hitEntity);
	    		hitEntity.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)player), 1);
	    		
	    		
	    			
	    			setEnergy(itemstack, getEnergy(itemstack) - 2000);
	    	}
	    	else {
	    		hitEntity.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)player), 4);
	    	}	
		 
		 
		 return false;
		 
	    }
	 @Override
	 public ItemStack onItemRightClick(ItemStack itemstack,World world,EntityPlayer player) {
		 double check = this.getEnergy(itemstack);
		 if(check >= 2000){
				world.spawnEntityInWorld(new TaserBolt(world, player));
			
			
			this.setEnergy(itemstack, getEnergy(itemstack) - 2000);	
 
			}

		 
		 
		 return itemstack;

	 }
	 
	 
	 
	 public static void onuse(EntityLivingBase hitEntity) {
		 PotionEffect potion = new PotionEffect(2, 300, 255);
 		PotionEffect slowmine = new PotionEffect(4, 300, 255);
 		PotionEffect weakness = new PotionEffect(18, 300, 2);
 		PotionEffect blindness = new PotionEffect(15, 300, 5);
 		PotionEffect spiny = new PotionEffect(9, 60, 3);
 		
 		hitEntity.addPotionEffect(spiny);
 		hitEntity.addPotionEffect(potion);
 		hitEntity.addPotionEffect(slowmine);
 		hitEntity.addPotionEffect(weakness);
 		hitEntity.addPotionEffect(blindness);
	 }
	 
}
