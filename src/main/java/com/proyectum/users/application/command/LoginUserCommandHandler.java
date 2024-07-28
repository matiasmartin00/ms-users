package com.proyectum.users.application.command;

import com.proyectum.users.ddd.command.CommandHandler;
import com.proyectum.users.domain.command.LoginUserCommand;
import com.proyectum.users.domain.model.Password;
import com.proyectum.users.domain.model.Username;
import com.proyectum.users.domain.usecase.LoginUserUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class LoginUserCommandHandler implements CommandHandler<LoginUserCommand> {

    private final LoginUserUseCase loginUserUseCase;

    @Override
    public void handle(LoginUserCommand command) {
        log.info("Login user");
        var token = loginUserUseCase.login(command);
        log.info("User logged");
    }
}
