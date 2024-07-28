package com.proyectum.users.domain.event.user;

import com.proyectum.users.ddd.aggregate.AggregateID;
import com.proyectum.users.ddd.event.DomainEvent;
import com.proyectum.users.domain.model.user.Email;
import com.proyectum.users.domain.model.user.Username;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Valid
public record UserRegisteredEvent(
        @NotNull AggregateID id,
        @NotNull Username username,
        @NotNull Email email) implements DomainEvent {
}
