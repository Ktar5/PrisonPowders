package com.minecave.powders.recipe;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import java.util.HashMap;
import java.util.Map;

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
            System.out.println(i);
            if(!areItemsEqual(recipe[i], given[i])){
                return false;
            }
        }
        return true;
    }

    public boolean areItemsEqual(ItemStack s1, ItemStack s2) {
        if (s1.getType().equals(s2.getType())) {
            if (s1.getDurability() == s2.getDurability() /*&& s1.getEnchantments().equals(s2.getEnchantments())*/) {
                if (s1.hasItemMeta() && s2.hasItemMeta()) {
                    return s1.getItemMeta().equals(s2.getItemMeta());
                }else if(!s1.hasItemMeta() && !s2.hasItemMeta()){
                    return true;
                }
            }
        }
        return false;
    }

}
