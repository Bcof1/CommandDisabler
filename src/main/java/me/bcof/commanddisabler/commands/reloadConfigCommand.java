package me.bcof.commanddisabler.commands;

import me.bcof.commanddisabler.files.CustomConfig;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class reloadConfigCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            player.sendMessage(ChatColor.GREEN + "Reloaded Config");
            CustomConfig.reloadConfig();
        }else{
            System.out.println("Reloaded Config");
            CustomConfig.reloadConfig();
        }

        return false;
    }
}
