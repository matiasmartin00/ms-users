package com.proyectum.users.domain.event.user;

import com.proyectum.users.ddd.event.DomainEvent;
import com.proyectum.users.domain.model.role.RoleID;
import com.proyectum.users.domain.model.user.UserID;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Valid
public record UserRoleDeletedEvent(
        @NotNull UserID id,
        @NotNull RoleID roleID) implements DomainEvent {
}
