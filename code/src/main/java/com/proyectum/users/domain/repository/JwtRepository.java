package com.proyectum.users.domain.repository;

import com.proyectum.users.domain.model.user.UserAggregate;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public interface JwtRepository {

    String generateToken(@Valid @NotNull UserAggregate user);

    void checkToken(@Valid @NotBlank String token);

    String getUsername(@Valid @NotBlank String token);
}
