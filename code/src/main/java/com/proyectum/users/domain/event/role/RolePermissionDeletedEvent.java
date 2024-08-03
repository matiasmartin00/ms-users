package com.proyectum.users.domain.event.role;

import com.proyectum.users.ddd.event.DomainEvent;
import com.proyectum.users.domain.model.role.PermissionID;
import com.proyectum.users.domain.model.role.RoleID;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Valid
public record RolePermissionDeletedEvent(
        @NotNull RoleID id,
        @NotNull PermissionID permissionID) implements DomainEvent {
}
