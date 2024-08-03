package com.proyectum.users.domain.error;

public class DomainError extends RuntimeException {

    public DomainError(String message) {
        super(message);
    }

    public DomainError(String message, Throwable cause) {
        super(message, cause);
    }
}
