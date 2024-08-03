package com.proyectum.users.domain.repository.user;

import com.proyectum.users.domain.model.user.UserAggregate;

public interface SaveUserRepository {

    void save(UserAggregate user);
}
