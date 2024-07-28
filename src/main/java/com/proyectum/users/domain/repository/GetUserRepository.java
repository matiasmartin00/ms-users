package com.proyectum.users.domain.repository;

import com.proyectum.users.domain.model.Password;
import com.proyectum.users.domain.model.UserAggregate;
import com.proyectum.users.domain.model.Username;

import java.util.Optional;

public interface GetUserRepository {

    Optional<UserAggregate> getByUsername(Username username);
}
