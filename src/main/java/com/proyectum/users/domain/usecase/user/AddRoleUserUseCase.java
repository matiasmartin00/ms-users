package com.proyectum.users.domain.usecase.user;

import com.proyectum.users.domain.command.user.AddRoleUserCommand;

public interface AddRoleUserUseCase {

    void addRoleUser(AddRoleUserCommand command);
}
