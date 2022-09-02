package org.example.commands.impl;

import lombok.SneakyThrows;
import org.example.commands.Command;
import org.example.model.Context;
import org.netbeans.lib.cvsclient.file.FileUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.util.List;
import java.util.Scanner;

public class Write extends Command {
    public Write(Context context) {
        super(context);
    }

    @Override
    @SneakyThrows
    public String execute(List<String> args) {
        File currentFile = context.getCurrentDirectory();
        Scanner scanner = new Scanner(System.in);
        String line;

        FileWriter fileWriter = new FileWriter(currentFile,true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        line = scanner.nextLine();
        printWriter.println(line);
        printWriter.close();
        return "Write " + line + " to the " + currentFile.getAbsolutePath();
    }


}
