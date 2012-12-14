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
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffectType;

public class invisibleListener implements Listener 
{

	final TopDog plugin;
	public invisibleListener(TopDog instance)
	{
		plugin = instance;
	}




	@EventHandler
	  public static PlayerInteractEvent interact(PlayerInteractEvent event)
	  {
	    Action action = event.getAction();
	    Player player = event.getPlayer();
	    if ((action == Action.RIGHT_CLICK_AIR) || (action == Action.RIGHT_CLICK_BLOCK))
	    {
	      ItemStack it = player.getItemInHand();
	      Material mat = it.getType();
	      if (mat == Material.POTION)
	      {
	        Potion potion = Potion.fromItemStack(it);
	        PotionEffectType effecttype = potion.getType().getEffectType();
	        if (effecttype == PotionEffectType.INVISIBILITY)
	        {
	          event.setCancelled(true);
	          player.getInventory().setItemInHand(new ItemStack(Material.GLASS_BOTTLE, 1));
	          player.sendMessage(ChatColor.GREEN + "Potions of invisibility aren't allowed.");
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