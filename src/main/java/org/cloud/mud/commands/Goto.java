package org.cloud.mud.commands;

import org.cloud.mud.ContextHelper;

public class Goto implements ICommand{
    private String target;

    public Goto(String target) {
        this.target = target;
    }

    @Override
    public void action() {
        ContextHelper.enterMap(Integer.parseInt(target));
    }

    public String getTarget() {
        return target;
    }
}
