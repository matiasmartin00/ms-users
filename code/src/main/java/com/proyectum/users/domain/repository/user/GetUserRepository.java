package com.proyectum.users.domain.repository.user;

import com.proyectum.users.domain.model.user.UserAggregate;
import com.proyectum.users.domain.model.user.UserID;
import com.proyectum.users.domain.model.user.Username;

import java.util.Optional;

public interface GetUserRepository {

    Optional<UserAggregate> getByUsername(Username username);

    Optional<UserAggregate> getById(UserID id);
}
