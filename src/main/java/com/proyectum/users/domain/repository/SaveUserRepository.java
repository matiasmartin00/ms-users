package com.proyectum.users.domain.repository;

import com.proyectum.users.domain.model.UserAggregate;

public interface SaveUserRepository {

    void save(UserAggregate user);
}
