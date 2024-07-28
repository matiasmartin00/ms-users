package com.proyectum.users.ddd.command;

public interface CommandBus {

    <R> R handle(Command command);
}
