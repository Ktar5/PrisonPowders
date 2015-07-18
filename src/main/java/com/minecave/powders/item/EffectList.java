package com.minecave.powders.item;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carter on 7/15/2015.
 */
public class EffectList<PotionEffect> extends ArrayList {

    public EffectList(List<String> strings){
        strings.forEach(this::addFromString);
    }

    public void addFromString(String string){
        String[] strings = string.split(".");
        this.add(PotionEffectType.getByName(strings[0].toUpperCase()).createEffect(Integer.valueOf(strings[1]), Integer.valueOf(strings[2])));
    }

    public void applyToPlayer(Player player){
        player.addPotionEffects(this);
    }


}
