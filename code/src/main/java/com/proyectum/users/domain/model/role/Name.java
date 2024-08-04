package com.proyectum.users.domain.model.role;

import com.proyectum.ddd.aggregate.ValueObject;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Name(@NotNull @NotBlank @Min(3) @Max(40) String value) implements ValueObject<String> {
}
