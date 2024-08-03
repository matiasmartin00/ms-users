package com.proyectum.users.boot.config.ddd.exceptions;

public class UnknownQueryHandlerException extends RuntimeException {

    public UnknownQueryHandlerException(String message) {
        super(message);
    }
}
