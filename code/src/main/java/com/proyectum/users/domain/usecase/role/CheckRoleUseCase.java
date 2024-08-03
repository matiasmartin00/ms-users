package com.proyectum.users.domain.usecase.role;

import com.proyectum.users.domain.model.role.RoleAggregate;

public interface CheckRoleUseCase {

    void checkRole(RoleAggregate role);
}
