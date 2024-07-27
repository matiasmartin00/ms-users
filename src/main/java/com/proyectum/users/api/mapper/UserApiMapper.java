package com.proyectum.users.api.mapper;

import com.proyectum.model.CreationUserRequest;
import com.proyectum.users.domain.command.CreateUserCommand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserApiMapper {

    CreateUserCommand to(CreationUserRequest src);
}
