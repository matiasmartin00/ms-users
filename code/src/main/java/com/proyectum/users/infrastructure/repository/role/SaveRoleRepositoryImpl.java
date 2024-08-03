package com.proyectum.users.infrastructure.repository.role;

import com.proyectum.users.domain.model.role.RoleAggregate;
import com.proyectum.users.domain.repository.role.SaveRoleRepository;
import com.proyectum.users.infrastructure.repository.exceptions.DataAccessException;
import com.proyectum.users.infrastructure.repository.postgres.repository.PermissionEntityRepository;
import com.proyectum.users.infrastructure.repository.postgres.repository.RoleEntityRepository;
import com.proyectum.users.infrastructure.repository.role.mapper.RoleEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SaveRoleRepositoryImpl implements SaveRoleRepository {

    private final RoleEntityRepository roleEntityRepository;
    private final PermissionEntityRepository permissionEntityRepository;
    private final RoleEntityMapper roleEntityMapper;

    @Override
    public void save(RoleAggregate role) {
        try {
            var entity = roleEntityMapper.to(role);
            permissionEntityRepository.saveAll(entity.getPermissions());
            roleEntityRepository.save(entity);
        } catch (Exception ex) {
            throw new DataAccessException(ex);
        }
    }
}
