package com.proyectum.users.domain.error;

public class UserAlreadyExistsError extends DomainError {

    public UserAlreadyExistsError() {
        super("User already exists");
    }
}
