package com.proyectum.users.ddd.query;

public interface QueryHandler<Q extends Query, R> {

    R ask(Q query);
}
