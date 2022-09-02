package org.example.commands.impl;

import org.example.commands.Command;
import org.example.model.Context;
import java.util.List;

public class Pwd extends Command {
    public Pwd(Context context) {
        super(context);
    }

    @Override
    public String execute(List<String> args) {
        return context.getCurrentDirectory().getAbsolutePath();
    }
}
