package org.example.commands.impl;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.example.commands.Command;
import org.example.model.Context;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class MkFile extends Command {
    public MkFile(Context context) {
        super(context);
    }

    @Override
    @SneakyThrows
    public String execute(List<String> args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Specify the path,  where you want to create a new file.");

        String path = scanner.nextLine();
        File file = new File(path);
        if (!file.exists()){
            file.createNewFile();
        }
        return "New file was create in " + path;
    }

}