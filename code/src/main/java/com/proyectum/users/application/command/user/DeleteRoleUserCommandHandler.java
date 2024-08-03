package com.proyectum.users.application.command.user;

import com.proyectum.users.ddd.command.CommandHandler;
import com.proyectum.users.domain.command.user.AddRoleUserCommand;
import com.proyectum.users.domain.command.user.DeleteRoleUserCommand;
import com.proyectum.users.domain.usecase.user.AddRoleUserUseCase;
import com.proyectum.users.domain.usecase.user.DeleteRoleUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteRoleUserCommandHandler implements CommandHandler<DeleteRoleUserCommand, Void> {

    private final DeleteRoleUserUseCase deleteRoleUserUseCase;

    @Override
    public Void handle(DeleteRoleUserCommand command) {
        deleteRoleUserUseCase.deleteRoleUser(command);
        return null;
    }
}
