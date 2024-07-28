package com.proyectum.users.infrastructure.repository.postgres.repository;

import com.proyectum.users.infrastructure.repository.postgres.entity.UserEntity;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, UUID> {

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsById(UUID id);
}
