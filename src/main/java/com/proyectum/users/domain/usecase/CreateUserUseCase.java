package com.proyectum.users.domain.usecase;

import com.proyectum.users.domain.command.CreateUserCommand;

public interface CreateUserUseCase {

    void create(CreateUserCommand command);
}
