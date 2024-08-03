package com.proyectum.users.infrastructure.repository.user;

import com.proyectum.users.domain.model.role.RoleID;
import com.proyectum.users.domain.model.user.Email;
import com.proyectum.users.domain.model.user.UserID;
import com.proyectum.users.domain.model.user.Username;
import com.proyectum.users.domain.repository.user.ExistsUserRepository;
import com.proyectum.users.infrastructure.repository.postgres.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

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
    public boolean existsById(UserID id) {
        return entityRepository.existsById(id.value());
    }

}
