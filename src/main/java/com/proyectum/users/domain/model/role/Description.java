package com.proyectum.users.domain.model.role;

import com.proyectum.users.ddd.aggregate.ValueObject;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Description(@NotNull @NotBlank @Min(5) @Max(100) String value) implements ValueObject<String> {
}
