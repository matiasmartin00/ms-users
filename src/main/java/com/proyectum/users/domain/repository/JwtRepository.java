package com.proyectum.users.domain.repository;

import com.proyectum.users.domain.model.UserAggregate;

public interface JwtRepository {

    String generateToken(UserAggregate user);

    void checkToken(String token);
}
