package com.proyectum.users.ddd.command;

public interface CommandHandler <C extends Command, R> {

    R handle(C command);
}
