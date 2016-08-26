package org.cloud.mud.models;

import java.util.ArrayList;

public class Player extends BaseInfo {
    private String name;
    private int level;

    public Player(String name, int level) {
        this.name = name;
        this.level = level;
        build(NPC_ATTR_RATE, level);
    }

    private int currentBoss;
    private int currentTask;
    private int currentTaskStatus;
    private ArrayList<Integer> passedBoss;

    public int getCurrentBoss() {
        return currentBoss;
    }

    public void setCurrentBoss(int currentBoss) {
        this.currentBoss = currentBoss;
    }

    public int getCurrentTask() {
        return currentTask;
    }

    public void setCurrentTask(int currentTask) {
        this.currentTask = currentTask;
    }

    public int getCurrentTaskStatus() {
        return currentTaskStatus;
    }

    public void setCurrentTaskStatus(int currentTaskStatus) {
        this.currentTaskStatus = currentTaskStatus;
    }

    public ArrayList<Integer> getPassedBoss() {
        return passedBoss;
    }

    public void setPassedBoss(ArrayList<Integer> passedBoss) {
        this.passedBoss = passedBoss;
    }

    public void insertPassedBoss(int bossId) {
        this.passedBoss.add(bossId);
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
