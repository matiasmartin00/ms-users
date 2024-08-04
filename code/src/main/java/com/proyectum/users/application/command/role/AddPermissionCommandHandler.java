package com.proyectum.users.application.command.role;

import com.proyectum.cqrs.commad.CommandHandler;
import com.proyectum.users.domain.command.role.AddPermissionCommand;
import com.proyectum.users.domain.usecase.role.AddRolePermissionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddPermissionCommandHandler implements CommandHandler<AddPermissionCommand, Void> {

    private final AddRolePermissionUseCase addRolePermissionUseCase;

    @Override
    public Void handle(AddPermissionCommand command) {
        addRolePermissionUseCase.addPermission(command);
        return null;
    }
}
