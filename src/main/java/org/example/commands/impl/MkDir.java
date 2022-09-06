package org.example.commands.impl;

import lombok.SneakyThrows;
import org.example.commands.Command;
import org.example.model.Context;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class MkDir extends Command {
    public MkDir(Context context) {
        super(context);
    }

    @Override
    @SneakyThrows
    public String execute(List<String> args){
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Specify the path,  where you want to create a new directory.");
//        File file = new File(scanner.nextLine());
//
//        String path = file.getPath();
//        FileUtils.forceMkdir(new File(path));
//        return "New folder was create in " + path;


        //Creating a File object
        if (args.isEmpty()){
            System.out.println("Please, enter argument");
        }
        File curren = context.getCurrentDirectory();
        File file = new File(curren.getPath(), args.get(0));
        //Creating the directory
        boolean bool = file.mkdir();
        if (bool) {
            System.out.println("Directory created successfully");
        } else {
            System.out.println("Sorry couldn’t create specified directory");
        }
        return file.getName();


    }
}
