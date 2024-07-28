package com.proyectum.users.api.mapper;

import com.proyectum.model.Role;
import com.proyectum.model.RoleRequest;
import com.proyectum.model.RoleResponse;
import com.proyectum.users.ddd.aggregate.AggregateID;
import com.proyectum.users.domain.command.role.CreateRoleCommand;
import com.proyectum.users.domain.model.role.Description;
import com.proyectum.users.domain.model.role.Name;
import com.proyectum.users.domain.model.role.RoleAggregate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface RoleApiMapper {

    CreateRoleCommand to(RoleRequest src);

    Role to(RoleAggregate src);

    default UUID toUUID(AggregateID src) {
        return src.value();
    }

    default String toName(Name src) {
        return src.value();
    }

    default String toDescription(Description src) {
        return src.value();
    }
}
