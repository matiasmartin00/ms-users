package com.proyectum.users.domain.usecase.role;

import com.proyectum.users.domain.model.role.Name;
import com.proyectum.users.domain.model.role.Permission;
import com.proyectum.users.domain.model.role.PermissionID;

import java.util.Optional;

public interface GetPermissionUseCase {

    Optional<Permission> getById(PermissionID id);
}
