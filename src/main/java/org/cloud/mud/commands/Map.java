package org.cloud.mud.commands;

import org.cloud.mud.ContextHelper;

public class Map implements ICommand{
    @Override
    public void action() {
        ContextHelper.listMap();
    }
}
