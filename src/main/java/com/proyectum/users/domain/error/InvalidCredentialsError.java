package com.proyectum.users.domain.error;

public class InvalidCredentialsError extends DomainError {

    public InvalidCredentialsError() {
        super("Invalid credentials");
    }

    public InvalidCredentialsError(Throwable cause) {
        super("Invalid credentials", cause);
    }
}
