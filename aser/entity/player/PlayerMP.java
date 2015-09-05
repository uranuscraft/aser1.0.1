package aser.entity.player;

import aser.item.ItemLoader;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemInWorldManager;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class PlayerMP extends EntityPlayerMP {

	public PlayerMP(MinecraftServer par1MinecraftServer, World par2World,
			String par3Str, ItemInWorldManager par4ItemInWorldManager) {
		super(par1MinecraftServer, par2World, par3Str, par4ItemInWorldManager);
			}
	 @Override
	    public void onUpdate()
	    {
	        super.onUpdate();
	    
	    }


	 @Override
		public void onStruckByLightning(EntityLightningBolt bolt) {
		ItemStack minelaser = new ItemStack(ItemLoader.mineLaser);
		ItemStack oplaser = new ItemStack(ItemLoader.oplaser);
		ItemStack slot = this.getItemInUse();
		
		
			if(slot == minelaser || slot == oplaser) {
				this.setItemInUse(new ItemStack(ItemLoader.graser), slot.getItemDamage());
				
		
			
			
			}
			else {
				this.dealFireDamage(5);
		        
		            this.setFire(8);
		        
			}
		}

}
