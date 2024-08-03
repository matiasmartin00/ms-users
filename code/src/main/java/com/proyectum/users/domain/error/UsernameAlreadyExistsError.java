package com.proyectum.users.domain.error;

public class UsernameAlreadyExistsError extends DomainError {

    public UsernameAlreadyExistsError() {
        super("Username already exists");
    }
}
