package org.cloud.mud;

import org.cloud.mud.commands.CommandFactory;
import org.cloud.mud.commands.ICommand;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        boolean finished = false;
        Scanner scanner = new Scanner(System.in);
        while (!finished && scanner.hasNext()) {
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                finished = true;
                continue;
            }
            ICommand command = CommandFactory.make(input);
            command.action();
        }
        System.exit(0);
    }
}
