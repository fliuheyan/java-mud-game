package org.cloud.mud.commands;

import org.cloud.mud.utils.Logger;

public class NoAction implements ICommand{
    @Override
    public void action() {
        Logger.warning("invalid action, type help get more info.");
    }
}
