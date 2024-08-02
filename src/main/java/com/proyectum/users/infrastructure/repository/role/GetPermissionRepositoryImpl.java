package com.proyectum.users.infrastructure.repository.role;

import com.proyectum.users.domain.model.role.Name;
import com.proyectum.users.domain.model.role.Permission;
import com.proyectum.users.domain.model.role.PermissionID;
import com.proyectum.users.domain.repository.role.GetPermissionRepository;
import com.proyectum.users.infrastructure.repository.postgres.repository.PermissionEntityRepository;
import com.proyectum.users.infrastructure.repository.role.mapper.RoleEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class GetPermissionRepositoryImpl implements GetPermissionRepository {

    private final PermissionEntityRepository permissionEntityRepository;
    private final RoleEntityMapper roleEntityMapper;

    @Override
    public Optional<Permission> findById(PermissionID id) {
        var entity = permissionEntityRepository.findById(id.value());
        return entity.map(roleEntityMapper::to);
    }
}
