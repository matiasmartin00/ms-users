package com.proyectum.users.infrastructure.repository;

import com.proyectum.users.ddd.aggregate.AggregateID;
import com.proyectum.users.domain.model.Email;
import com.proyectum.users.domain.model.Username;
import com.proyectum.users.domain.repository.ExistsUserRepository;
import com.proyectum.users.infrastructure.repository.postgres.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ExistsUserRepositoryImpl implements ExistsUserRepository {

    private final UserEntityRepository entityRepository;

    @Override
    public boolean existsByEmail(Email email) {
        return entityRepository.existsByEmail(email.value());
    }

    @Override
    public boolean existsByUsername(Username username) {
        return entityRepository.existsByUsername(username.value());
    }

    @Override
    public boolean existsById(AggregateID id) {
        return entityRepository.existsById(id.value());
    }

}
