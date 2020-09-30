package me.tofpu.entityriding.commands.commands;

import me.tofpu.entityriding.EntityRiding;
import me.tofpu.entityriding.Utils;
import me.tofpu.entityriding.commands.commands.module.CommandHandler;
import org.bukkit.command.CommandSender;

public class Reload extends CommandHandler {
    private final EntityRiding entityRiding;
    public Reload(EntityRiding entityRiding){
        this.entityRiding = entityRiding;
        
        super.setName("reload");
        super.setPermission("entityriding.reload");
        super.setDescription("Reloads the config");
    }
    
    @Override
    public void onCommand(CommandSender sender, String[] args) {
        String prefix = "&8[&5Entity&dRiding&8]";
        long start = System.currentTimeMillis();
        entityRiding.getStaticConfig().reload();
        long end = System.currentTimeMillis();
        int time = (int) (end - start);
        sender.sendMessage(Utils.color(String.format("%s &dYou have successfully reloaded the &7config.yml &8(%dms)", prefix, time)));
    }
}
