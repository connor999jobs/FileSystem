package org.example.commands.impl;

import org.example.commands.Command;
import org.example.model.Context;
import java.util.List;
import java.util.Map;

public class Help extends Command {
    public Help(Context context) {
        super(context);
    }

    @Override
    public String execute(List<String> args) {
        Map<String, Command> commandMap = context.getCommandMap();
        StringBuilder result = new StringBuilder("Available commands:\n");
        if (commandMap != null) {
            for (String each : commandMap.keySet()) {
                result.append(each).append("\n");
            }
        }
        return result.toString();
    }
}
