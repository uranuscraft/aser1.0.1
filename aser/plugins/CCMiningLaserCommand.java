package aser.plugins;

import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import aser.entity.Lasermine;
import dan200.turtle.api.ITurtleAccess;
import dan200.turtle.api.ITurtleCommandHandler;

public class CCMiningLaserCommand implements ITurtleCommandHandler {

	@Override
	public boolean handleCommand(ITurtleAccess turtle) {
		World world = turtle.getWorld();
		Vec3 vec = turtle.getPosition();	
		
		double x;
		double y;
		double z;
		x = vec.xCoord;
		y = vec.yCoord;
		z = vec.zCoord;
		
		
		
		
		world.spawnEntityInWorld(new Lasermine(world,(int) x,(int)y,(int)z));
		if(world.getEntityByID(90) != null) {
			return true;
		}
		
		else {
			return false;
		}
		
	}

}
