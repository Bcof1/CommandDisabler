package me.bcof.commanddisabler.listeners;

import me.bcof.commanddisabler.files.CustomConfig;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class preCommand implements Listener {

    @EventHandler
    public void onPreCommand(PlayerCommandPreprocessEvent event){
        for (String commands : CustomConfig.getConfig().getStringList("commands")){
            if(event.getMessage().equalsIgnoreCase("/" + commands)){
                event.setCancelled(true);
                event.getPlayer().sendMessage(ChatColor.RED + "This command has been disabled");
            }

        }
    }
}
