package me.tofpu.entityriding.listeners;

import me.tofpu.entityriding.EntityRiding;
import me.tofpu.entityriding.modules.DataHandler;
import me.tofpu.entityriding.modules.Options;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

public class PlayerInteractAtEntityListener implements Listener {
    private final EntityRiding entityRiding;
    
    public PlayerInteractAtEntityListener(EntityRiding entityRiding) {
        this.entityRiding = entityRiding;
    }
    
    @EventHandler
    public void onPlayerInteractAtEntity(PlayerInteractAtEntityEvent e){
        Player player = e.getPlayer();
        String type = e.getRightClicked().getType().toString().toUpperCase();
    
        boolean hasPermission = true;
    
        Options options = entityRiding.getStaticConfig().getOptions();
        DataHandler dataHandler = entityRiding.getStaticConfig().getDataHandler();
        
        if (options.isDisable()){
            return;
        }
        
        if (dataHandler.getPermission() != null && !dataHandler.getPermission().isEmpty()){
            hasPermission = player.hasPermission(dataHandler.getPermission());
        }
        
        if (!hasPermission){
            return;
        }
        
        if (options.isReverse()){
            for(String value : dataHandler.getBlacklist()){
                if (!value.equalsIgnoreCase(type)){
                    return;
                }
            }
        } else {
            for(String value : dataHandler.getBlacklist()){
                if (value.equalsIgnoreCase(type)){
                    return;
                }
            }
        }
        Entity entity = e.getRightClicked().getPassenger();
        if (entity == null){
            e.getRightClicked().setPassenger(player);
        } else {
            entity.addPassenger(player);
        }
//        e.getRightClicked().addPassenger(player);
    }
}
