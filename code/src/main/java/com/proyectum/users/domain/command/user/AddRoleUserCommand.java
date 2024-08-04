package com.proyectum.users.domain.command.user;

import com.proyectum.cqrs.commad.Command;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Valid
public record AddRoleUserCommand(
        @NotNull UUID userId,
        @NotNull UUID roleId) implements Command {
}
