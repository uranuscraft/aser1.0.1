package aser.core;

import java.util.HashMap;
import java.util.Map;

import calclavia.lib.UniversalRecipes;
import basiccomponents.api.BasicRegistry;
import aser.block.BlockLoader;
import aser.block.Wire;
import aser.entity.Lasermine;
import aser.entity.OpLaser;
import aser.entity.TileWire;
import aser.entity.player.PlayerMP;
import aser.entity.player.PlayerSP;
import aser.generator.OreGenerator;
import aser.generator.TradingHandler;
import aser.generator.Village;
import aser.generator.VillageHandler;
import aser.item.ItemLoader;
import aser.item.LaserPointer;
import aser.plugins.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import dan200.turtle.api.ITurtleAccess;
import dan200.turtle.api.ITurtleUpgrade;
import dan200.turtle.api.TurtleAPI;

@Mod(modid= Base.modid, name="Aser Mod", version="0.0.0")
@NetworkMod(channels = { Base.CHANNEL },clientSideRequired=true, serverSideRequired = false, packetHandler = AserPacketManager.class )
public class Base {
	   public static Map<String, PlayerSP> playersClient = new HashMap<String, PlayerSP>();
	    public static Map<String, PlayerMP> playersServer = new HashMap<String, PlayerMP>();
	    
	public Base() {
		
		PluginController.getController().registerBuiltins();
	}
	
	// The instance of your mod that Forge uses.
    @Instance(value = "uranuscraft_aser")
    public static Base instance;
    public static final String modid = "uranuscraft_aser";
    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide="aser.client.ClientProxy", serverSide="aser.core.CommonProxy")
    public static CommonProxy proxy;
    public static final String CHANNEL = "Aser";
    OreGenerator eventmanager = new OreGenerator();
    
    @EventHandler
    
    public void preInit(FMLPreInitializationEvent event) {
    	Config.configure(event);
        
    	
    	
    	
    	 PluginController.getController().preInit();
    }
    
    @EventHandler 
    public void load(FMLInitializationEvent event) {
    	UniversalRecipes.init();
    	BasicRegistry.requestAll();
    	BlockLoader.blockloader();
    	ItemLoader.itemloader();
    	Crafting.Craft();
    	GameRegistry.registerWorldGenerator(eventmanager);
    	proxy.registerRenderers();
    	 PluginController.getController().init();
    	 GameRegistry.registerTileEntity(TileWire.class, "Wires");  
    	
    	 
    	 
    	 EntityRegistry.registerModEntity(Lasermine.class, "Lasermine", 90, this.instance, 120, 3, true );
    	 
    	 
    	 
    	 
    	 ITurtleUpgrade mininglaserturtle = new CCTurtleMiningLaser();
    	 
    	 TurtleAPI.registerUpgrade(mininglaserturtle);
    	 
    	 
  	   
    
    	
  	   
  	   
  	  TradingHandler newTradeHandler = new TradingHandler();
  	   VillagerRegistry.instance().registerVillageTradeHandler(7194, newTradeHandler);
  	   VillagerRegistry.instance().getRegisteredVillagers(); 
  	   VillagerRegistry.instance().registerVillageCreationHandler(new VillageHandler());
     
     
  	   MapGenStructureIO.func_143031_a(Village.class, "santa:villager");
     
    	
    	 
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	
    	
    	
    	PluginController.getController().postInit();
    	
    }




}
