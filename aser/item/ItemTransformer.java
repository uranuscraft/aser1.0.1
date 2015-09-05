package aser.item;

import aser.block.BlockLoader;
import aser.block.Transformers;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemTransformer extends ItemBlock {

	public ItemTransformer(int par1) {
		super(par1);
		this.setMaxDamage(0);
        this.setHasSubtypes(true);
	}
	@Override
    public int getMetadata(int damage)
    {
        return damage;
    }

    
    @Override
    public String getUnlocalizedName(ItemStack itemstack)
    {
        int metadata = 0;
        
        if (this.getBlockID() == BlockLoader.TransformerBase.blockID)
        {
            if (itemstack.getItemDamage() >= Transformers.LV_METADATA)
            {
                metadata = 3;
            }
            else if (itemstack.getItemDamage() >= Transformers.MV_METADATA)
            {
                metadata = 2;
            }
            else if (itemstack.getItemDamage() >= Transformers.HV_METADATA)
            {
                metadata = 1;
            }
        }
       
        

        return Block.blocksList[this.getBlockID()].getUnlocalizedName() + "." + metadata;
    }
    @Override
    public String getUnlocalizedName()
    {
        return Block.blocksList[this.getBlockID()].getUnlocalizedName() + ".0";
    }
}
