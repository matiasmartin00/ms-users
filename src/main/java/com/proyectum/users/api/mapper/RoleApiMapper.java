package com.proyectum.users.api.mapper;

import com.proyectum.model.RoleRequest;
import com.proyectum.users.domain.command.role.CreateRoleCommand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleApiMapper {

    CreateRoleCommand to(RoleRequest src);
}
