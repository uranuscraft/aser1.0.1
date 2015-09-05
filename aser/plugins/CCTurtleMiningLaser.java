package aser.plugins;

import aser.core.Config;
import aser.entity.Lasermine;
import aser.item.ItemEletric;
import aser.item.ItemLoader;
import aser.item.MineLaser;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import dan200.computer.api.IHostedPeripheral;
import dan200.turtle.api.ITurtleAccess;
import dan200.turtle.api.ITurtleCommandHandler;
import dan200.turtle.api.ITurtleUpgrade;
import dan200.turtle.api.TurtleSide;
import dan200.turtle.api.TurtleUpgradeType;
import dan200.turtle.api.TurtleVerb;

public class CCTurtleMiningLaser implements ITurtleUpgrade {

	@Override
	public int getUpgradeID() {
		// TODO Auto-generated method stub
		return 137;
	}

	@Override
	public String getAdjective() {
		// TODO Auto-generated method stub
		return "Laser";
	}

	@Override
	public TurtleUpgradeType getType() {
		// TODO Auto-generated method stub
		return TurtleUpgradeType.Tool;
	}

	@Override
	public ItemStack getCraftingItem() {
			return ItemLoader.mineLaser.getUnchargedItem();
	}

	@Override
	public boolean isSecret() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IHostedPeripheral createPeripheral(ITurtleAccess turtle,
			TurtleSide side) {
	
		return null;
	}

	@Override
	public boolean useTool(ITurtleAccess turtle, TurtleSide side,
			TurtleVerb verb, int direction) {
		
		
		
		
		
	
		
	
		turtle.deployWithItemStack(ItemLoader.mineLaser.getChargedItem(), direction);
	
		
	
	return true;
	
	
	}

	@Override
	public Icon getIcon(ITurtleAccess turtle, TurtleSide side) {
		
		
		return null;
	}

	
	
	
	
	
	
}
