package com.proyectum.users.domain.command.role;

import com.proyectum.users.ddd.command.Command;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Valid
public record DeletePermissionCommand(
        @NotNull UUID roleId,
        @NotNull UUID permissionId) implements Command {
}
