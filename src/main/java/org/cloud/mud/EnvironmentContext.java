package org.cloud.mud;

import org.cloud.mud.models.Land;
import org.cloud.mud.models.NPC;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class EnvironmentContext {
    private static EnvironmentContext context = null;
    private List<Land> word = new ArrayList<Land>();
    private Console console = System.console();
    private int location = 0;

    private EnvironmentContext() {
        buildWorld();
    }

    public static EnvironmentContext getContext() {
        if (context == null) {
            context = new EnvironmentContext();
        }
        return context;
    }

    public List getWord() {
        return word;
    }

    public void setWord(List word) {
        this.word = word;
    }

    public Console getConsole() {
        return console;
    }

    public void setConsole(Console console) {
        this.console = console;
    }

    public int getLocation() {
        return location;
    }

    public boolean setLocation(int location) {
        if (location < word.size()) {
            this.location = location;
            return true;
        }
        return false;
    }

    public void buildWorld() {
        word.add(new Land.LandBuilder().buildNPC("穆", 100).buildLand("Aries", 100).build());
        word.add(new Land.LandBuilder().buildNPC("阿鲁迪巴", 10).buildLand("Taurus", 20).build());
    }

    public String roadMap() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < word.size(); i++) {
            result.append("[" + i + "]" + landName(i));
            result.append("\n");
        }
        result.append("your current at ["+ location +"]"+ landName(location));
        return result.toString();
    }

    public String roadNPC() {
        StringBuilder result = new StringBuilder();
        List<NPC> npcs = currentLand().getNpcs();
        for (int i = 0; i < npcs.size(); i++) {
            result.append("[" + i + "]" + npcs.get(i).getName());
            result.append("\n");
        }
        return result.toString();
    }

    public boolean enterMap(int location) {
        return setLocation(location);
    }

    public String landName(int location) {
       return word.get(location).getName();
    }

    public Land currentLand() {
        return word.get(location);
    }
}
