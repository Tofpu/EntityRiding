package me.tofpu.entityriding.modules;

import me.tofpu.entityriding.EntityRiding;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;

public class DataHandler {
    private String permission;
    private final List<String> blacklist = new ArrayList<>();
    private final List<String> whitelist = new ArrayList<>();
    
    public DataHandler(EntityRiding entityRiding, Options options, String permission, List<String> blacklist, List<String> whitelist) {
        this.permission = permission;
        
        if (options == null){
            entityRiding.getServer().getConsoleSender().sendMessage("options is null");
        }
        
        if (options.isReverse()){
            this.whitelist.addAll(whitelist);
        } else {
            this.blacklist.addAll(blacklist);
        }
    }
    
    public void reload(String permission, List<String> blacklist, List<String> whitelist){
        this.permission = permission;
        blacklist.clear();
        whitelist.clear();
        
        this.blacklist.addAll(blacklist);
        this.whitelist.addAll(whitelist);
    }
    
    public String getPermission() {
        return permission;
    }
    
    public void setPermission(String permission) {
        this.permission = permission;
    }
    
    public List<String> getBlacklist() {
        return blacklist;
    }
    
    public List<String> getWhitelist() {
        return whitelist;
    }
}
