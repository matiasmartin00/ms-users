package com.proyectum.users.domain.model.user;

import com.proyectum.users.ddd.aggregate.ValueObject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Valid
public record UserID(
        @NotNull UUID value) implements ValueObject<UUID> {
}
