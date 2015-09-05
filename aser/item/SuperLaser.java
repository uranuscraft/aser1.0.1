package aser.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import aser.core.Base;
import aser.entity.OpLaser;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class SuperLaser extends ItemEletric {

	public SuperLaser(int par1, double maxElectricity, float voltage) {
		
		super(par1, 1000000000, 240);
	setUnlocalizedName("oplaser");
	setCreativeTab(CreativeTabs.tabTools);
	}
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack,World world,EntityPlayer player) {
		
		
	    double check = this.getEnergy(itemstack);
		if(check >= 200000){
	    
	    
				world.spawnEntityInWorld(new OpLaser(world, player));
		
				this.setEnergy(itemstack, getEnergy(itemstack) - 200000);
		}
	            return itemstack;
	}
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
	    this.itemIcon = par1IconRegister.registerIcon(Base.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
}
