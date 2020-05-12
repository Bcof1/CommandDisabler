package me.bcof.commanddisabler.listeners;

import me.bcof.commanddisabler.files.CustomConfig;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerCommandEvent;

public class preConsoleCommand implements Listener {

    @EventHandler
    public void onPreConsoleCommand(ServerCommandEvent event){
        for (String commands : CustomConfig.getConfig().getStringList("commands")){
            if(event.getCommand().equalsIgnoreCase(commands)){
                event.setCommand("");
                System.out.println("This command is disabled");
            }
        }
    }
}
