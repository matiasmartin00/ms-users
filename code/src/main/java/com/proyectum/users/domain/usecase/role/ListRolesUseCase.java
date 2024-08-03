package com.proyectum.users.domain.usecase.role;

import com.proyectum.users.domain.model.role.RoleAggregate;
import com.proyectum.users.domain.query.role.ListRolesQuery;

import java.util.List;

public interface ListRolesUseCase {

    List<RoleAggregate> getAll(ListRolesQuery query);
}
