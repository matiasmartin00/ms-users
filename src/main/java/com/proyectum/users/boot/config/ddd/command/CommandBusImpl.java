package com.proyectum.users.boot.config.ddd.command;

import com.proyectum.users.boot.config.ddd.exceptions.UnknownCommandHandlerException;
import com.proyectum.users.ddd.command.Command;
import com.proyectum.users.ddd.command.CommandBus;
import com.proyectum.users.ddd.command.CommandHandler;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.Objects;

@RequiredArgsConstructor
public class CommandBusImpl implements CommandBus {

    private final Map<Class<? extends Command>, CommandHandler> handlers;

    @Override
    public <R> R handle(Command command) {
        var handler = handlers.get(command.getClass());
        if (Objects.isNull(handler)) {
            throw new UnknownCommandHandlerException("No handler found for command " + command.getClass());
        }
        return (R) handler.handle(command);
    }
}