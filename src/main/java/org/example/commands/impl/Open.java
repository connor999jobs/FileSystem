package org.example.commands.impl;

import lombok.SneakyThrows;
import org.example.commands.Command;
import org.example.model.Context;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

public class Open extends Command {
    public Open(Context context) {
        super(context);
    }

    @Override
    public String execute(List<String> args) {
        File currentFile = context.getCurrentDirectory();
        String content = null;
        try {
            try (Scanner scanner = new Scanner(currentFile, StandardCharsets.UTF_8)) {
                content = scanner.useDelimiter("\\A").next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
