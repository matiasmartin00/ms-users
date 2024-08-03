package com.proyectum.users.domain.repository.role;

import com.proyectum.users.domain.model.role.RoleAggregate;

public interface SaveRoleRepository {

    void save(RoleAggregate role);
}
