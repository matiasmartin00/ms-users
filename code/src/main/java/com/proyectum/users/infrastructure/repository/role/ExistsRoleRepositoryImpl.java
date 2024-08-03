package com.proyectum.users.infrastructure.repository.role;

import com.proyectum.users.domain.model.role.Name;
import com.proyectum.users.domain.model.role.RoleID;
import com.proyectum.users.domain.repository.role.ExistsRoleRepository;
import com.proyectum.users.infrastructure.repository.postgres.repository.RoleEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ExistsRoleRepositoryImpl implements ExistsRoleRepository {

    private final RoleEntityRepository roleEntityRepository;

    @Override
    public boolean existsByName(Name name) {
        return roleEntityRepository.existsByName(name.value());
    }

    @Override
    public boolean existsById(RoleID id) {
        return roleEntityRepository.existsById(id.value());
    }
}
