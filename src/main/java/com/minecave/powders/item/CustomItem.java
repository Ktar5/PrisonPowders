package com.minecave.powders.item;

import com.minecave.powders.recipe.Recipe;
import com.minecave.powders.utils.ItemFactory;
import lombok.Getter;
import org.bukkit.entity.Player;
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
    private Recipe recipe; //Contains the recipe as well as the actual item stack that player is given

    public CustomItem(String name, List<PotionEffect> startingEffects, ItemFactory factory) {
        this.name = name;
        this.startingEffects = startingEffects;
    }

    public void loadRecipe(Recipe recipe){
        this.recipe = recipe;
    }

    public void use(Player player){
        player.addPotionEffects(startingEffects);
    }

}
