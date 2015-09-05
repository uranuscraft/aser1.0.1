package aser.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import aser.core.Base;
import aser.entity.LaserPoint;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;



public class LaserPointer extends ItemEletric {

	public LaserPointer(int par1, double maxElectricity, float voltage) {
		
		super(par1, 1000000, 60);
	setUnlocalizedName("laserpointer");
	setCreativeTab(CreativeTabs.tabTools);
	}
	
	
public static boolean onactive = false;


@Override
public ItemStack onItemRightClick(ItemStack itemstack,World world,EntityPlayer player) {
	
	float f = 1.0F;
    float f1 = player.prevRotationPitch + (player.rotationPitch - player.prevRotationPitch) * f;
    float f2 = player.prevRotationYaw + (player.rotationYaw - player.prevRotationYaw) * f;
    double d = player.prevPosX + (player.posX - player.prevPosX) * (double)f;
    double d1 = (player.prevPosY + (player.posY - player.prevPosY) * (double)f + 1.6200000000000001D) - (double)player.yOffset;
    double d2 = player.prevPosZ + (player.posZ - player.prevPosZ) * (double)f;
    Vec3 vec3d = Vec3.createVectorHelper(d, d1, d2);
    float f3 = MathHelper.cos(-f2 * 0.01745329F - 3.141593F);
    float f4 = MathHelper.sin(-f2 * 0.01745329F - 3.141593F);
    float f5 = -MathHelper.cos(-f1 * 0.01745329F);
    float f6 = MathHelper.sin(-f1 * 0.01745329F);
    float f7 = f4 * f5;
    float f8 = f6;
    float f9 = f3 * f5;
    double d3 = 5000D;
    Vec3 vec3d1 = vec3d.addVector((double)f7 * d3, (double)f8 * d3, (double)f9 * d3);
    MovingObjectPosition movingobjectposition = world.rayTraceBlocks_do_do(vec3d, vec3d1, false, true);
    if (movingobjectposition == null)
    {
     return itemstack;
    }
     
    
     int i = movingobjectposition.blockX;
            int j = movingobjectposition.blockY;
            int k = movingobjectposition.blockZ;
			
	
			x = i;
			y = j;
			z = k;
			 double check = this.getEnergy(itemstack);
			if(check >= 20){
				world.spawnEntityInWorld(new LaserPoint(world, player));
			
			
			this.setEnergy(itemstack, getEnergy(itemstack) - 20);	
    
			}
	
	
	return itemstack;
}

public static int energyuse = 0;

public static void onUse(EntityLivingBase entity){
	PotionEffect potion = new PotionEffect(15, 300);
	
	entity.addPotionEffect(potion);
	
}
public static int x;
public static int y;
public static int z;




@SideOnly(Side.CLIENT)
public void registerIcons(IconRegister par1IconRegister)
{
    this.itemIcon = par1IconRegister.registerIcon(Base.modid + ":" + (this.getUnlocalizedName().substring(5)));
}

}


