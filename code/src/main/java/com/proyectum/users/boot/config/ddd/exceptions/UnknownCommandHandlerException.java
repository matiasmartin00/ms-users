package com.proyectum.users.boot.config.ddd.exceptions;

public class UnknownCommandHandlerException extends RuntimeException {

    public UnknownCommandHandlerException(String message) {
        super(message);
    }
}
