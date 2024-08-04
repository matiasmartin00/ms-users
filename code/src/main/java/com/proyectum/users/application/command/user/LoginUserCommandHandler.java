package com.proyectum.users.application.command.user;

import com.proyectum.cqrs.commad.CommandHandler;
import com.proyectum.users.domain.command.user.LoginUserCommand;
import com.proyectum.users.domain.usecase.user.LoginUserUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class LoginUserCommandHandler implements CommandHandler<LoginUserCommand, String> {

    private final LoginUserUseCase loginUserUseCase;

    @Override
    public String handle(LoginUserCommand command) {
        log.info("Login user");
        var token = loginUserUseCase.login(command);
        log.info("User logged");
        return token;
    }
}
