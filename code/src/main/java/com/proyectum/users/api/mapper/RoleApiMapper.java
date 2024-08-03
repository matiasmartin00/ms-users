package com.proyectum.users.api.mapper;

import com.proyectum.model.*;
import com.proyectum.users.domain.command.role.AddPermissionCommand;
import com.proyectum.users.domain.command.role.CreateRoleCommand;
import com.proyectum.users.domain.command.role.DeletePermissionCommand;
import com.proyectum.users.domain.command.user.AddRoleUserCommand;
import com.proyectum.users.domain.model.role.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface RoleApiMapper {

    CreateRoleCommand to(RoleRequest src);

    AddPermissionCommand to(UUID roleId, AddPermissionRequest src);

    DeletePermissionCommand to(UUID roleId, UUID permissionId);

    Role to(RoleAggregate src);

    default UUID toUUID(RoleID src) {
        return src.value();
    }

    default UUID toUUID(PermissionID src) {
        return src.value();
    }

    default String toName(Name src) {
        return src.value();
    }

    default String toDescription(Description src) {
        return src.value();
    }
}
