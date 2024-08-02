package com.proyectum.users.domain.repository.role;

import com.proyectum.users.domain.model.role.Name;
import com.proyectum.users.domain.model.role.Permission;
import com.proyectum.users.domain.model.role.PermissionID;

import java.util.Optional;

public interface GetPermissionRepository {

    Optional<Permission> findById(PermissionID id);
}
