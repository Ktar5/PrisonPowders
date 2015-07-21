package com.minecave.powders.item;

import com.minecave.powders.utils.ItemFactory;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by Carter on 7/19/2015.
 */
public class ItemCoordinator {

    private Map<ShapedRecipe, CustomItem> itemMap;

    public ItemCoordinator(){
        itemMap = new HashMap<>();
        loadItems();
    }

    public CustomItem getByName(String name){
        name = name.toLowerCase();
        for(CustomItem item : itemMap.values()){
            if(item.getName().equals(name)){
                return item;
            }
        }
        return null;
    }

    public CustomItem getByRecipe(ShapedRecipe recipe){
        return itemMap.get(recipe);
    }

    private void loadItems(){
        Map<String, CustomItem> preItemMap = new HashMap<>();

    }

    private CustomItem loadItem(ConfigurationSection section) {
        ItemFactory factory =
                new ItemFactory(Material.AIR)
                        .setMaterial(Material.valueOf(section.getString("material").toUpperCase()))
                        .setDisplayName(section.getString("display-name", null))
                        .setAmount(section.getInt("amount", 1))
                        .setDurability(section.getInt("meat-value", 0))
                        .setLore(section.getStringList("lore"))
                        .addGlow(section.getBoolean("glows", false));

        if (section.getStringList("effects") != null) {
            List<PotionEffect> effectList = new ArrayList<>();
            List<String> effects = section.getStringList("effects");
            for (String string : effects) {
                String[] effectParts = string.split(Pattern.quote(","));
                effectList.add(new PotionEffect(
                        PotionEffectType.getByName(effectParts[0]),
                        Integer.valueOf(effectParts[1]),
                        Integer.valueOf(effectParts[2])));
            }
            return new CustomItem(section.getName(), effectList, factory.getItemStack());
        }
        return new CustomItem(section.getName(), factory.getItemStack());
    }

}
