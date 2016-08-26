package org.cloud.mud.triggers;

import java.util.List;

public class BattleTrigger extends AbstractTrigger{

    public BattleTrigger(List conditions, String answer) {
        super(conditions);
    }

    @Override
    public boolean ifCompleteThenTrigger(String inputAnswer) {
        return false;
    }

    @Override
    public boolean isAllCompleted(String inputAnswer) {
        return false;
    }
}
