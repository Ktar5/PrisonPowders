package com.minecave.powders.item;

import com.minecave.powders.recipe.Recipe;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import java.util.List;

/**
 * Created by Carter on 7/15/2015.
 */
public class CustomItem {

    @Getter
    private String name; //The reference to the item for use in Recipes
    private List<PotionEffect> startingEffects; //The effects to be applied when the player uses the item
    @Getter
    private Recipe recipe; //Contains the recipe
    @Getter
    private ItemStack endItem;

    public CustomItem(String name, List<PotionEffect> startingEffects, ItemStack stack) {
        this.name = name;
        this.endItem = stack;
        this.startingEffects = startingEffects;
    }

    public CustomItem(String name, ItemStack stack) {
        this.name = name;
        this.endItem = stack;
        this.startingEffects = null;
    }

    public void loadRecipe(Recipe recipe){
        this.recipe = recipe;
    }

    public boolean hasEffects(){
        return startingEffects == null;
    }

    public void use(Player player){
        player.addPotionEffects(startingEffects);
    }
}
