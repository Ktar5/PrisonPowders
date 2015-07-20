package com.minecave.powders.listeners;

import com.minecave.powders.Powders;
import com.minecave.powders.item.CustomItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ShapedRecipe;

/**
 * Created by Carter on 7/16/2015.
 */
public class ItemCraftListener implements Listener {

    @EventHandler
    public void onItemCraft(PrepareItemCraftEvent event){
        CraftingInventory inv = event.getInventory();
        if(event.getRecipe() instanceof ShapedRecipe){
            ShapedRecipe recipe = (ShapedRecipe) event.getRecipe();
            CustomItem item = Powders.getInstance().getItemCoordinator().getByRecipe(recipe);
            if(item != null){
                if(!item.getRecipe().compareTo(inv.getMatrix())){
                    inv.setResult(null);
                }
            }
        }

    }
}
