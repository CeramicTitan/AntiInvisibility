package mc.shock.antiInvisible;

import java.io.IOException;
import java.util.logging.Logger;

import mc.shock.antiInvisible.Metrics;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TopDog extends JavaPlugin
  implements Listener
{
	
	public Logger log = Logger.getLogger("Minecraft");
	PluginManager pm;
	
  public void onEnable()
  {
	  
	PluginManager pm = getServer().getPluginManager();
	pm.registerEvents(new invisibleListener(), this);
	//removed this since you don't need to reference it.
    this.pm = getServer().getPluginManager();
    this.log = Logger.getLogger("Minecraft");
    
   startMetrics();
    
  }

  
  
  public void onDisable() 
  {
    // No point in having anything here now.
  }
  
  public void startMetrics() {
		try {	
			Metrics metrics = new Metrics(this);	
			metrics.start();
		} catch (IOException e) {
			
		}
	}


}