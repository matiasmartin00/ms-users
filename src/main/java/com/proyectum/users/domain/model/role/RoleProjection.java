package com.proyectum.users.domain.model.role;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

@Valid
public record RoleProjection(
        @NotNull Name name,
        @NotNull Set<PermissionProjection> permissions
) {
}
