package aser.item;

import aser.core.Base;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SuperConductor extends Item {

	public SuperConductor(int par1) {
		super(par1);
		 maxStackSize = 64;
		    setCreativeTab(CreativeTabs.tabMisc);
		    setUnlocalizedName("superingot");
			}
			@SideOnly(Side.CLIENT)
			public void registerIcons(IconRegister par1IconRegister)
			{
			    this.itemIcon = par1IconRegister.registerIcon(Base.modid + ":" + (this.getUnlocalizedName().substring(5)));
			}
}
