package exnihilo.proxies;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class ServerProxy extends Proxy 
{
	public World getWorld()
	{
		World world = null;
		
		try
		{
			world = MinecraftServer.getServer().worldServers[0];
		}
		catch (Exception ex)
		{
			
		}
		
		return world;
	}
}
