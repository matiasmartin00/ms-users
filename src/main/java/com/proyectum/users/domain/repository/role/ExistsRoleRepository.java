package com.proyectum.users.domain.repository.role;

import com.proyectum.users.domain.model.role.Name;
import com.proyectum.users.domain.model.role.RoleID;

public interface ExistsRoleRepository {

    boolean existsByName(Name name);

    boolean existsById(RoleID id);
}
