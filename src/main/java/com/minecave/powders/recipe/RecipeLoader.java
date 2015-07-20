package com.minecave.powders.recipe;

import com.minecave.powders.item.CustomItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Carter on 7/19/2015.
 */
public class RecipeLoader {

    static private Map<String, CustomItem> items;

    public static void loadRecipes(HashMap<String, CustomItem> itemz){
            items = itemz;
        items = null;
    }

    public static void loadRecipe(String[][] stringMatrix, String name){
        int i = 0;
        Recipe recipe = new Recipe();
        for(String[] strings : stringMatrix){
            for(String string : strings){
                if(string.toUpperCase().equals(string)){
                    recipe.put(RecipeSpot.values()[i], new ItemStack(Material.getMaterial(string)));
                }
            }
        }
    }
}
