package aser.core;

import aser.client.ClientPacketHandler.EnumPacketClient;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class ServerHandler implements IPacketHandler
{
    public static enum EnumPacketServer
    {
		;

		public EnumPacketClient getIndex() {
			// TODO Auto-generated method stub
			return null;
		}
      
     }
    

	@Override
	public void onPacketData(INetworkManager manager,
			Packet250CustomPayload packet, Player player) {
		// TODO Auto-generated method stub
		
	}

}
