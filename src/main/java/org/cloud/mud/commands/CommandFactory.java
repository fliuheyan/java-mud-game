package org.cloud.mud.commands;

import org.cloud.mud.utils.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandFactory {

    public static ICommand make(String input) {
        Logger.info("#############input=>"+input+"<=");
        Matcher matcher1 = Pattern.compile("^(\\w+)\\s(\\w+)$").matcher(input);
        Matcher matcher2 = Pattern.compile("^(\\w+)$").matcher(input);
        if (matcher1.matches()) {
            return dealwithSubCommand(matcher1);
        } else if (matcher2.matches()) {
            return dealwithSingleCommand(matcher2);
        }
        return new NoAction();
    }

    private static ICommand dealwithSubCommand(Matcher matcher) {
        String action = matcher.group(1).toLowerCase();
        String target = matcher.group(2).toLowerCase();
        if (action.startsWith("goto")) {
            return new Goto(target);
        } else if (action.startsWith("talk")) {
            return new Talk(target);
        } else if (action.startsWith("list")) {
            return new List(target);
        }
        return new NoAction();
    }

    private static ICommand dealwithSingleCommand(Matcher matcher) {
        String action = matcher.group(1).toLowerCase();
        if (action.startsWith("help")) {
            return new Help();
        } else if (action.startsWith("status")) {
            return new Status();
        } else if (action.startsWith("quest")) {
            return new Quest();
        } else if (action.startsWith("map")) {
            return new Map();
        }
        return new NoAction();
    }

    public static void main(String[] args) {
        Matcher matcher2 = Pattern.compile("^(\\w+)\\s(\\w+)$").matcher("list npc");
        if (matcher2.matches()) {
            Logger.info(matcher2.group(1));
        } else {
            Logger.info("##############");
        }
    }
}
