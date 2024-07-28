package com.proyectum.users.domain.usecase;

import com.proyectum.users.domain.command.RegisterUserCommand;

public interface RegisterUserUseCase {

    void create(RegisterUserCommand command);
}
