package aser.item;

import aser.core.Base;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Ruby extends Item {
	public Ruby(int id) {
        super(id);
    maxStackSize = 64;
    setCreativeTab(CreativeTabs.tabMisc);
    setUnlocalizedName("ruby");
	}
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
	    this.itemIcon = par1IconRegister.registerIcon(Base.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}	
}
