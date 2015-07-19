package com.minecave.powders.item;

import com.minecave.powders.recipe.Recipe;
import com.minecave.powders.utils.ItemFactory;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import java.util.List;

/**
 * Created by Carter on 7/15/2015.
 */
public class CustomItem {

    private String name;
    private List<PotionEffect> startingEffects;
    private Recipe recipe;
    private String definingLine; // The defining line of the lore

    public CustomItem(String name, List<PotionEffect> startingEffects, ItemFactory factory, String definingLine) {
        this.name = name;
        this.startingEffects = startingEffects;
        this.definingLine = definingLine;
    }

    public void loadRecipe(Recipe recipe){
        this.recipe = recipe;
    }

    public void use(Player player){
        player.addPotionEffects(startingEffects);
    }

}
