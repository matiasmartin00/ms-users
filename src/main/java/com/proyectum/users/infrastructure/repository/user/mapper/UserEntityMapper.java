package com.proyectum.users.infrastructure.repository.user.mapper;

import com.proyectum.users.domain.model.user.*;
import com.proyectum.users.infrastructure.repository.postgres.entity.UserEntity;
import com.proyectum.users.infrastructure.repository.role.mapper.RoleEntityMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.time.LocalDateTime;
import java.util.UUID;

@Mapper(
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = RoleEntityMapper.class,
        componentModel = "spring")
public interface UserEntityMapper {

    UserEntity to(UserAggregate src);

    UserAggregate to(UserEntity src);

    default UserID to(UUID id) {
        return new UserID(id);
    }

    default Username toUsername(String username) {
        return new Username(username);
    }

    default Password toPassword(String password) {
        return new Password(password);
    }

    default Email toEmail(String email) {
        return new Email(email);
    }

    default CreatedAt toCreatedAt(LocalDateTime createdAt) {
        return new CreatedAt(createdAt);
    }

    default UpdatedAt toUpdatedAt(LocalDateTime updatedAt) {
        return new UpdatedAt(updatedAt);
    }

    default String map(Email src) {
        return src.value();
    }

    default String map(Username src) {
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

    default UUID map(UserID src) {
        return src.value();
    }
}
