package org.example.commands;

import lombok.RequiredArgsConstructor;
import org.example.model.Context;
import java.util.List;

/**
 * абстрактный класс для выполение определеной комманды таких как: ls, pwd, help, и остальных.
 *
 */


@RequiredArgsConstructor
public abstract class Command {
    public final Context context;
    public abstract String execute(List<String> args);

}
