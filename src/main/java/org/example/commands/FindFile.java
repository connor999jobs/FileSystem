package org.example.commands;

import org.example.model.Context;

import java.io.File;
import java.util.List;

public interface FindFile {
    public default File findFile(List<String> args, Context context) {
        File currentDirectory = context.getCurrentDirectory();
        // перевіряємо чи існує аргумент та чи існує файл
        if (args.isEmpty()) {
            return null;
        } else {
            File file = new File(currentDirectory, args.get(0));
            return file.exists() ? file : null;
        }
    }
}
