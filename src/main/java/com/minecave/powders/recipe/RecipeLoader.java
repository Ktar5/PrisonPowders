package com.minecave.powders.recipe;

import com.minecave.powders.item.CustomItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Carter on 7/19/2015.
 */
public class RecipeLoader {

    static private Map<String, CustomItem> items;

    public static Map<ShapedRecipe, CustomItem> loadRecipes(HashMap<String, CustomItem> itemz){
        items = itemz;
        Map<ShapedRecipe, CustomItem> itemMap = new HashMap<>();

        items = null;
    }

    public Recipe loadRecipe(String[][] stringMatrix, String name){
        int i = 0;
        Recipe recipe = new Recipe();
        for(String[] strings : stringMatrix){
            for(String string : strings){
                if(string.toUpperCase().equals(string)){
                    recipe.put(RecipeSpot.values()[i++], new ItemStack(Material.getMaterial(string)));
                }else{
                    recipe.put(RecipeSpot.values()[i++], items.get(name).getEndItem());
                }
            }
        }
        return recipe;
    }
}
