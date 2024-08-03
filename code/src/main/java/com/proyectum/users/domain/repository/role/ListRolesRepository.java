package com.proyectum.users.domain.repository.role;

import com.proyectum.users.domain.model.role.RoleAggregate;

import java.util.List;

public interface ListRolesRepository {

    List<RoleAggregate> getAllRoles();
}
