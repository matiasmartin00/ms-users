package com.proyectum.users.domain.usecase.role;

import com.proyectum.users.domain.model.role.RoleAggregate;
import com.proyectum.users.domain.model.role.RoleID;

import java.util.Optional;

public interface GetRoleUseCase {

    Optional<RoleAggregate> getById(RoleID id);
}
