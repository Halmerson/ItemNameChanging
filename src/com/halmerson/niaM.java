package com.halmerson;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class niaM /*Naming Conventions*/ extends JavaPlugin {
	
	public void onEnable() {
		
	}
	
	public void onDisable() {
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("cn")) { // Here is an error
			Player player = (Player) sender; //Unchecked casting
			if(args.length < 1) {
				player.sendMessage(ChatColor.RED + "Please specify a name for your item!");
			}else
			{
			//String name = StringUtils.join(args, " ", 0, args.length); //Thank me later. Because you can only name it with one word, but not with this
			ItemStack iph = player.getItemInHand();
			ItemMeta iphmeta = iph.getItemMeta();
			List<String> lore = new ArrayList<String>(); //Here is an error in both String. What does it say? // Cannot resolve symbol, 'String'
			iphmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', args[0]));
			lore.add(ChatColor.BLUE + "Customly named item"); // Here is an error at "add"
			iphmeta.setLore(lore);
			iph.setItemMeta(iphmeta);
			player.sendMessage(ChatColor.GREEN + "You've set the name if this item, to " + args[0]);
			}

		}
		return true;
	}
	
}
