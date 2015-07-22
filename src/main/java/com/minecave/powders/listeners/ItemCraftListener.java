package com.minecave.powders.listeners;

import com.minecave.powders.Powders;
import com.minecave.powders.item.CustomItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ShapedRecipe;

/**
 * Created by Carter on 7/16/2015.
 */
public class ItemCraftListener implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void onItemCraft(PrepareItemCraftEvent event){
        if((event.getView().getPlayer()).hasPermission("powders.craft")){
            CraftingInventory inv = event.getInventory();
            if (event.getRecipe() instanceof ShapedRecipe) {
                if(event.getRecipe().getResult().hasItemMeta()){
                    if(event.getRecipe().getResult().getItemMeta().hasLore()){
                        String string = event.getRecipe().getResult().getItemMeta().getLore().get(0);
                        CustomItem item = Powders.getInstance().getItemCoordinator().getByName(string.toLowerCase());
                        if (item != null) {
                            if (!item.getRecipe().compareTo(inv.getMatrix())) {
                                inv.setResult(null);
                            }
                        }
                    }
                }
            }
        }
    }
}
