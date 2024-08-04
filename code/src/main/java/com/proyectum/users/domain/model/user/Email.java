package com.proyectum.users.domain.model.user;

import com.proyectum.ddd.aggregate.ValueObject;
import jakarta.validation.Valid;

public record Email (@Valid @jakarta.validation.constraints.Email String value) implements ValueObject<String> {
}
