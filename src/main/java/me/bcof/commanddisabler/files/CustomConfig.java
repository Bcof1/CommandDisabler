package me.bcof.commanddisabler.files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CustomConfig {

    private static File file;
    private static FileConfiguration customFile;

    public static void setupConfig(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("CommandDisabler").getDataFolder(), "commands.yml");

        if(!file.exists()){
            try{
                file.createNewFile();
            }catch(IOException e){
                // catches
            }
        }

        customFile = YamlConfiguration.loadConfiguration(file);

    }

    public static FileConfiguration getConfig(){
        return customFile;
    }

    public static void saveConfig(){
        try{
            customFile.save(file);
        }catch(IOException e){
            System.out.println("Can not save file");
        }
    }

    public static void reloadConfig(){
        customFile = YamlConfiguration.loadConfiguration(file);
    }







}
