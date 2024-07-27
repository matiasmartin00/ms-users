package com.proyectum.users.ddd.command;

public interface CommandHandler <C extends Command> {

    void handle(C command);
}
