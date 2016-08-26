package org.cloud.mud.models;

public class NPC extends BaseInfo{
    private String name;
    private int level;
    public NPC(String name,int level) {
        this.name = name;
        this.level = level;
        build(PLAYER_ATTR_RATE,level);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
