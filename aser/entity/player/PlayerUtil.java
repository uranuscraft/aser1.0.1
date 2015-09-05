package aser.entity.player;
import java.util.Iterator;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.FMLLog;
import aser.core.Base;
public class PlayerUtil {
	public static PlayerMP getPlayerBaseServerFromPlayerUsername(String username)
    {
		if (Base.playersServer.isEmpty())
        {
            // new EmptyStackException().printStackTrace();
        }

        final Iterator<Map.Entry<String, PlayerMP>> it = Base.playersServer.entrySet().iterator();

        while (it.hasNext())
        {
            Map.Entry<String, PlayerMP> entry = it.next();

            if (entry.getKey().equals(username))
            {
                return entry.getValue();
            }
        }

        FMLLog.severe("Warning: Could not find player base server instance for player " + username);

        return null;
    }

    public static PlayerMP getPlayerBaseServerFromPlayer(EntityPlayer player)
    {
        if (player == null)
        {
            return null;
        }

        if (Base.playersServer.isEmpty())
        {
            // new EmptyStackException().printStackTrace();
        }

        final Iterator<Map.Entry<String, PlayerMP>> it = Base.playersServer.entrySet().iterator();

        while (it.hasNext())
        {
            final Map.Entry<String,PlayerMP> entry = it.next();

            if (entry.getKey().equals(player.username))
            {
                return entry.getValue();
            }
        }

        FMLLog.severe("Warning: Could not find player base server instance for player " + player.username);

        return null;
    }

    public static PlayerSP getPlayerBaseClientFromPlayer(EntityPlayer player)
    {
        if (player == null)
        {
            return null;
        }

        if (Base.playersClient.isEmpty())
        {
            return null;
        }

        final Iterator<Map.Entry<String, PlayerSP>> it = Base.playersClient.entrySet().iterator();

        while (it.hasNext())
        {
            final Map.Entry<String, PlayerSP> entry = it.next();

            if (entry.getKey() != null && entry.getKey().equals(player.username))
            {
                return entry.getValue();
            }
        }

        FMLLog.severe("Warning: Could not find player base client instance for player " + player.username);

        return null;
    }
}
