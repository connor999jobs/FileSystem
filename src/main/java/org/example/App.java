package org.example;



import org.example.commands.Command;
import org.example.model.Context;
import org.example.utils.ScannerUtils;


import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 *
 *
 */
public class App {

    private static final ScannerUtils scannerUtils = new ScannerUtils();

    public static void main(String[] args) {

        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();

        Context context =new Context(null, new File(s));
        Map<String, Command> commandMap = scannerUtils.getCommands(context);
        context.setCommandMap(commandMap);
        System.out.println("Hi there! Press q or exit to quit. Print help, to get available commands");
        scannerUtils.performCommands(context, commandMap);

    }
}
