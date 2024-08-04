package com.proyectum.users.domain.event.role;

import com.proyectum.ddd.aggregate.DomainEvent;
import com.proyectum.users.domain.model.role.Description;
import com.proyectum.users.domain.model.role.Name;
import com.proyectum.users.domain.model.role.RoleID;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Valid
public record RoleCreatedEvent(
        @NotNull RoleID id,
        @NotNull Name name,
        @NotNull Description description) implements DomainEvent {
}
