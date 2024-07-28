package com.proyectum.users.infrastructure.repository.role;

import com.proyectum.users.domain.model.role.RoleAggregate;
import com.proyectum.users.domain.repository.role.SaveRoleRepository;
import com.proyectum.users.infrastructure.repository.postgres.repository.RoleEntityRepository;
import com.proyectum.users.infrastructure.repository.role.mapper.RoleEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SaveRoleRepositoryImpl implements SaveRoleRepository {

    private final RoleEntityRepository roleEntityRepository;
    private final RoleEntityMapper roleEntityMapper;

    @Override
    public void save(RoleAggregate role) {
        var entity = roleEntityMapper.to(role);
        roleEntityRepository.save(entity);
    }
}
