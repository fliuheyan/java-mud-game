package org.cloud.mud.playbook;

import java.util.ArrayList;
import java.util.List;

public class Playbook {
    private List<Dialog> dialogs = new ArrayList<>();
    private int current=0;

    public Playbook(List dialogs) {
        this.dialogs.addAll(dialogs);
    }

    public void play() {
        dialogs.get(0).preform();
    }

    public List<Dialog> getDialogs() {
        return this.dialogs;
    }

}
