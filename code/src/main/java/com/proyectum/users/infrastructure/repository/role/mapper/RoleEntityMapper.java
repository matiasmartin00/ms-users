package com.proyectum.users.infrastructure.repository.role.mapper;

import com.proyectum.users.domain.model.role.*;
import com.proyectum.users.infrastructure.repository.postgres.entity.PermissionEntity;
import com.proyectum.users.infrastructure.repository.postgres.entity.RoleEntity;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface RoleEntityMapper {

    RoleEntity to(RoleAggregate src);

    RoleAggregate to(RoleEntity src);

    Permission to(PermissionEntity src);

    default PermissionID toPermissionID(UUID src) {
        return new PermissionID(src);
    }

    default RoleID toAggregateId(UUID src) {
        return new RoleID(src);
    }

    default Name toName(String src) {
        return new Name(src);
    }

    default Description toDescription(String src) {
        return new Description(src);
    }

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
