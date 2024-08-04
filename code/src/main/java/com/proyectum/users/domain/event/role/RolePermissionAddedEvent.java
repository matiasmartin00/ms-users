package com.proyectum.users.domain.event.role;

import com.proyectum.ddd.aggregate.DomainEvent;
import com.proyectum.users.domain.model.role.PermissionID;
import com.proyectum.users.domain.model.role.RoleID;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Valid
public record RolePermissionAddedEvent(
        @NotNull RoleID id,
        @NotNull PermissionID permissionID) implements DomainEvent {
}
