package mc.shock.antiInvisible;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffectType;

public class TopDog extends JavaPlugin implements Listener{
	
	public void onEnable()
	{
		getLogger().info("Anti Invisible enabled!");
		getServer().getPluginManager().registerEvents(this, this);
	}
	public void onDisable()
	{
		getLogger().info("Anti Invisible disabled!");
	}
	
	@EventHandler
	public void onPlayerClick(PlayerInteractEvent e)
	{
		Action action = e.getAction();
		Player player = (Player) e.getPlayer();
		if (((action == Action.RIGHT_CLICK_AIR) || (action == Action.RIGHT_CLICK_BLOCK)))
		{
		if (player.getItemInHand().getTypeId() == 373)
		{
			if (player.hasPermission("antiinvisibility.bypass"))
			return;
			else{
		int data = player.getItemInHand().getDurability();
		if ((data == 8193) || (data == 8206) || (data == 16318) || (data == 16382))
		{
			e.setCancelled(true);
			player.getInventory().setItemInHand(new ItemStack (Material.CAKE, 1));
			player.getPlayer().sendMessage(ChatColor.RED + "Potions of invisibility are disabled.");
			player.getPlayer().sendMessage(ChatColor.RED + "But here's some cake :D");
		}
		}
		}
		}
	}	
	
	   @EventHandler
	    public static PlayerInteractEvent interact(PlayerInteractEvent event)
	   {

		   Action action = event.getAction();
		   Player player = (Player) event.getPlayer();
			if (((action == Action.RIGHT_CLICK_AIR) || (action == Action.RIGHT_CLICK_BLOCK)))
			{
				if (player.hasPermission("antiinvisibility.bypass"))
				return event;
				else{
		   ItemStack it = player.getItemInHand();
		   Material mat = it.getType();
		   if (mat == Material.POTION)
		   {
			   Potion potion = Potion.fromItemStack(it);
			   PotionEffectType effecttype = potion.getType().getEffectType();
			   if (effecttype == PotionEffectType.INVISIBILITY) 
			   {
				   event.setCancelled(true);
				   player.getInventory().setItemInHand(new ItemStack (Material.CAKE, 1));
				   player.getPlayer().sendMessage(ChatColor.RED + "Potions of invisibility are disabled");
				   player.getPlayer().sendMessage(ChatColor.RED + "But here's some cake :D");
			   }
		   }
				}
		   }
			return event;
	   }
	   
	   @EventHandler
	   public static BlockDispenseEvent dispense(BlockDispenseEvent event)
	   {
		   ItemStack it = event.getItem();
		   Material mat = it.getType();
		   if (mat == Material.POTION)
		   {
			   Potion potion = Potion.fromItemStack(it);
			   PotionEffectType effecttype = potion.getType().getEffectType();
			   if (effecttype == PotionEffectType.INVISIBILITY) 
			   {
				   event.setCancelled(true);
			   }
		   } 
		return event; 
	   }
}