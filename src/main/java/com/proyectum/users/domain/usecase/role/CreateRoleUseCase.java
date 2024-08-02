package com.proyectum.users.domain.usecase.role;

import com.proyectum.users.domain.command.role.CreateRoleCommand;

public interface CreateRoleUseCase {

    void create(CreateRoleCommand command);
}
