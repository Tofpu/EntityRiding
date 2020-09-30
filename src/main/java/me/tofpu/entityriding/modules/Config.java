package me.tofpu.entityriding.modules;

import me.tofpu.entityriding.EntityRiding;

import java.util.List;

public class Config {
    private final EntityRiding entityRiding;
    private final Options options;
    private DataHandler dataHandler;
    
    public Config(EntityRiding entityRiding) {
        this.entityRiding = entityRiding;
        this.options = new Options(isDisabled(), isReverse());
        init();
    }
    
    public void init(){
        if (getPermission() == null){
            entityRiding.getServer().getConsoleSender().sendMessage("permission is null");
        }
        if (getWhitelist() == null){
            entityRiding.getServer().getConsoleSender().sendMessage("whitelist is null");
        }
        if (getBlacklist() == null){
            entityRiding.getServer().getConsoleSender().sendMessage("blacklist is null");
        }
        this.dataHandler = new DataHandler(entityRiding, options, getPermission(), getBlacklist(), getWhitelist());
    }
    
    public void reload(){
        entityRiding.reloadConfig();
        this.options.reload(isDisabled(), isReverse());
        this.dataHandler.reload(getPermission(), getBlacklist(), getWhitelist());
    }
    
    public boolean isDisabled(){
        return entityRiding.getConfig().getBoolean("settings.disable");
    }
    
    public boolean isReverse(){
        return entityRiding.getConfig().getBoolean("settings.reverse");
    }
    
    public String getPermission(){
        return entityRiding.getConfig().getString("settings.permission");
    }
    
    public List<String> getBlacklist(){
        return entityRiding.getConfig().getStringList("mobs.blacklist");
    }
    
    public List<String> getWhitelist(){
        return entityRiding.getConfig().getStringList("mobs.whitelist");
    }
    
    public Options getOptions() {
        return options;
    }
    
    public DataHandler getDataHandler() {
        return dataHandler;
    }
}
