package com.proyectum.users.api.mapper;

import com.proyectum.model.SignUpRequest;
import com.proyectum.users.domain.command.RegisterUserCommand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthApiMapper {

    RegisterUserCommand to(SignUpRequest src);
}
