package com.proyectum.users.domain.error;

public class RoleNameAlreadyExistsError extends DomainError {

    public RoleNameAlreadyExistsError() {
        super("Role name already exists");
    }
}
