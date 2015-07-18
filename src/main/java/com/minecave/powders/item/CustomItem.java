package com.minecave.powders.item;

import com.minecave.powders.recipe.Recipe;
import com.minecave.powders.utils.ItemFactory;
import org.bukkit.potion.PotionEffect;

import java.util.List;

/**
 * Created by Carter on 7/15/2015.
 */
public class CustomItem {

    private List<PotionEffect> effects;
    private Recipe recipe;
    private ItemFactory factory;
    private String definingLine; // The defining line of the lore

    public CustomItem(List<PotionEffect> effects, Recipe recipe, ItemFactory factory, String definingLine){
        this.effects = effects;
        this.recipe = recipe;
        this.factory = factory;
        this.definingLine = definingLine;
    }

    public CustomItem(Recipe recipe, ItemFactory factory, String definingLine){
        this(null, recipe, factory, definingLine);
    }



}
