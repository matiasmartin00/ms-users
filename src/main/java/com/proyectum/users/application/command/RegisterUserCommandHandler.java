package com.proyectum.users.application.command;

import com.proyectum.users.ddd.command.CommandHandler;
import com.proyectum.users.domain.command.RegisterUserCommand;
import com.proyectum.users.domain.usecase.RegisterUserUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RegisterUserCommandHandler implements CommandHandler<RegisterUserCommand, Void> {

    private final RegisterUserUseCase registerUserUseCase;

    @Override
    public Void handle(RegisterUserCommand command) {
        log.debug("Creating a new user");
        registerUserUseCase.create(command);
        log.debug("Created a new user");
        return null;
    }
}
