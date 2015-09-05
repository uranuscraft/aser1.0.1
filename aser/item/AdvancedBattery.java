package aser.item;


import ic2.api.item.ISpecialElectricItem;
import cofh.api.energy.IEnergyContainerItem;
import aser.core.Base;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import universalelectricity.core.item.IItemElectric;
import universalelectricity.core.item.ItemElectric;
import mekanism.api.energy.IEnergizedItem;
public class AdvancedBattery extends ItemEletric implements IEnergizedItem, IItemElectric, ISpecialElectricItem, IEnergyContainerItem {

	public AdvancedBattery(int id, double maxElectricity, float voltage) {
		super(id, 200000000, 120);
			
		this.setUnlocalizedName("advbattery");
		this.setCreativeTab(CreativeTabs.tabRedstone);
	
	}

	@Override
	public float getMaxElectricityStored(ItemStack theItem) {
		
		return 200000000;
	}
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
	    this.itemIcon = par1IconRegister.registerIcon(Base.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
}
