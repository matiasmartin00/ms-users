package com.proyectum.users.domain.model.user;

import com.proyectum.users.domain.model.role.RoleProjection;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record UserProjection(
        @NotNull Username username,
        @NotNull Email email,
        @NotNull Set<RoleProjection> roles
        ) {
}
