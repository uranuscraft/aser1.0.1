package aser.item;

import aser.core.Config;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ItemLoader {
	public static ItemEletric mineLaser;
	public static ItemEletric Laserpointer;
	public static Item ruby;
	public static ItemEletric advbattery;
	public static ItemEletric elitebattery;
	public static ItemEletric oplaser;
	public static ItemEletric graser;
	public static Item superdust;
	public static Item superingot;
	public static ItemEletric masersaw;
	public static ItemEletric taser;
	public static void itemidloader(int par1, int par2,int par3, int par4, int par5, int par6, int par7, int par8, int par9, int par10, int par11) {
		Laserpointer = new LaserPointer(par1, 1000000, 60);
   	 ruby = new Ruby(par2);
   	 mineLaser = new MineLaser(par3, 200000000, 120);
   	advbattery = new AdvancedBattery(par4, 200000000, 120);
	elitebattery = new EliteBattery(par5, 1000000000, 240);
	oplaser = new SuperLaser(par6, 1000000000, 240);
	graser = new Graser(par7, 1000000000, 120);
	superdust = new SuperConductorDust(par8);
	superingot = new SuperConductor(par9);
	masersaw = new MaserSaw(par10, 200000000, 120);
	taser = new Taser(par11, 200000000, 120);
	}
	
	public static void itemloader() {
		
			itemidloader(Config.laserpointerID, Config.rubyID, Config.mininglaserID,Config.advbatteryID, Config.elitebatteryID, Config.oplaserID, Config.graserID, Config.superdustID, Config.superinID, Config.masersawID, Config.taserID);
			itemadder();
		
		
		
	}
	public static void oreDic() {
		OreDictionary.registerOre("gemRuby", new ItemStack(ItemLoader.ruby));
		OreDictionary.registerOre("advancedBattery", ItemLoader.advbattery.getUnchargedItem());
		OreDictionary.registerOre("eliteBattery", ItemLoader.elitebattery.getUnchargedItem());
		OreDictionary.registerOre("dustSuperConductor", new ItemStack(ItemLoader.superdust));
		OreDictionary.registerOre("ingotSuperConductor", new ItemStack(ItemLoader.superingot));
	}


public static void itemadder() {
	 LanguageRegistry.addName(Laserpointer , "Laser pointer");
	 LanguageRegistry.addName(ruby , "Ruby");
	 LanguageRegistry.addName(mineLaser, "Mining Laser");
	 LanguageRegistry.addName(advbattery,"Advanced Battery");
	 LanguageRegistry.addName(elitebattery,"Elite Battery");
	 LanguageRegistry.addName(oplaser,"The Laser");
	 LanguageRegistry.addName(graser,"The Graser");
	 LanguageRegistry.addName(superdust,"Super Conductor Dust");
	 LanguageRegistry.addName(superingot,"Super Conductor Ingot");
	 LanguageRegistry.addName(masersaw,"Maser Saw");
	 LanguageRegistry.addName(taser,"Taser");
	 oreDic();
}

}
