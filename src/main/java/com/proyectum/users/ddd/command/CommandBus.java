package com.proyectum.users.ddd.command;

public interface CommandBus {

    void handle(Command command);
}
