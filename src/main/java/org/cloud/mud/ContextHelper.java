package org.cloud.mud;

import org.cloud.mud.utils.Logger;

public class ContextHelper {
    private static EnvironmentContext environmentContext;

    public static void init() {
        environmentContext = EnvironmentContext.getContext();
    }

    public static void listMap() {
        Logger.info(environmentContext.roadMap());
    }

    public static void enterMap(int location) {
        if (environmentContext.enterMap(location)) {
            Logger.info("enter into" + environmentContext.landName(location));
        } else {
            Logger.warning("Invalid Map Number");
            listMap();
        }
    }

    public static void listNPC() {
        Logger.info(environmentContext.roadNPC());
    }
}
