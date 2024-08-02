package com.proyectum.users.domain.usecase.role;

import com.proyectum.users.domain.command.role.DeletePermissionCommand;

public interface DeleteRolePermissionUseCase {

    void deletePermission(DeletePermissionCommand command);
}
