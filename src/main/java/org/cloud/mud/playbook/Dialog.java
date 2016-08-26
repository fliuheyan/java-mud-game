package org.cloud.mud.playbook;

import org.cloud.mud.triggers.AbstractTrigger;
import org.cloud.mud.utils.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dialog {
    private List<Convention> conventions = new ArrayList<>();
    private List<AbstractTrigger> triggers = new ArrayList<>();

    public void addConvention(Convention convention) {
        conventions.add(convention);
    }

    public List<Convention> getConventions() {
        return this.conventions;
    }

    public void addTrigger(AbstractTrigger trigger) {
        triggers.add(trigger);
    }

    public void preform() {
        for (Convention convention : conventions) {
            Logger.info(convention.getContent());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (!triggers.isEmpty()) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNext()) {
                triggerNext(scanner.nextLine());
            }
        }

    }

    public void triggerNext(String input) {
        for (AbstractTrigger trigger : triggers) {
            trigger.ifCompleteThenTrigger(input);
        }
    }
}
