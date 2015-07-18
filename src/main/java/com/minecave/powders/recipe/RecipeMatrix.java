package com.minecave.powders.recipe;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Carter on 7/17/2015.
 */
public class RecipeMatrix {

    private Map<RecipeSpot, ItemStack> itemList;

    public RecipeMatrix(){
        itemList = new HashMap<>();
        for(RecipeSpot spot : RecipeSpot.values()){
            itemList.put(spot, new ItemStack(Material.AIR));
        }
    }

    public void put(RecipeSpot spot, ItemStack stack){
        itemList.replace(spot, stack);
    }

    public ShapedRecipe toShapedRecipe(ItemStack item) {
        ShapedRecipe recipe = new ShapedRecipe(item);
        recipe.shape("ABC", "DEF", "GHI");
        char c = 'A';
        for (int i = 0; i < RecipeSpot.values().length; i++) {
            recipe.setIngredient((char) (c + i), itemList.get(RecipeSpot.values()[i]).getType());
        }
        return recipe;
    }

    public ItemStack[] toItemStackArray(){
        ItemStack[] stack = new ItemStack[9];
        int i = 0;
        for(RecipeSpot spot : RecipeSpot.values()){
            stack[i] = itemList.get(spot);
            i++;
        }
        return stack;
    }

}
