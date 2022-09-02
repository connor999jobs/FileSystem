package org.example.commands.impl;

import org.example.commands.Command;
import org.example.model.Context;
import java.io.File;
import java.util.List;

public class Cd extends Command {
    public Cd(Context context) {
        super(context);
    }

    @Override
    public String execute(List<String> args) {
        if (args.isEmpty()) {
            return "Incorrect argument. Use `..` to navigate to parent directory or choose right child directory";
        } else {
            String direction = args.get(0);
            File currentFile = context.getCurrentDirectory();

            if (direction.equals("..")) {
                context.setCurrentDirectory(currentFile.getParentFile());
            } else {
                File child = new File(currentFile, direction);
                if (!child.exists()) {
                    return "Child directory " + direction + " does not exist";
                } else {
                    context.setCurrentDirectory(child);
                }
            }
        }
        return "";
    }
}
