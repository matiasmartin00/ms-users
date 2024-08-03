package com.proyectum.users.infrastructure.repository.role;

import com.proyectum.users.domain.model.role.RoleAggregate;
import com.proyectum.users.domain.repository.role.ListRolesRepository;
import com.proyectum.users.infrastructure.repository.postgres.repository.RoleEntityRepository;
import com.proyectum.users.infrastructure.repository.role.mapper.RoleEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ListRolesRepositoryImpl implements ListRolesRepository {

    private final RoleEntityRepository roleEntityRepository;
    private final RoleEntityMapper roleEntityMapper;

    @Override
    public List<RoleAggregate> getAllRoles() {
        var entities = roleEntityRepository.findAll();
        return entities
                .stream()
                .map(roleEntityMapper::to)
                .toList();
    }
}
