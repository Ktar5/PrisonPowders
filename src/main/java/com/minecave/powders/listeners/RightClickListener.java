package com.minecave.powders.listeners;

import com.minecave.powders.Powders;
import com.minecave.powders.item.CustomItem;
import com.minecave.powders.utils.Messages;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

/**
 * Created by Carter on 7/19/2015.
 */
public class RightClickListener implements Listener{

    @EventHandler
    public void onPlayerRightClick(PlayerInteractEvent event){
        if(event.getAction().toString().contains("RIGHT")){
            ItemStack stack = event.getItem();
            if(stack != null){
                if(stack.hasItemMeta()){
                    if(stack.getItemMeta().hasLore()){
                        List<String> lore = stack.getItemMeta().getLore();
                        if(lore.size() > 0){
                            String line = ChatColor.stripColor(lore.get(0));
                            CustomItem item = Powders.getInstance().getItemCoordinator().getByName(line);
                            if(item != null){
                                item.use(event.getPlayer());
                                event.getPlayer().sendMessage(Messages.get("message.use." + item.getName().toLowerCase()));
                                if(stack.getAmount() == 1){
                                    event.getItem().setType(Material.AIR);
                                }else{
                                    stack.setAmount(stack.getAmount()-1);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
