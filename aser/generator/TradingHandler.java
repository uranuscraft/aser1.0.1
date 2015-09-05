package aser.generator;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;


public class TradingHandler implements IVillageTradeHandler {

	  public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipes, Random random) {
	  
		  if (villager.getProfession() ==7194)
	        {
			  
			
			  
			
			 recipes.add(new MerchantRecipe(
				        new ItemStack(Block.dirt, 1),
				        
				        new ItemStack(Item.diamond, 64)));
			
			
			
				
				
			
			    
	        }
	  
	  }
}
