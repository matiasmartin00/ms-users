package com.proyectum.users.ddd.aggregate;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AggregateID(@Valid @NotNull UUID value) implements ValueObject<UUID> {

}
