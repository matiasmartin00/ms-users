package com.proyectum.users.domain.repository.user;

import com.proyectum.users.domain.model.user.Email;
import com.proyectum.users.domain.model.user.UserID;
import com.proyectum.users.domain.model.user.Username;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface ExistsUserRepository {

    boolean existsByEmail(@Valid @NotNull Email email);

    boolean existsByUsername(@Valid @NotNull Username username);

    boolean existsById(@Valid @NotNull UserID id);
}
