package com.proyectum.users.domain.error;

public class EmailAlreadyExistsError extends DomainError {

    public EmailAlreadyExistsError() {
        super("Email already exists");
    }
}
