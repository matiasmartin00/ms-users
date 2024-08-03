package com.proyectum.users.domain.usecase.user;

import com.proyectum.users.domain.command.user.DeleteRoleUserCommand;

public interface DeleteRoleUserUseCase {

    void deleteRoleUser(DeleteRoleUserCommand command);
}
