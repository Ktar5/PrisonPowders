package com.minecave.powders.recipe;

import com.minecave.powders.Powders;
import com.minecave.powders.item.CustomItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by Carter on 7/19/2015.
 */
public class RecipeLoader {

    static private Map<String, CustomItem> items;

    public static Map<ShapedRecipe, CustomItem> loadRecipes(Map<String, CustomItem> itemz){
        items = itemz;
        Map<ShapedRecipe, CustomItem> itemMap = new HashMap<>();
        FileConfiguration config = Powders.getInstance().getItems().getConfig();
        for(Map.Entry<String, CustomItem> entry : items.entrySet()){
            List<String> list = config.getStringList(entry.getKey() + " .recipe");
            String[][] stringMatrix = new String[3][3];
            for(int i = 0 ; i < list.size() ; i++){
                stringMatrix[i] = list.get(i).split(Pattern.quote(","));
            }
            Recipe recipe = loadRecipe(stringMatrix, entry.getKey());
            entry.getValue().loadRecipe(recipe);
            ShapedRecipe shapedRecipe = recipe.toShapedRecipe(entry.getValue().getEndItem());
            Bukkit.getServer().addRecipe(shapedRecipe);
            itemMap.put(shapedRecipe, entry.getValue());
        }
        items = null;
        return itemMap;
    }

    public static Recipe loadRecipe(String[][] stringMatrix, String name){
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
