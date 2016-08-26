package org.cloud.mud;

import org.cloud.mud.models.Land;
import org.cloud.mud.models.NPC;
import org.cloud.mud.utils.Logger;
import org.cloud.mud.utils.MockUtils;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class EnvironmentContext {
    private static EnvironmentContext context = null;
    private List<Land> world = new ArrayList<Land>();
    private Console console = System.console();
    private int location = 0;
    private List<String> completedTasks = new ArrayList<>();

    private EnvironmentContext() {
        Logger.info("Game map initalizing...");
        MockUtils.mockWorld(world);
        Logger.info("Initaliz completed , please enjoy it.");
    }

    public static EnvironmentContext getContext() {
        if (context == null) {
            context = new EnvironmentContext();
        }
        return context;
    }

    public List getWord() {
        return world;
    }

    public void setWord(List word) {
        this.world = word;
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
        if (location < world.size()) {
            this.location = location;
            return true;
        }
        return false;
    }

    public String roadMap() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < world.size(); i++) {
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
       return world.get(location).getName();
    }

    public Land currentLand() {
        return world.get(location);
    }
}
