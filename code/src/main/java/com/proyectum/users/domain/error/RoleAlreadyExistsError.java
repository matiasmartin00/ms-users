package com.proyectum.users.domain.error;

public class RoleAlreadyExistsError extends DomainError {

    public RoleAlreadyExistsError() {
        super("Role already exists");
    }
}
