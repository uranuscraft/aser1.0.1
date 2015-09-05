package aser.block;

import aser.core.Base;
import aser.core.Config;
import aser.item.ItemLoader;
import aser.item.ItemTransformer;
import aser.item.ItemWire;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

public class BlockLoader {
public static Block rubyore;
public static Block wire;
public static Block TransformerBase;

public static void blockidloader(int par1, int par2, int par3) {
	
	rubyore = new RubyOre(par1, Material.rock);
	wire = new Wire(par2, Material.cloth);
	TransformerBase = new Transformers(par3, Material.iron);

}

public static void blockloader() {
	
		blockidloader(Config.rubyoreID, Config.wireID, Config.transformerID);
		blockadder();
	
	
	
	
	
}



public static void blockadder() {
	LanguageRegistry.addName(rubyore,"Ruby Ore");
    MinecraftForge.setBlockHarvestLevel(rubyore, "pickaxe", 2);
    GameRegistry.registerBlock(rubyore, "rubyore");
    
    GameRegistry.registerBlock(wire, ItemWire.class, BlockLoader.wire.getUnlocalizedName(), Base.modid);
    GameRegistry.registerBlock(TransformerBase, ItemTransformer.class, BlockLoader.TransformerBase.getUnlocalizedName(), Base.modid);
    
    LanguageRegistry.addName(new ItemStack(TransformerBase,1,0),"HV Transformer");
    LanguageRegistry.addName(new ItemStack(TransformerBase,1,1),"MV Transformer");
    LanguageRegistry.addName(new ItemStack(TransformerBase,1,2),"LV Transformer");
    MinecraftForge.setBlockHarvestLevel(TransformerBase, "pickaxe", 1);
    
    LanguageRegistry.addName(new ItemStack(wire,1,0),"Copper Wire");
    LanguageRegistry.addName(new ItemStack(wire,1,1),"Tin Wire");
    LanguageRegistry.addName(new ItemStack(wire,1,2),"Silver Wire");
    LanguageRegistry.addName(new ItemStack(wire,1,3),"HV Wire");
    LanguageRegistry.addName(new ItemStack(wire,1,4),"Super conductor");
oreDic();
}

public static void oreDic() {
	OreDictionary.registerOre("copperWire", new ItemStack(BlockLoader.wire,1,0));
	OreDictionary.registerOre("tinWire", new ItemStack(BlockLoader.wire,1,1));
	OreDictionary.registerOre("silverWire", new ItemStack(BlockLoader.wire,1,2));
	OreDictionary.registerOre("hvWire", new ItemStack(BlockLoader.wire,1,3));
	OreDictionary.registerOre("superconductorWire", new ItemStack(BlockLoader.wire,1,4));
	
	
	OreDictionary.registerOre("wireCopper", new ItemStack(BlockLoader.wire,1,0));
	OreDictionary.registerOre("wireTin", new ItemStack(BlockLoader.wire,1,1));
	OreDictionary.registerOre("wiresilver", new ItemStack(BlockLoader.wire,1,2));
	OreDictionary.registerOre("wireHv", new ItemStack(BlockLoader.wire,1,3));
	OreDictionary.registerOre("wireSuperconductor", new ItemStack(BlockLoader.wire,1,4));
}
}
