package me.bcof.commanddisabler;

import me.bcof.commanddisabler.listeners.preConsoleCommand;
import me.bcof.commanddisabler.commands.reloadConfigCommand;
import me.bcof.commanddisabler.files.CustomConfig;
import me.bcof.commanddisabler.listeners.preCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class CommandDisabler extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("reloadConfig").setExecutor(new reloadConfigCommand());
        getServer().getPluginManager().registerEvents(new preCommand(), this);
        getServer().getPluginManager().registerEvents(new preConsoleCommand(), this);

        getConfig().options().copyDefaults();
        saveConfig();

        CustomConfig.setupConfig();
        CustomConfig.getConfig().options().copyDefaults(true);
        CustomConfig.saveConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
