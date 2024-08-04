package com.proyectum.users.domain.model.role;

import com.proyectum.ddd.aggregate.ValueObject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Valid
public record RoleID(@NotNull UUID value) implements ValueObject<UUID> {
}
