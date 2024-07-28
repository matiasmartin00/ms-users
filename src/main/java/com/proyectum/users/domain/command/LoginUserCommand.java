package com.proyectum.users.domain.command;

import com.proyectum.users.ddd.command.Command;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record LoginUserCommand(
        @Valid @NotBlank @Min(3) @Max(50) String username,
        @Valid @NotBlank @Min(3) @Max(50) String password) implements Command {
}
