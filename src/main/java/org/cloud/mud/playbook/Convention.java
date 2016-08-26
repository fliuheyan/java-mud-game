package org.cloud.mud.playbook;

import org.apache.commons.configuration2.ex.ConfigurationException;
import org.cloud.mud.triggers.AbstractTrigger;
import org.cloud.mud.utils.ConfigUtils;

import java.util.ArrayList;
import java.util.List;

public class Convention {
    private String content ;
    private List<AbstractTrigger> triggers = new ArrayList<AbstractTrigger>();

    public Convention(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static Convention get(String key) {
        try {
             return new Convention(ConfigUtils.getConversation().getString(key));
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Convention get(int i) {
        return get(String.valueOf(i));
    }
}
