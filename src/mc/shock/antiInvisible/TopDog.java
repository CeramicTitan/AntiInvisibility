package mc.shock.antiInvisible;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TopDog extends JavaPlugin
  implements Listener
{
	
	private Logger log;
	PluginManager pm;
	FileConfiguration newConfig;
	Boolean invisibility;
	Boolean poison;
	
  public void onEnable()
  {
    getServer().getPluginManager().registerEvents(this, this);
    this.pm = getServer().getPluginManager();
    this.log = Logger.getLogger("Minecraft");
    loadConfig();
    
    loadPotions();
    // Loads config
    
  }

  private void loadConfig() 
  {
  try {
	reloadConfig();
	this.newConfig = getConfig();
	this.newConfig.options().copyDefaults(true);
	
	this.invisibility = Boolean.valueOf(this.newConfig.getBoolean("invisibility", false));
	this.invisibility = Boolean.valueOf(this.newConfig.getBoolean("poison", false));
	saveConfig();
	this.log.info("[AntiInvisible] config loaded");
      }
    catch (Exception e) 
  {
	  this.log.log(Level.SEVERE, "[AntiInvisibility] Failed to load AntiInvisibility config", e);
	  e.printStackTrace();
  }
  }
  
  public void loadPotions()
  {
	  try
	  {
		  getCommand("ai").setExecutor(new CommandHandler(this));
		  pm.registerEvents(new invisibleListener(this), this);
		  this.log.info("[AntiInvisible] potion listeners loaded");
	  }
	  catch (Exception e)
	  {
		  this.log.log(Level.SEVERE, "[AntiInvisibility] Failed to load potion listeners.");
	  }
  }

  
  
public void onDisable() 
{
    // No point in having anything here now.
}


}