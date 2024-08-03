package com.proyectum.users.infrastructure.repository.role;

import com.proyectum.users.domain.model.role.RoleAggregate;
import com.proyectum.users.domain.model.role.RoleID;
import com.proyectum.users.domain.repository.role.GetRoleRepository;
import com.proyectum.users.infrastructure.repository.postgres.repository.RoleEntityRepository;
import com.proyectum.users.infrastructure.repository.role.mapper.RoleEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class GetRoleRepositoryImpl implements GetRoleRepository {

    private final RoleEntityRepository roleEntityRepository;
    private final RoleEntityMapper roleEntityMapper;

    @Override
    public Optional<RoleAggregate> findById(RoleID id) {
        var entity = roleEntityRepository.findById(id.value());
        return entity.map(roleEntityMapper::to);
    }
}
