package org.example.commands.impl;

import org.apache.commons.io.FileUtils;
import org.example.commands.Command;
import org.example.model.Context;
import java.io.File;
import java.util.List;

public class Ls extends Command {
    public Ls(Context context) {
        super(context);
    }

    @Override
    public String execute(List<String> args) {
        File file = context.getCurrentDirectory();
        File[] allFiles = file.listFiles();
        StringBuilder result = new StringBuilder();
        if (allFiles != null){
            for (File each : allFiles){
                String size = String.valueOf(FileUtils.sizeOfDirectory(file));
                result.append(each.getName()).append(":").append(each.getUsableSpace()).append(" Size: ").append(size).append("\n");
            }
        }
        return result.toString();
    }
}
