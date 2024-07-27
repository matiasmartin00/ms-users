package com.proyectum.users.domain.model;

import com.proyectum.users.ddd.aggregate.ValueObject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record FirstName(@Valid @NotBlank String value) implements ValueObject<String> {
}
