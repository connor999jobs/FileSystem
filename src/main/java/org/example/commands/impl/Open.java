package org.example.commands.impl;

import org.example.commands.Command;
import org.example.model.Context;
import java.util.List;

public class Open extends Command {
    public Open(Context context) {
        super(context);
    }

    @Override
    public String execute(List<String> args) {
        return null;
    }
}
