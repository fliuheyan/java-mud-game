package org.cloud.mud.commands;

import org.cloud.mud.ContextHelper;

public class List implements ICommand{
    private String target;
    public List(String target) {
        this.target = target;
    }

    @Override
    public void action() {
        if(target.equals("npc")) {
            ContextHelper.listNPC();
        }
    }

    public String getTarget() {
        return target;
    }
}
