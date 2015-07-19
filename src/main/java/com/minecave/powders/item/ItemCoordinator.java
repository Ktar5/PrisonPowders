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


}
