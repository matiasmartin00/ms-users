package com.proyectum.users.application.command.role;

import com.proyectum.cqrs.commad.CommandHandler;
import com.proyectum.users.domain.command.role.CreateRoleCommand;
import com.proyectum.users.domain.usecase.role.CreateRoleUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateRoleCommandHandler implements CommandHandler<CreateRoleCommand, Void> {

    private final CreateRoleUseCase createRoleUseCase;

    @Override
    public Void handle(CreateRoleCommand command) {
        createRoleUseCase.create(command);
        return null;
    }
}
