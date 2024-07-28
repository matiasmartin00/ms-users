package com.proyectum.users.domain.command;

import com.proyectum.users.ddd.command.Command;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.util.UUID;

public record RegisterUserCommand(
        @Valid @NotNull UUID id,
        @Valid @NotBlank @Min(3) @Max(50) String username,
        @Valid @NotBlank @Min(3) @Max(50) String password,
        @Valid @Email @Min(3) @Max(50) String email) implements Command {


}
