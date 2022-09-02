package org.example.commands.impl;

import lombok.SneakyThrows;
import org.example.commands.Command;
import org.example.model.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Rm extends Command {
    public Rm(Context context) {
        super(context);
    }

    @Override
    @SneakyThrows
    public String execute(List<String> args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Specify the path,  where you want to delete file.");
        File file = new File(scanner.nextLine());
        String path = file.getPath();
        Files.deleteIfExists(Path.of(path));
        return "File was delete from " + path;
    }
}