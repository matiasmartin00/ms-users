package com.proyectum.users.domain.error;

public class UserNotFoundError extends DomainError {

    public UserNotFoundError() {
        super("User not found");
    }
}
