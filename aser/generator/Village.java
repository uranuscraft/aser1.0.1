package aser.generator;

import java.util.List;
import java.util.Random;

import aser.item.ItemEletric;
import aser.item.ItemLoader;
import net.minecraft.block.Block;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentVillage;
import net.minecraft.world.gen.structure.ComponentVillageStartPiece;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraftforge.common.ChestGenHooks;

public class Village extends ComponentVillage {
	private int averageGroundLevel = -1;
	@Override
	public boolean addComponentParts(World world, Random random,
			StructureBoundingBox structureboundingbox) {
		this.fillWithBlocks(world, structureboundingbox, 0, 2, 0, 4, 2, 0, Block.fence.blockID,Block.fence.blockID, false);
		this.fillWithBlocks(world, structureboundingbox, 4, 1, -1, 7, 1, 1, Block.blockRedstone.blockID,Block.blockRedstone.blockID, false);
		this.fillWithBlocks(world, structureboundingbox, 4, 2, -2, 4, 2, -1, Block.blockRedstone.blockID,Block.blockRedstone.blockID, false);
		this.fillWithBlocks(world, structureboundingbox, 4, 2, 1, 4, 2, 2, Block.blockRedstone.blockID,Block.blockRedstone.blockID, false);
		
		
		this.fillWithBlocks(world, structureboundingbox, 4, 1, -1, 4, 1, 1, Block.blockRedstone.blockID,Block.blockRedstone.blockID, false);
		
		this.fillWithBlocks(world, structureboundingbox, 4, 1, -2, 4, 1, -2, Block.fence.blockID,Block.fence.blockID, false);
		this.fillWithBlocks(world, structureboundingbox, 4, 1, 2, 4, 1, 2, Block.fence.blockID,Block.fence.blockID, false);
		
		
		
		
		this.fillWithBlocks(world, structureboundingbox, 5, 2, -1, 5, 2, 1, Block.stairsSandStone.blockID,Block.stairsSandStone.blockID, false);
		
		this.fillWithBlocks(world, structureboundingbox, 7, 2, -1, 7, 2, 1, Block.stairsSandStone.blockID,Block.stairsSandStone.blockID, false);
		
		this.fillWithBlocks(world, structureboundingbox, 3, 2, 2, 3, 2, 2, Block.fence.blockID,Block.fence.blockID, false);
		this.fillWithBlocks(world, structureboundingbox, 3, 2, -2, 3, 2, -2, Block.fence.blockID,Block.fence.blockID, false);
		this.fillWithBlocks(world, structureboundingbox, 3, 3, 2, 3, 3, 2, Block.fence.blockID,Block.fence.blockID, false);
		this.fillWithBlocks(world, structureboundingbox, 3, 3, -2, 3, 3, -2, Block.fence.blockID,Block.fence.blockID, false);
		
		this.fillWithBlocks(world, structureboundingbox, 4, 3, -2,7, 3, -2, Block.blockRedstone.blockID,Block.blockRedstone.blockID, false);
		
		this.fillWithBlocks(world, structureboundingbox, 4, 3, 2,7, 3, 2, Block.blockRedstone.blockID,Block.blockRedstone.blockID, false);
		
this.fillWithBlocks(world, structureboundingbox, 4, 2, -2,4, 2, -2, Block.blockRedstone.blockID,Block.blockRedstone.blockID, false);
		
		this.fillWithBlocks(world, structureboundingbox, 4, 2, 2,4, 2, 2, Block.blockRedstone.blockID,Block.blockRedstone.blockID, false);
		
		
this.fillWithBlocks(world, structureboundingbox, 4, 2, -2,7, 2, -2, Block.blockRedstone.blockID,Block.blockRedstone.blockID, false);
		
		this.fillWithBlocks(world, structureboundingbox, 4, 2, 2,7, 2, 2, Block.blockRedstone.blockID,Block.blockRedstone.blockID, false);
		
		
		this.fillWithBlocks(world, structureboundingbox, 8, 3, -2,8, 3, 2, Block.blockRedstone.blockID,Block.blockRedstone.blockID, false);
		
		
		
		this.fillWithBlocks(world, structureboundingbox, 8, 4, 0,8, 4, 0, Block.fence.blockID,Block.fence.blockID, false);
		
this.fillWithBlocks(world, structureboundingbox, 4, 4, -2,7, 4, -2, Block.fence.blockID,Block.fence.blockID, false);
		
		this.fillWithBlocks(world, structureboundingbox, 4, 4, 2,7, 4, 2, Block.fence.blockID,Block.fence.blockID ,false);
		
		
		
		this.fillWithBlocks(world, structureboundingbox, 3, 1, 2, 3, 1, 2, Block.fence.blockID,Block.fence.blockID, false);
		this.fillWithBlocks(world, structureboundingbox, 3, 1, -2, 3, 1, -2, Block.fence.blockID,Block.fence.blockID, false);
		
		
		chestpattern.addItem( new WeightedRandomChestContent(new ItemStack(ItemLoader.graser), 0, 1, 5));
		
		this.generateStructurePatternChestContents(world, structureboundingbox, random, 8, 4, 1, chestpattern.getItems(random), chestpattern.getCount(random));
		this.generateStructurePatternChestContents(world, structureboundingbox, random, 8, 4, -1, chestpattern.getItems(random), chestpattern.getCount(random));
        this.spawnVillagers(world, structureboundingbox, 0, -69, 0, 2);
		
		return false;
	}

    public Village()
    {
    }

    public Village(ComponentVillageStartPiece par1ComponentVillageStartPiece, int par2, Random par3Random, StructureBoundingBox par4StructureBoundingBox, int par5)
    {
        super(par1ComponentVillageStartPiece, par2);
        this.coordBaseMode = par5;
        this.boundingBox = par4StructureBoundingBox;
    }

	public static Village buildComponent (ComponentVillageStartPiece villagePiece, List pieces, Random random, int p1, int p2, int p3, int p4, int p5)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p1, p2, p3, 0, 0, 0, 7, 6, 7, p4);
        return canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null ? new Village(villagePiece, p5, random,
                structureboundingbox, p4) : null;
    }






	protected boolean generateStructurePatternChestContents (World world, StructureBoundingBox par2StructureBoundingBox, Random random, int x, int y, int z, WeightedRandomChestContent[] content,
            int par8)
    {
        int posX = this.getXWithOffset(x, z);
        int posY = this.getYWithOffset(y);
        int posZ = this.getZWithOffset(x, z);

        if (par2StructureBoundingBox.isVecInside(posX, posY, posZ) && world.getBlockId(posX, posY, posZ) != Block.chest.blockID)
        {
            world.setBlock(posX, posY, posZ, Block.chest.blockID, 0, 2);
            IInventory inv = new InventoryBasic("chest", true, 32);
          
                WeightedRandomChestContent.generateChestContents(random, content, inv, par8);
            

           
        }
        return true;
    }
	public static ChestGenHooks chestpattern = new ChestGenHooks(null);
	protected int getVillagerType (int par1)
    { 
	
        return 7194;
    }
}
