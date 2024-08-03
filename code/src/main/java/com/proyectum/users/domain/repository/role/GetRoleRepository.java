package com.proyectum.users.domain.repository.role;

import com.proyectum.users.domain.model.role.RoleAggregate;
import com.proyectum.users.domain.model.role.RoleID;

import java.util.Optional;

public interface GetRoleRepository {

    Optional<RoleAggregate> findById(RoleID id);
}
