package org.example.commands.impl;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.example.commands.Command;
import org.example.model.Context;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

public class Open extends Command {
    public Open(Context context) {
        super(context);
    }

    @Override
    @SneakyThrows
    public String execute(List<String> args) {
        File currentFile = context.getCurrentDirectory();
//        Scanner scanner = new Scanner(currentFile, StandardCharsets.UTF_8);
//        String line = "";
//            while (scanner.hasNextLine()){
//                line = scanner.nextLine();
//            }
//
//        return line;
        return FileUtils.readFileToString(currentFile, StandardCharsets.UTF_8);
    }
}
