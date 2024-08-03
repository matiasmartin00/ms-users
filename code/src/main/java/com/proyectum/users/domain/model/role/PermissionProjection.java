package com.proyectum.users.domain.model.role;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Valid
public record PermissionProjection(
        @NotNull Name name) {
}
