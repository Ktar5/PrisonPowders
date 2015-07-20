package com.minecave.powders;

import com.minecave.powders.item.ItemCoordinator;
import com.minecave.powders.listeners.ItemCraftListener;
import com.minecave.powders.listeners.RightClickListener;
import com.minecave.powders.utils.CustomConfig;
import lombok.Getter;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Carter on 7/15/2015.
 */
public class Powders extends JavaPlugin implements Listener{

    @Getter
    private static Powders instance = null;
    @Getter
    private CustomConfig items;
    @Getter
    private CustomConfig messages;
    @Getter
    private ItemCoordinator itemCoordinator;

    @Override
    public void onEnable(){
        instance = this;
        //items = new CustomConfig(getDataFolder(), "items.yml");
        //recipes = new CustomConfig(getDataFolder(), "recipes.yml");
        //messages = new CustomConfig(getDataFolder(), "messages.yml");
        getServer().getPluginManager().registerEvents(new ItemCraftListener(),this);
        getServer().getPluginManager().registerEvents(new RightClickListener(),this);
        itemCoordinator = new ItemCoordinator();
    }

    @Override
    public void onDisable(){
        instance = null;
    }


}

