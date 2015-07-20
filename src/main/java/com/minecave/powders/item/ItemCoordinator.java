package com.minecave.powders.item;

import org.bukkit.inventory.ShapedRecipe;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Carter on 7/19/2015.
 */
public class ItemCoordinator {

    private Map<ShapedRecipe, CustomItem> itemMap;

    public ItemCoordinator(){
        itemMap = new HashMap<>();
    }

    public CustomItem getByName(String name){
        name = name.toLowerCase();
        for(CustomItem item : itemMap.values()){
            if(item.getName().equals(name)){
                return item;
            }
        }
        return null;
    }

    public CustomItem getByRecipe(ShapedRecipe recipe){
        return itemMap.get(recipe);
    }

    private void loadItems(){

    }

    private void loadItem(){

    }

}
