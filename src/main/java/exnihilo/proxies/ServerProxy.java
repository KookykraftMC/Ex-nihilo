package exnihilo.proxies;

import exnihilo.ExNihilo;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class ServerProxy extends Proxy {
  //TODO
  //Apparently the server side proxy isn't properly loading. The getWorld command is returning null all the time. This is bad.
  
	public World getWorld()
	{
		World world = null;
		try
		{
			world = MinecraftServer.getServer().worldServers[0];
		}
		catch (Exception ex) 
		{
		  ExNihilo.log.error("Error while getting server side world reference");
		}
		ExNihilo.log.info("Searching for server side world reference: Success!");
		return world;
	}
}
