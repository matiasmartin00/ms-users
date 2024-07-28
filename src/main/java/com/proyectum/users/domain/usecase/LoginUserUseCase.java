package com.proyectum.users.domain.usecase;

import com.proyectum.users.domain.command.LoginUserCommand;
import com.proyectum.users.domain.model.Password;
import com.proyectum.users.domain.model.UserAggregate;
import com.proyectum.users.domain.model.Username;

public interface LoginUserUseCase {

    String login(LoginUserCommand command);
}
