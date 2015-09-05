package aser.block;

import aser.core.Base;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RubyOre extends Block
{
    public RubyOre(int id, Material material) 
{
        super(id, material);
           
           setHardness(4.0F); // 33% harder than diamond
           setStepSound(Block.soundStoneFootstep);
           setUnlocalizedName("rubyore");
           setCreativeTab(CreativeTabs.tabBlock);
           

}
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon(Base.modid + ":" + (this.getUnlocalizedName().substring(5)));
    }


}
