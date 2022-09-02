package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.commands.Command;
import java.io.File;
import java.util.Map;

/**
 * Модель класса которая представляет собой Map, c названием комманды и её реализации.
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Context {
    private Map<String, Command> commandMap;
    private File currentDirectory;
}
