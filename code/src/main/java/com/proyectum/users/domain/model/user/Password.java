package com.proyectum.users.domain.model.user;

import com.proyectum.users.ddd.aggregate.ValueObject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record Password(@Valid @NotBlank String value) implements ValueObject<String> {
}
