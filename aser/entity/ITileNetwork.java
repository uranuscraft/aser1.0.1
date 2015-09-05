
package aser.entity;

import java.util.ArrayList;

import com.google.common.io.ByteArrayDataInput;

public interface ITileNetwork {
	/**
	 * Receive and manage a data input.
	 * @param network
	 * @param packet
	 * @param player
	 * @param dataStream
	 */
	public void handlePacketData(ByteArrayDataInput dataStream) throws Exception;
	
	/**
	 * Gets an ArrayList of data this tile entity keeps synchronized with the client.
	 * @param data - list of data
	 * @return ArrayList
	 */
	public ArrayList getNetworkedData(ArrayList data);
}
