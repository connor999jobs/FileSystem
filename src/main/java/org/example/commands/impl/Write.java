package org.example.commands.impl;

import lombok.SneakyThrows;
import org.example.commands.Command;
import org.example.model.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
        scanner.useDelimiter("\\n");
        String line;
        try(PrintWriter fw = new PrintWriter(currentFile, StandardCharsets.UTF_8)) {
            while ((line = scanner.nextLine()) != null){
                if (line.trim().equalsIgnoreCase("done")){
                    System.out.println("Exit");
                    System.exit(0);
                }
            }
            assert false;
            fw.write(line);

        }

        return line;
    }
}
