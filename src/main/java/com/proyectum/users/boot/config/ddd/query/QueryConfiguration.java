package com.proyectum.users.boot.config.ddd.query;

import com.proyectum.users.boot.config.ddd.command.CommandBusImpl;
import com.proyectum.users.ddd.command.Command;
import com.proyectum.users.ddd.command.CommandBus;
import com.proyectum.users.ddd.command.CommandHandler;
import com.proyectum.users.ddd.query.Query;
import com.proyectum.users.ddd.query.QueryBus;
import com.proyectum.users.ddd.query.QueryHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class QueryConfiguration {

    @Bean
    public QueryBus queryBus(final List<QueryHandler> queryHandlers) {
        var map = new HashMap<Class<? extends Query>, QueryHandler>();
        for (var queryHandler : queryHandlers) {
            var commandType = getGenericType(queryHandler.getClass());
            map.put((Class<? extends Query>) commandType, queryHandler);
        }
        return new QueryBusImpl(map);
    }

    private Class<?> getGenericType(Class<?> clazz) {
        Type[] genericInterfaces = clazz.getGenericInterfaces();

        for (Type genericInterface : genericInterfaces) {
            if (genericInterface instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) genericInterface;
                Type rawType = parameterizedType.getRawType();

                if (rawType instanceof Class && QueryHandler.class.isAssignableFrom((Class<?>) rawType)) {
                    Type actualTypeArgument = parameterizedType.getActualTypeArguments()[0];

                    if (actualTypeArgument instanceof Class) {
                        return (Class<?>) actualTypeArgument;
                    }
                }
            }
        }
        return null;
    }
}
