package com.proyectum.users.domain.usecase.user;

import com.proyectum.users.domain.command.user.LoginUserCommand;

public interface LoginUserUseCase {

    String login(LoginUserCommand command);
}
