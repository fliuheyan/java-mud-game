package org.cloud.mud.commands;

public class Talk implements ICommand {
    private String target;

    public Talk(String target) {
        this.target = target;
    }

    @Override
    public void action() {

    }
}
