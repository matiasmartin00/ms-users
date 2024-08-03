package com.proyectum.users.application.command.user;

import com.proyectum.users.ddd.command.CommandHandler;
import com.proyectum.users.domain.command.user.AddRoleUserCommand;
import com.proyectum.users.domain.usecase.user.AddRoleUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddRoleUserCommandHandler implements CommandHandler<AddRoleUserCommand, Void> {

    private final AddRoleUserUseCase addRoleUserUseCase;

    @Override
    public Void handle(AddRoleUserCommand command) {
        addRoleUserUseCase.addRoleUser(command);
        return null;
    }
}
