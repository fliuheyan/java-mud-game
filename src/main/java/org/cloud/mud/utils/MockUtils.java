package org.cloud.mud.utils;

import org.cloud.mud.conditions.AnswerCondition;
import org.cloud.mud.conditions.ICondition;
import org.cloud.mud.models.Land;
import org.cloud.mud.playbook.Convention;
import org.cloud.mud.playbook.Dialog;
import org.cloud.mud.playbook.Playbook;
import org.cloud.mud.triggers.AbstractTrigger;
import org.cloud.mud.triggers.DialogTrigger;

import java.util.ArrayList;
import java.util.List;

public class MockUtils {
    public static void mockWorld(List world) {
        world.add(new Land.LandBuilder().buildNPC("提里奥佛丁", 100).buildLand("东瘟疫之地", 100).build());
//        world.add(new Land.LandBuilder().buildNPC("阿鲁迪巴", 10).buildLand("Taurus", 20).build());
    }

    public static Playbook mockPlayBook() {
        Convention convention = Convention.get(0);
        Convention convention1 = Convention.get(1);
        Convention convention2 = Convention.get(2);
        Convention convention3 = Convention.get(3);

        Dialog dialog = new Dialog();
        dialog.addConvention(convention);
        dialog.addConvention(convention1);

        Dialog dialog1 = new Dialog();
        dialog1.addConvention(convention2);

        Dialog dialog2 = new Dialog();
        dialog2.addConvention(convention3);

        List<ICondition> conditions1 = new ArrayList<>();
        ICondition condition1 = new AnswerCondition(1);
        conditions1.add(condition1);

        List<ICondition> conditions2 = new ArrayList<>();
        ICondition condition2 = new AnswerCondition(2);
        conditions2.add(condition2);

        AbstractTrigger at = new DialogTrigger(conditions1, dialog1);
        AbstractTrigger at2 = new DialogTrigger(conditions2, dialog2);

        dialog.addTrigger(at);
        dialog.addTrigger(at2);

        List<Dialog> first = new ArrayList();
        first.add(dialog);
        Playbook playbook = new Playbook(first);

        return playbook;
    }

    public static void main(String[] args) {
       Playbook playbook = mockPlayBook();
        playbook.play();
    }

}
