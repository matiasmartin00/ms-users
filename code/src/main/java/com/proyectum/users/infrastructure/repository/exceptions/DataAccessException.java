package com.proyectum.users.infrastructure.repository.exceptions;

public class DataAccessException extends RuntimeException {

    public DataAccessException(Throwable ex) {
        super(ex);
    }
}
