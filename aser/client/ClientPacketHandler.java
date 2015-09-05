package aser.client;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import aser.core.PacketUtil;
import aser.entity.player.PlayerSP;
import aser.entity.player.PlayerUtil;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import universalelectricity.prefab.tile.TileEntityConductor;
public class ClientPacketHandler implements IPacketHandler
	{
	    Minecraft mc = FMLClientHandler.instance().getClient();

	    public static enum EnumPacketClient
	    {
	        
	        UPDATE_WIRE_BOUNDS(31, Integer.class, Integer.class, Integer.class);

	        private int index;
	        private Class<?>[] decodeAs;
	        private EnumPacketClient(int index, Class<?>... decodeAs)
	        {
	            this.index = index;
	            this.decodeAs = decodeAs;
	        }

	        public int getIndex()
	        {
	            return this.index;
	        }

	        public Class<?>[] getDecodeClasses()
	        {
	            return this.decodeAs;
	        }
	    }

	    @Override
	    public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player p)
	    {
	        if (packet == null)
	        {
	            FMLLog.severe("Packet received as null!");
	            return;
	        }

	        if (packet.data == null)
	        {
	            FMLLog.severe("Packet data received as null! ID " + packet.getPacketId());
	            return;
	        }

	        final DataInputStream data = new DataInputStream(new ByteArrayInputStream(packet.data));

	        final EntityPlayer player = (EntityPlayer) p;

	        PlayerSP playerBaseClient = null;

	        if (player != null)
	        {
	            playerBaseClient = PlayerUtil.getPlayerBaseClientFromPlayer(player);
	        }

	        EnumPacketClient packetType = EnumPacketClient.values()[PacketUtil.readPacketID(data)];

	        Class<?>[] decodeAs = packetType.getDecodeClasses();
	        Object[] packetReadout = PacketUtil.readPacketData(data, decodeAs);

	        switch (packetType)
	        {
	        case UPDATE_WIRE_BOUNDS:
	            TileEntity tile = player.worldObj.getBlockTileEntity((Integer) packetReadout[0], (Integer) packetReadout[1], (Integer) packetReadout[2]);

	            if (tile instanceof TileEntityConductor)
	            {
	                ((TileEntityConductor) tile).adjacentConnections = null;
	                Block.blocksList[player.worldObj.getBlockId(tile.xCoord, tile.yCoord, tile.zCoord)].setBlockBoundsBasedOnState(player.worldObj, tile.xCoord, tile.yCoord, tile.zCoord);
	            }
	            break;
	        }
}
	    }
