package aser.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import aser.core.Base;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SuperConductorDust extends Item {

	public SuperConductorDust(int par1) {
		super(par1);
		 maxStackSize = 64;
		    setCreativeTab(CreativeTabs.tabMisc);
		    setUnlocalizedName("superdust");
			}
			@SideOnly(Side.CLIENT)
			public void registerIcons(IconRegister par1IconRegister)
			{
			    this.itemIcon = par1IconRegister.registerIcon(Base.modid + ":" + (this.getUnlocalizedName().substring(5)));
			}
}
