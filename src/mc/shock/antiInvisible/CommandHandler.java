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
		if (cmd.getName().equalsIgnoreCase("nopot"))
		{
			if (args.length != 1 && sender.hasPermission("nopot.info"))
			{
				sender.sendMessage(nopot + ChatColor.WHITE + "Commands:");
				sender.sendMessage(line1);
				sender.sendMessage(line2);
			}
			if (args[0].equalsIgnoreCase("reload") && sender.hasPermission("nopot.reload"))
			{
				// reload
				sender.sendMessage(nopot + "config reloaded.");
			}
			
			if (args[0].equalsIgnoreCase("info") && sender.hasPermission("nopot.info"))
			{
				// print config
			}
		}
		return false;
	}
	
	
}
