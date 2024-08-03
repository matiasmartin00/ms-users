package com.proyectum.users.infrastructure.repository.postgres.repository;

import com.proyectum.users.infrastructure.repository.postgres.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleEntityRepository extends JpaRepository<RoleEntity, UUID> {

    boolean existsByName(String name);

    boolean existsById(UUID id);
}
