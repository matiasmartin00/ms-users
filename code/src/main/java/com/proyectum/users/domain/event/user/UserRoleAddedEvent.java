package com.proyectum.users.domain.event.user;

import com.proyectum.users.ddd.event.DomainEvent;
import com.proyectum.users.domain.model.role.RoleID;
import com.proyectum.users.domain.model.user.UserID;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Valid
public record UserRoleAddedEvent(
        @NotNull UserID id,
        @NotNull RoleID roleID) implements DomainEvent {
}
