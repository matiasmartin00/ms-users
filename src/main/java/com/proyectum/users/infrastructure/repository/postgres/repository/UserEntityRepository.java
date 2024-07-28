package com.proyectum.users.infrastructure.repository.postgres.repository;

import com.proyectum.users.infrastructure.repository.postgres.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, UUID> {

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsById(UUID id);

    Optional<UserEntity> findByUsername(String username);
}
