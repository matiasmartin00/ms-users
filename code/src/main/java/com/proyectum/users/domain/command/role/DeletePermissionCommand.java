package com.proyectum.users.domain.command.role;

import com.proyectum.cqrs.commad.Command;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Valid
public record DeletePermissionCommand(
        @NotNull UUID roleId,
        @NotNull UUID permissionId) implements Command {
}
