package com.proyectum.users.infrastructure.repository.postgres.repository;

import com.proyectum.users.infrastructure.repository.postgres.entity.PermissionEntity;
import com.proyectum.users.infrastructure.repository.postgres.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PermissionEntityRepository extends JpaRepository<PermissionEntity, UUID> {

}
