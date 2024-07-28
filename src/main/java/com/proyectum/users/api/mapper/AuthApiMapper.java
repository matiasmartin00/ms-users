package com.proyectum.users.api.mapper;

import com.proyectum.model.SignInRequest;
import com.proyectum.model.SignInResponse;
import com.proyectum.model.SignUpRequest;
import com.proyectum.users.domain.command.LoginUserCommand;
import com.proyectum.users.domain.command.RegisterUserCommand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthApiMapper {

    RegisterUserCommand to(SignUpRequest src);

    LoginUserCommand to(SignInRequest src);

    @Mapping(target = "token", source = "src")
    SignInResponse to(String src);
}
