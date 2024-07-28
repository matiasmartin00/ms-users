package com.proyectum.users.domain.repository.role;

import com.proyectum.users.ddd.aggregate.AggregateID;
import com.proyectum.users.domain.model.role.Name;

public interface ExistsRoleRepository {

    boolean existsByName(Name name);

    boolean existsById(AggregateID id);
}
