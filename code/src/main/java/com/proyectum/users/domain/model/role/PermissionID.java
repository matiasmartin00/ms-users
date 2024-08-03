package com.proyectum.users.domain.model.role;

import com.proyectum.users.ddd.aggregate.ValueObject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Valid
public record PermissionID(@NotNull UUID value) implements ValueObject<UUID> {
}
