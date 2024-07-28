package com.proyectum.users.boot.config.ddd.query;

import com.proyectum.users.boot.config.ddd.exceptions.UnknownCommandHandlerException;
import com.proyectum.users.ddd.command.Command;
import com.proyectum.users.ddd.command.CommandHandler;
import com.proyectum.users.ddd.query.Query;
import com.proyectum.users.ddd.query.QueryBus;
import com.proyectum.users.ddd.query.QueryHandler;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.Objects;

@RequiredArgsConstructor
public class QueryBusImpl implements QueryBus {

    private final Map<Class<? extends Query>, QueryHandler> handlers;

    @Override
    public <R> R ask(Query query) {
        var handler = handlers.get(query.getClass());
        if (Objects.isNull(handler)) {
            throw new UnknownCommandHandlerException("No handler found for query " + query.getClass());
        }
        return (R) handler.ask(query);
    }
}
