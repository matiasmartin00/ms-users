package com.proyectum.users.application.command;

import com.proyectum.users.ddd.aggregate.AggregateID;
import com.proyectum.users.ddd.command.CommandHandler;
import com.proyectum.users.domain.command.CreateUserCommand;
import com.proyectum.users.domain.model.Email;
import com.proyectum.users.domain.model.Password;
import com.proyectum.users.domain.model.UserAggregate;
import com.proyectum.users.domain.model.Username;
import com.proyectum.users.domain.usecase.CreateUserUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateUserCommandHandler implements CommandHandler<CreateUserCommand> {

    private final CreateUserUseCase createUserUseCase;

    @Override
    public void handle(CreateUserCommand command) {
        log.debug("Creating a new user");
        createUserUseCase.create(command);
        log.debug("Created a new user");
    }
}
