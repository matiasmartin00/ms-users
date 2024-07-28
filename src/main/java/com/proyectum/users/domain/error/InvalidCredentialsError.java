package com.proyectum.users.domain.error;

public class InvalidCredentialsError extends DomainError {

    public InvalidCredentialsError() {
        super("Invalid credentials");
    }
}
