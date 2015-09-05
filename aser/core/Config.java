package aser.core;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;

public class Config {
    public static int laserpointerID;
   
    public static int rubyoreID;
    public static int elitebatteryID;
    public static int advbatteryID;
    public static int rubyID;
    public static int mininglaserID;
    public static int oplaserID;
    public static int wireID;
    public static int taserID;
    public static int graserID;
    public static int superinID;
    public static int superdustID;
    public static int transformerID;
    public static int masersawID;
    
    public static void configure(FMLPreInitializationEvent event) {
	Configuration config = new Configuration(event.getSuggestedConfigurationFile());
	
	config.load();
	
		laserpointerID = config.getItem("laserpointerID", 2000).getInt();
		rubyID = config.getItem("rubyID", 2001).getInt();
		mininglaserID = config.getItem("mininglaserID", 2002).getInt();
		advbatteryID = config.getItem("advbatteryID", 2003).getInt();
		elitebatteryID = config.getItem("elitebatteryID", 2004).getInt();
		oplaserID = config.getItem("oplaserID", 2005).getInt();
		graserID = config.getBlock("graserID", 2006).getInt();
		superdustID = config.getBlock("superdustID", 2007).getInt();
		superinID = config.getBlock("superinID", 2008).getInt();
		masersawID = config.getBlock("masersawID", 2009).getInt();
		taserID = config.getBlock("taserID", 2010).getInt();
		
		
		
		rubyoreID = config.getBlock("rubyoreID", 2050).getInt();
		wireID = config.getBlock("wireID", 2051).getInt();
		transformerID = config.getBlock("transformerID", 2052).getInt();
		
	config.save();
	
}
}
