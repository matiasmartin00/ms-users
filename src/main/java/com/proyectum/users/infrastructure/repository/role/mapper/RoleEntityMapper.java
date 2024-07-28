package com.proyectum.users.infrastructure.repository.role.mapper;

import com.proyectum.users.ddd.aggregate.AggregateID;
import com.proyectum.users.domain.model.role.Description;
import com.proyectum.users.domain.model.role.Name;
import com.proyectum.users.domain.model.role.RoleAggregate;
import com.proyectum.users.infrastructure.repository.postgres.entity.RoleEntity;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface RoleEntityMapper {

    RoleEntity to(RoleAggregate src);

    RoleAggregate to(RoleEntity src);

    default AggregateID toAggregateId(UUID src) {
        return new AggregateID(src);
    }

    default Name toName(String src) {
        return new Name(src);
    }

    default Description toDescription(String src) {
        return new Description(src);
    }

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
