package org.cloud.mud.triggers;

import org.cloud.mud.conditions.ICondition;
import org.cloud.mud.playbook.Dialog;

import java.util.List;

public class DialogTrigger extends AbstractTrigger {
    private Dialog dialog;

    public DialogTrigger(List conditions, Dialog dialog) {
        super(conditions);
        this.dialog = dialog;
    }

    @Override
    public boolean ifCompleteThenTrigger(String inputAnswer) {
        if (isAllCompleted(inputAnswer)) {
            dialog.preform();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isAllCompleted(String inputAnswer) {
        for (ICondition condition : conditions) {
            if (!condition.isCompleted(inputAnswer)) {
                return false;
            }
        }
        return true;
    }
}
