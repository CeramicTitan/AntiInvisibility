package mc.shock.antiInvisible;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandHandler extends JavaPlugin implements CommandExecutor
{

	final TopDog plugin;
	public CommandHandler(TopDog instance)
	{
		plugin = instance;
	}
	
	String nopot = ChatColor.AQUA + "[" + ChatColor.GRAY + "NoPot" + ChatColor.AQUA + "] ";
	String line1 = ChatColor.GRAY + "/nopot reload " + ChatColor.WHITE + "- reloads config file.";
	String line2 = ChatColor.GRAY + "/nopot info " + ChatColor.WHITE + "- shows config file.";
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if (cmd.getName().equalsIgnoreCase("nopot")) // /nopot command
		{
			if (args.length != 1 && sender.hasPermission("nopot.info")) // checks for invalid argument number.
			{
				sender.sendMessage(nopot + ChatColor.WHITE + "Commands:");
				sender.sendMessage(line1);
				sender.sendMessage(line2);
			}
			
			if (args.length == 1 && !(sender.hasPermission("nopot.info")) || !(sender.hasPermission("nopot.reload")))
				// checks if user has permission to use info or reload.
			{
				sender.sendMessage(nopot + ChatColor.RED + "You do not have permission for this.");
			}
			
			if (args[0].equalsIgnoreCase("reload") && sender.hasPermission("nopot.reload"))
				// reload the config
			{
				reloadConfig();
				sender.sendMessage(nopot + "config reloaded.");
				// Figure out how to reload the plugin
			}
			
			if (args[0].equalsIgnoreCase("info") && sender.hasPermission("nopot.info")) 
				// return all disabled potions
			{
				sender.sendMessage(nopot + ChatColor.WHITE + "Disabled potions:");
				// print disabled potions
			}
		}
		return false;
	}
	
	
}
