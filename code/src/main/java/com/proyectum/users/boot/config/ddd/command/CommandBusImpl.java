package com.proyectum.users.boot.config.ddd.command;

import com.proyectum.cqrs.commad.Command;
import com.proyectum.cqrs.commad.CommandBus;
import com.proyectum.cqrs.commad.CommandHandler;
import com.proyectum.users.boot.config.ddd.exceptions.UnknownCommandHandlerException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.Objects;

@RequiredArgsConstructor
public class CommandBusImpl implements CommandBus {

    private final Map<Class<? extends Command>, CommandHandler> handlers;

    @Override
    @Transactional
    public <R> R handle(Command command) {
        var handler = handlers.get(command.getClass());
        if (Objects.isNull(handler)) {
            throw new UnknownCommandHandlerException("No handler found for command " + command.getClass());
        }
        return (R) handler.handle(command);
    }
}