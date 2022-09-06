package org.example.commands.impl;

import org.apache.commons.io.FilenameUtils;
import org.example.commands.Command;
import org.example.model.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class LsF extends Command {
    public LsF(Context context) {
        super(context);
    }

    @Override
    public String execute(List<String> args) throws FileNotFoundException {
        File file = context.getCurrentDirectory();
        File[] allFiles = file.listFiles();
        if (allFiles != null && allFiles.length == 0) {
            System.out.println("There is not file in this directory " + file.getAbsolutePath());
        }
        return listFile(allFiles, args);
    }

    private String listFile(File[] allFiles, List<String> args) {
        StringBuilder builder = new StringBuilder();
        String format = "| %-9s";
        String sizeFormat = "| %-" + findLongestElement(allFiles, "size") + "s ";
        String nameFormat = "| %-" + findLongestElement(allFiles, "name") + "s ";
        builder.append(buildHeader(args, format, sizeFormat, nameFormat));
        builder.append(buildFooter(allFiles, args, format, sizeFormat, nameFormat));
        return builder.toString();
    }


    /* buildHeader start */
    private String buildHeader(List<String> args, String format, String sizeFormat, String nameFormat) {
        StringBuilder sb = new StringBuilder();
        if (args.isEmpty()) {
            extractedUsual(format, sizeFormat, nameFormat, sb);
        } else {
            extractedWithFlag(args, format, sizeFormat, nameFormat, sb);
        }
        return sb.toString();
    }

    private void extractedWithFlag(List<String> args, String format, String sizeFormat, String nameFormat, StringBuilder sb) {
        char[] flags = args.get(0).replace("-", "").toCharArray();
        sb.append(String.format(nameFormat, "File Name"));
        for (char f : flags) {
            switch (f) {
                case 's' -> sb.append(String.format(sizeFormat, "Size"));
                case 'r' -> sb.append(String.format(format, "Readable"));
                case 'w' -> sb.append(String.format(format, "Writable"));
                case 'e' -> sb.append(String.format(format, "Extension"));
            }
        }
        sb.append("|\n");
    }

    private void extractedUsual(String format, String sizeFormat, String nameFormat, StringBuilder sb) {
        sb.append(String.format(nameFormat, "Name"))
                .append(String.format(sizeFormat, "Size"))
                .append(String.format(format, "Read"))
                .append(String.format(format, "Write"))
                .append(String.format(format, "Extension"))
                .append("|\n");
    }

    /* buildHeader end */



    /* buildFooter start */

    private String buildFooter(File[] allFiles, List<String> args, String format, String sizeFormat, String nameFormat) {
        StringBuilder sb = new StringBuilder();
        if (args.isEmpty()) {
            extractedFooterSame(allFiles, format, sizeFormat, nameFormat, sb);

        } else {
            extractedFooterWithFlag(allFiles, args, format, sizeFormat, nameFormat, sb);
        }
        return sb.toString();
    }

    private void extractedFooterWithFlag(File[] allFiles, List<String> args, String format,
                                         String sizeFormat, String nameFormat, StringBuilder sb) {
        char[] flags = args.get(0).replace("-", "").toCharArray();
        for (File f : allFiles) {
            sb.append(String.format(nameFormat, f.getName()));
            for (char fl : flags) {
                switch (fl) {
                    case 's' -> sb.append(String.format(sizeFormat, f.getTotalSpace()));
                    case 'r' -> sb.append(String.format(format, f.canRead()));
                    case 'w' -> sb.append(String.format(format, f.canWrite()));
                    case 'e' -> sb.append(String.format(format, FilenameUtils.getExtension(f.getName())));
                }
            }
            sb.append("|\n");
        }
    }

    private void extractedFooterSame(File[] allFiles, String format, String sizeFormat, String nameFormat, StringBuilder sb) {
        for (File f : allFiles) {
            sb.append(String.format(nameFormat, f.getName()))
                    .append(String.format(sizeFormat, f.getTotalSpace()))
                    .append(String.format(format, f.canRead()))
                    .append(String.format(format, f.canWrite()))
                    .append(String.format(format, FilenameUtils.getExtension(f.getName())))
                    .append("|\n");
        }
    }
    /* buildFooter end */

    private int findLongestElement(File[] allFiles, String size) {
        OptionalInt max = OptionalInt.of(20);
        if (size.equalsIgnoreCase("name")) {
            max = Stream.of(allFiles).mapToInt(f -> f.getName().length()).max();
        }
        if (size.equalsIgnoreCase("size")) {
            max = Stream.of(allFiles).mapToInt(f -> String.valueOf(f.getUsableSpace()).length()).max();
        }
        return max.getAsInt();
    }
}
