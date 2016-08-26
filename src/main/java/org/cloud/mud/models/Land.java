package org.cloud.mud.models;

import java.util.ArrayList;
import java.util.List;

public class Land {
    private String name;
    private List<NPC> npcs = new ArrayList<NPC>();
    private List<Chest> chests = new ArrayList<Chest>();
    private int level;

    public Land() {

    }

    private Land(LandBuilder builder) {
        this.name = builder.name;
        this.level = builder.level;
        this.npcs.addAll(builder.npcs);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void addNPC(NPC npc) {
        npcs.add(npc);
    }

    public List<NPC> getNpcs() {
        return npcs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class LandBuilder {
        private List<NPC> npcs = new ArrayList<NPC>();
        private String name;
        private int level;

        public LandBuilder buildLand(String name, int level) {
            this.name = name;
            this.level = level;
            return this;
        }

        public LandBuilder buildNPC(String name, int level) {
            npcs.add(new NPC(name, level));
            return this;
        }

        public Land build() {
            return new Land(this);
        }
    }
}
