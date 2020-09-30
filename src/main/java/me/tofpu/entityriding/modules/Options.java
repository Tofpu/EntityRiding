package me.tofpu.entityriding.modules;

public class Options {
    private boolean disable;
    private boolean reverse;
    
    public Options(boolean disable, boolean reverse) {
        this.disable = disable;
        this.reverse = reverse;
    }
    
    public void reload(boolean disable, boolean reverse){
        this.reverse = reverse;
        this.disable = disable;
    }
    
    public boolean isReverse() {
        return reverse;
    }
    
    public boolean isDisable() {
        return disable;
    }
}
