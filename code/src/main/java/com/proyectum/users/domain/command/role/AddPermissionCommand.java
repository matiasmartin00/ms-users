package com.proyectum.users.domain.command.role;

import com.proyectum.cqrs.commad.Command;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Valid
public record AddPermissionCommand(
        @NotNull UUID roleId,
        @NotNull UUID id,
        @NotBlank @Min(3) @Max(40) String name,
        @NotBlank @Min(3) @Max(100) String description) implements Command {
}
