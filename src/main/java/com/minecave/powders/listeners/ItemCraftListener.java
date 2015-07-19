package com.minecave.powders.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;

/**
 * Created by Carter on 7/16/2015.
 */
public class ItemCraftListener implements Listener {

    @EventHandler
    public void onItemCraft(PrepareItemCraftEvent event){
        CraftingInventory inv = (CraftingInventory) event.getInventory();

    }
}
