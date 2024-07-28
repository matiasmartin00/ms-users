package com.proyectum.users.domain.event.role;

import com.proyectum.users.ddd.aggregate.AggregateID;
import com.proyectum.users.ddd.event.DomainEvent;
import com.proyectum.users.domain.model.role.Description;
import com.proyectum.users.domain.model.role.Name;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Valid
public record RoleCreatedEvent(
        @NotNull AggregateID id,
        @NotNull Name name,
        @NotNull Description description) implements DomainEvent {
}
