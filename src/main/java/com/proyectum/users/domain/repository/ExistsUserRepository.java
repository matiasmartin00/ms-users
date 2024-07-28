package com.proyectum.users.domain.repository;

import com.proyectum.users.ddd.aggregate.AggregateID;
import com.proyectum.users.domain.model.Email;
import com.proyectum.users.domain.model.Username;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public interface ExistsUserRepository {

    boolean existsByEmail(@Valid @NotNull Email email);

    boolean existsByUsername(@Valid @NotNull Username username);

    boolean existsById(@Valid @NotNull AggregateID id);
}
