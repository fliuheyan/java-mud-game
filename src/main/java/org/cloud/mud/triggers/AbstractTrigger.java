package org.cloud.mud.triggers;

import org.cloud.mud.conditions.ICondition;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTrigger {
    protected List<ICondition> conditions = new ArrayList<>();

    public AbstractTrigger(List conditions) {
        this.conditions = conditions;
    }

    public abstract boolean ifCompleteThenTrigger(String inputAnswer);

    public abstract boolean isAllCompleted(String inputAnswer);
}
