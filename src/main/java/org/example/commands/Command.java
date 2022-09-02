package org.example.model;

import lombok.RequiredArgsConstructor;

import java.util.List;


@RequiredArgsConstructor
public abstract class Command {

    protected final Context context;

    public abstract String execute(List<String>)

}
