package com.proyectum.users.domain.command.user;

import com.proyectum.cqrs.commad.Command;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Valid
public record LoginUserCommand(
        @NotBlank @Min(3) @Max(50) String username,
        @NotBlank @Min(3) @Max(50) String password) implements Command {
}
