package com.proyectum.users.domain.usecase.role;

import com.proyectum.users.domain.command.role.AddPermissionCommand;

public interface AddRolePermissionUseCase {

    void addPermission(AddPermissionCommand command);
}
