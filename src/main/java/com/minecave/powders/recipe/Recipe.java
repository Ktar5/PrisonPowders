package com.minecave.powders.recipe;

import lombok.Getter;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Created by Carter on 7/15/2015.
 */
public class Recipe {

    private RecipeMatrix matrix;
    @Getter
    private ShapedRecipe bukkitShapedRecipe;


    public Recipe(RecipeMatrix matrix, ItemStack stack){
        bukkitShapedRecipe = matrix.toShapedRecipe(stack);
    }

    public boolean compareTo(ItemStack[] given){
        ItemStack[] recipe = matrix.toItemStackArray();
        for(int i = 0 ; i <  9 ; i++){
            if(!areItemsEqual(recipe[i], given[i])){
                return false;
            }
        }
        return true;
    }

    public boolean areItemsEqual(ItemStack s1, ItemStack s2) {
        if (s1.getType().equals(s2.getType()) && s1.getAmount() == s2.getAmount()) {
            if (s1.getDurability() == s2.getDurability() && s1.getEnchantments().equals(s2.getEnchantments())) {
                if (s1.hasItemMeta() && s2.hasItemMeta()) {
                    ItemMeta m1 = s1.getItemMeta();
                    ItemMeta m2 = s2.getItemMeta();
                    if (m1.getLore().equals(m2.getLore()) && m1.getDisplayName().equals(m2.getDisplayName())
                            && m1.getItemFlags().equals(m2.getItemFlags())) {
                        return true;
                    }
                }else return true;
            }
        }
        return false;
    }
}
