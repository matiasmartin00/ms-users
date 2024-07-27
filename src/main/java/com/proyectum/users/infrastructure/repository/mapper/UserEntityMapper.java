package com.proyectum.users.infrastructure.repository.mapper;

import com.proyectum.users.ddd.aggregate.AggregateID;
import com.proyectum.users.domain.model.*;
import com.proyectum.users.infrastructure.repository.postgres.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

    UserEntity to(UserAggregate src);

    default String map(Email src) {
        return src.value();
    }

    default String map(Username src) {
        return src.value();
    }

    default String map(FirstName src) {
        return src.value();
    }

    default String map(LastName src) {
        return src.value();
    }

    default String map(Password src) {
        return src.value();
    }

    default LocalDateTime map(CreatedAt src) {
        return src.value();
    }

    default LocalDateTime map(UpdatedAt src) {
        return src.value();
    }

    default UUID map(AggregateID src) {
        return src.value();
    }
}
