package com.proyectum.users.application.usecase.role;

import com.proyectum.users.domain.model.role.RoleAggregate;
import com.proyectum.users.domain.query.role.ListRolesQuery;
import com.proyectum.users.domain.repository.role.ListRolesRepository;
import com.proyectum.users.domain.usecase.role.ListRolesUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListRolesUseCaseImpl implements ListRolesUseCase {

    private final ListRolesRepository listRolesRepository;

    @Override
    public List<RoleAggregate> getAll(ListRolesQuery query) {
        return listRolesRepository.getAllRoles();
    }
}
