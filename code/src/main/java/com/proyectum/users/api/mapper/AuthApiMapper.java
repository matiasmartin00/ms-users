package com.proyectum.users.api.mapper;

import com.proyectum.model.*;
import com.proyectum.users.domain.command.user.AddRoleUserCommand;
import com.proyectum.users.domain.command.user.DeleteRoleUserCommand;
import com.proyectum.users.domain.command.user.LoginUserCommand;
import com.proyectum.users.domain.command.user.RegisterUserCommand;
import com.proyectum.users.domain.model.role.Name;
import com.proyectum.users.domain.model.user.Email;
import com.proyectum.users.domain.model.user.UserProjection;
import com.proyectum.users.domain.model.user.Username;
import com.proyectum.users.domain.query.user.GetAuthDataQuery;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface AuthApiMapper {

    RegisterUserCommand to(SignUpRequest src);

    LoginUserCommand to(SignInRequest src);

    @Mapping(target = "token", source = "src")
    SignInResponse to(String src);

    @Mapping(target = "roleId", source = "src.id")
    AddRoleUserCommand to(UUID userId, AddRoleRequest src);

    DeleteRoleUserCommand to(UUID userId, UUID roleId);

    GetAuthDataQuery toGetAuthDataQuery(String username);

    AuthDataResponse to(UserProjection src);

    default String to(Username src) {
        return src.value();
    }

    default String to(Email src) {
        return src.value();
    }

    default String to(Name src) {
        return src.value();
    }
}
