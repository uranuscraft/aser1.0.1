package aser.block;

import java.util.List;

import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import aser.client.ClientPacketHandler.EnumPacketClient;
import aser.client.ClientProxy;
import aser.core.Base;
import aser.core.PacketUtil;
import aser.entity.TileWire;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import universalelectricity.core.vector.Vector3;
import universalelectricity.prefab.block.BlockConductor;
import universalelectricity.prefab.tile.TileEntityConductor;

public class Wire extends BlockConductor{
	 public static final String[] names = { "copperWire", "tinWire","silverWire","hvWire","superWire" };
	    private static Icon[] blockIcons;
	public Wire(int id, Material material) {
		super(id, material);
		 this.setStepSound(Block.soundClothFootstep);
	        this.setResistance(0.2F);
	        this.setBlockBounds(0.4F, 0.4F, 0.4F, 0.6F, 0.6F, 0.6F);
	        this.minVector = new Vector3(0.4, 0.4, 0.4);
	        this.maxVector = new Vector3(0.6, 0.6, 0.6);
	        Block.setBurnProperties(this.blockID, 30, 60);
	        this.setHardness(0.075F);
	        this.setUnlocalizedName("wire");
	this.setCreativeTab(CreativeTabs.tabRedstone);
	}

	 @Override
	    public void registerIcons(IconRegister par1IconRegister)
	    {
		 Wire.blockIcons = new Icon[Wire.names.length];

	        for (int i = 0; i < Wire.names.length; i++)
	        {
	        	Wire.blockIcons[i] = par1IconRegister.registerIcon(Base.modid + ":" + Wire.names[i]);
	        }
	    }

	    @Override
	    public boolean isOpaqueCube()
	    {
	        return false;
	    }

	    @Override
	    public boolean renderAsNormalBlock()
	    {
	        return false;
	    }

	    @Override
	    @SideOnly(Side.CLIENT)
	    public Icon getIcon(int side, int meta)
	    {
	        switch (meta)
	        {
	        case 0:
	            return Wire.blockIcons[0];
	        case 1:
	            return Wire.blockIcons[1];
	        case 2: 
	        	return Wire.blockIcons[2];
	        case 3:
	        	return Wire.blockIcons[3];
	        case 4:
	        	return Wire.blockIcons[4];
	        default:
	            return Wire.blockIcons[0];
	        }
	    }

	    @Override
	    public void onNeighborBlockChange(World world, int x, int y, int z, int blockID)
	    {
	        super.onNeighborBlockChange(world, x, y, z, blockID);

	        TileEntity tile = world.getBlockTileEntity(x, y, z);

	        if (tile instanceof TileEntityConductor)
	        {
	            ((TileEntityConductor) tile).adjacentConnections = null;
	            Block.blocksList[world.getBlockId(tile.xCoord, tile.yCoord, tile.zCoord)].setBlockBoundsBasedOnState(world, tile.xCoord, tile.yCoord, tile.zCoord);
	            PacketDispatcher.sendPacketToAllAround(x, y, z, 10,world.provider.dimensionId, PacketUtil.createPacket(Base.CHANNEL, EnumPacketClient.UPDATE_WIRE_BOUNDS, new Object[] { x, y, z }));
	        }
	    }

	    @Override
	    public int getRenderType()
	    {
	        return ClientProxy.Wire_RENDER_ID;
	    }

	    @Override
	    public int damageDropped(int metadata)
	    {
	        return metadata;
	    }

	    @Override
	    public TileEntity createTileEntity(World world, int metadata)
	    {
	        switch (metadata)
	        {
	        case 0:
	            return new TileWire();
	        case 1:
	            return new TileWire(0.04F, 60.0F);
	        case 2:
	        	return new TileWire(0.02F, 600.0F);
	        case 3:
	        	return new TileWire(0.10F, 20.0F);
	        case 4:
	        	return new TileWire(0.0F, Float.POSITIVE_INFINITY);
	        default:
	            return null;
	        }
	    }

	    @Override
	    public TileEntity createNewTileEntity(World var1)
	    {
	        return null;
	    }

	    @SuppressWarnings({ "unchecked", "rawtypes" })
	    @Override
	    @SideOnly(Side.CLIENT)
	    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
	    {
	        par3List.add(new ItemStack(par1, 1, 0));
	        par3List.add(new ItemStack(par1, 1, 1));
	        par3List.add(new ItemStack(par1, 1, 2));
	        par3List.add(new ItemStack(par1, 1, 3));
	        par3List.add(new ItemStack(par1, 1, 4));
	    }

}
