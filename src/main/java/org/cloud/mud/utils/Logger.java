package org.cloud.mud.utils;

import java.util.Arrays;

public class Logger {
    public static void error() {
        System.out.println(Arrays.toString(Thread.currentThread().getStackTrace()));
    }

    public static void warning(String warning) {
        System.out.println(warning);
    }

    public static void info(String info) {
        System.out.println(info);
    }
}
