package com.proyectum.users.ddd.query;

public interface QueryBus {

    <R> R ask(Query query);
}
