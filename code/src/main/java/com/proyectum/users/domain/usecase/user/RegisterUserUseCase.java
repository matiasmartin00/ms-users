package com.proyectum.users.domain.usecase.user;

import com.proyectum.users.domain.command.user.RegisterUserCommand;

public interface RegisterUserUseCase {

    void create(RegisterUserCommand command);
}
