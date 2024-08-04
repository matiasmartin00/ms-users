package com.proyectum.users.domain.command.user;

import com.proyectum.cqrs.commad.Command;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.util.UUID;

@Valid
public record RegisterUserCommand(
        @NotNull UUID id,
        @NotBlank @Min(3) @Max(50) String username,
        @NotBlank @Min(3) @Max(50) String password,
        @Email @Min(3) @Max(50) String email) implements Command {


}
