package com.proyectum.users.infrastructure.repository.user;

import com.proyectum.users.domain.model.user.UserAggregate;
import com.proyectum.users.domain.model.user.Username;
import com.proyectum.users.domain.repository.user.GetUserRepository;
import com.proyectum.users.infrastructure.repository.user.mapper.UserEntityMapper;
import com.proyectum.users.infrastructure.repository.postgres.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetUserRepositoryImpl implements GetUserRepository {

    private final UserEntityRepository userEntityRepository;

    private final UserEntityMapper userEntityMapper;

    @Override
    public Optional<UserAggregate> getByUsername(Username username) {
        var entityOpt = userEntityRepository.findByUsername(username.value());
        return entityOpt.map(userEntityMapper::to);
    }
}
