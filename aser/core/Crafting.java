package aser.core;

import basiccomponents.BasicComponents;
import aser.block.BlockLoader;
import aser.item.ItemLoader;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class Crafting {
public static void Craft() {
	
    ItemStack glassStack = new ItemStack(Block.glass);
    ItemStack LvTransformerBaseStack = new ItemStack(BlockLoader.TransformerBase, 1, 2);
    ItemStack MvTransformerBaseStack = new ItemStack(BlockLoader.TransformerBase, 1, 1);
    ItemStack HvTransformerBaseStack = new ItemStack(BlockLoader.TransformerBase, 1, 0);
    
	GameRegistry.addSmelting(BlockLoader.rubyore.blockID, new ItemStack(ItemLoader.ruby), 0.1f);
	GameRegistry.addSmelting(ItemLoader.superdust.itemID, new ItemStack(ItemLoader.superingot), 0.1f);

	
	
	GameRegistry.addRecipe(new ShapedOreRecipe(ItemLoader.elitebattery, true, "xzx", "oyo","xzx"
            ,'x', "plateSteel", 'z', "copperWire", 'y', Item.ghastTear,'o',"ingotSteel"));

	
	GameRegistry.addRecipe(new ShapedOreRecipe(LvTransformerBaseStack, true, "x x", "xyx","zzz"
            ,'x', "plateBronze", 'z', "plateSteel", 'y', "circuitBasic"));
	
	GameRegistry.addRecipe(new ShapedOreRecipe(MvTransformerBaseStack, true, "x x", "xyx","zzz"
            ,'x', "plateBronze", 'z', "plateSteel", 'y', "circuitAdvanced"));
	
	GameRegistry.addRecipe(new ShapedOreRecipe(MvTransformerBaseStack, true, "xy ", "   ","   "
            ,'x', LvTransformerBaseStack, 'y', "circuitAdvanced"));
	
	GameRegistry.addRecipe(new ShapedOreRecipe(MvTransformerBaseStack, true, "x  ", "y  ","   "
            ,'x', LvTransformerBaseStack, 'y', "circuitAdvanced"));
	GameRegistry.addRecipe(new ShapedOreRecipe(MvTransformerBaseStack, true, "x  "," y ","   "
            ,'x', LvTransformerBaseStack, 'y', "circuitAdvanced"));
	
	
	
	
	GameRegistry.addRecipe(new ShapedOreRecipe(ItemLoader.masersaw, true, " xx", "xzx","yx "
            ,'x', "ingotBronze", 'z', "circuitAdvanced", 'y', "advancedBattery"));
	
	
	
	
	
	
	GameRegistry.addRecipe(new ShapedOreRecipe(ItemLoader.taser, true, "zxx", " wy","zxx"
            ,'x', "ingotBronze", 'z', "wireCopper", 'y', "advancedBattery", 'w', "motor"));
	
	
	
	
	
	
	
	GameRegistry.addRecipe(new ShapedOreRecipe(HvTransformerBaseStack, true, "x x", "xyx","zzz"
            ,'x', "plateBronze", 'z', "plateSteel", 'y', "circuitElite"));
	
	GameRegistry.addRecipe(new ShapedOreRecipe(HvTransformerBaseStack, true, "xyz", "   ","   "
            ,'x', LvTransformerBaseStack, 'y', "circuitAdvanced",'z', "circuitElite"));
	
	GameRegistry.addRecipe(new ShapedOreRecipe(HvTransformerBaseStack, true, "xz ", "y  ","   "
            ,'x', LvTransformerBaseStack, 'y', "circuitAdvanced",'z', "circuitElite"));
	GameRegistry.addRecipe(new ShapedOreRecipe(HvTransformerBaseStack, true, "xz ", " y ","   "
            ,'x', LvTransformerBaseStack, 'y', "circuitAdvanced",'z', "circuitElite"));
	
	
	GameRegistry.addRecipe(new ShapedOreRecipe(HvTransformerBaseStack, true, "xz ", "   ","   "
            ,'x', MvTransformerBaseStack,'z', "circuitElite"));
	
	GameRegistry.addRecipe(new ShapedOreRecipe(HvTransformerBaseStack, true, "xz ", "   ","   "
            ,'x', MvTransformerBaseStack, 'y', "circuitAdvanced",'z', "circuitElite"));
	GameRegistry.addRecipe(new ShapedOreRecipe(HvTransformerBaseStack, true, "x  ", " z ","   "
            ,'x', MvTransformerBaseStack,'z', "circuitElite"));
	
	
	
	
	GameRegistry.addRecipe(new ShapedOreRecipe(ItemLoader.advbattery, true, " x ", "xzx","xzx"
            ,'x', "ingotBronze", 'z', Item.glowstone));

	GameRegistry.addRecipe(new ShapedOreRecipe(ItemLoader.superdust, true, "zxz", "xyx","zxz"
            ,'x', "ingotSilver",'y', Item.eyeOfEnder,'z', Item.ingotGold));
	GameRegistry.addRecipe(new ShapedOreRecipe(ItemLoader.superdust, true, "zxz", "xyx","zxz"
            ,'z', "ingotSilver",'y', Item.eyeOfEnder,'x', Item.ingotGold));
	
	ItemStack wire1 = new ItemStack(BlockLoader.wire,6,0);
	ItemStack wire2 = new ItemStack(BlockLoader.wire,6,1);
	ItemStack wire3 = new ItemStack(BlockLoader.wire,6,2);
	ItemStack wire4 = new ItemStack(BlockLoader.wire,6,3);
	ItemStack wire5 = new ItemStack(BlockLoader.wire,2,4);
	
	GameRegistry.addRecipe(new ShapedOreRecipe(wire1, true, "xyx", "xyx","xyx"
            ,'x', Item.leather,'y', "ingotCopper"));
	
	GameRegistry.addRecipe(new ShapedOreRecipe(wire2, true, "xyx", "xyx","xyx"
            ,'x', Item.leather,'y', "ingotTin"));
	GameRegistry.addRecipe(new ShapedOreRecipe(wire3, true, "xyx", "xyx","xyx"
            ,'x', Item.leather,'y', "ingotSilver"));
	GameRegistry.addRecipe(new ShapedOreRecipe(wire4, true, "xyx", "xyx","xyx"
            ,'x', Item.leather,'y', "ingotAluminum"));
	GameRegistry.addRecipe(new ShapedOreRecipe(wire5, true, "xyx", "xyx","xyx"
            ,'x', Item.leather,'y', "ingotSuperConductor"));
	
	
	
	
	
	
	
	  GameRegistry.addRecipe(new ShapedOreRecipe(ItemLoader.Laserpointer.getUnchargedItem(), true, "xxx", "zyo","xxx"
	            ,'x', Item.ingotIron, 'z', glassStack, 'y', "gemRuby",'o',"battery"));
	
	  GameRegistry.addRecipe(new ShapedOreRecipe(ItemLoader.mineLaser.getUnchargedItem(), true, "xxx", "zyo","xxx"
	            ,'x', "ingotBronze", 'z', glassStack, 'y', "gemRuby",'o',"advancedBattery"));
	  
	  GameRegistry.addRecipe(new ShapedOreRecipe(ItemLoader.oplaser, true, "xxx", "zyo","xxx"
	            ,'x', "ingotSteel", 'z', glassStack, 'y', "gemRuby",'o',"eliteBattery"));
	
}



}
