package com.proyectum.users.infrastructure.repository.user;

import com.proyectum.users.domain.model.user.UserAggregate;
import com.proyectum.users.domain.repository.user.SaveUserRepository;
import com.proyectum.users.infrastructure.repository.user.mapper.UserEntityMapper;
import com.proyectum.users.infrastructure.repository.postgres.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SaveUserRepositoryImpl implements SaveUserRepository {

    private final UserEntityRepository userEntityRepository;

    private final UserEntityMapper userEntityMapper;

    @Override
    public void save(UserAggregate user) {
        var entity = userEntityMapper.to(user);
        userEntityRepository.save(entity);
    }
}
