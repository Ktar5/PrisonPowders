package com.minecave.powders.recipe;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by Carter on 7/17/2015.
 */
public class Recipe {

    private Map<RecipeSpot, ItemStack> itemList;

    public Recipe(){
        itemList = new HashMap<>();
        for(RecipeSpot spot : RecipeSpot.values()){
            itemList.put(spot, new ItemStack(Material.AIR));
        }
    }

    public void put(RecipeSpot spot, ItemStack stack){
        itemList.replace(spot, stack);
    }

    public ShapedRecipe toShapedRecipe(ItemStack endItem) {
        ShapedRecipe recipe = new ShapedRecipe(endItem);
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

    public boolean compareTo(ItemStack[] given){
        ItemStack[] recipe = this.toItemStackArray();
        for(int i = 0 ; i <  9 ; i++){
            if(!areItemsEqual(recipe[i], given[i])){
                return false;
            }
        }
        return true;
    }

    public boolean areItemsEqual(ItemStack s1, ItemStack s2) {
        return s1.equals(s2) || s1.toString().equals(s2.toString().split(Pattern.quote(", internal"))[0] + "}}");
    }

}
