package me.tofpu.entityriding;

import me.tofpu.entityriding.commands.commands.Reload;
import me.tofpu.entityriding.commands.commands.module.CommandManager;
import me.tofpu.entityriding.listeners.PlayerInteractAtEntityListener;
import me.tofpu.entityriding.modules.Config;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class EntityRiding extends JavaPlugin {
    private Config staticConfig;
    
    @Override
    public void onEnable() {
        // Plugin startup logic
        this.saveDefaultConfig();
        this.staticConfig = new Config(this);
    
        int pluginId = 9001;
        new Metrics(this, pluginId);
    
        CommandManager manager = new CommandManager(this);
        PluginCommand pluginCommand = getCommand("entityriding");
        pluginCommand.setExecutor(manager);
        pluginCommand.setTabCompleter(manager);
    
        new Reload(this).register();
    
        Bukkit.getPluginManager().registerEvents(new PlayerInteractAtEntityListener(this), this);
    }
    
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    
    public Config getStaticConfig() {
        return staticConfig;
    }
}
