package com.proyectum.users.application.usecase.user;

import com.proyectum.users.domain.error.UserNotFoundError;
import com.proyectum.users.domain.model.role.*;
import com.proyectum.users.domain.model.user.UserProjection;
import com.proyectum.users.domain.model.user.Username;
import com.proyectum.users.domain.query.user.GetAuthDataQuery;
import com.proyectum.users.domain.repository.user.GetUserRepository;
import com.proyectum.users.domain.usecase.user.GetAuthDataUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GetAuthDataUseCaseImpl implements GetAuthDataUseCase {

    private final GetUserRepository getUserRepository;

    @Override
    public UserProjection getAuthData(GetAuthDataQuery query) {
        var username = new Username(query.username());
        var userOpt = getUserRepository.getByUsername(username);
        var user = userOpt.orElseThrow(UserNotFoundError::new);
        var roles = user.getRoles()
                .stream()
                .map(role -> {
                    var permissions = role.getPermissions()
                            .stream()
                            .map(Permission::name)
                            .map(PermissionProjection::new)
                            .collect(Collectors.toSet());
                    return new RoleProjection(role.getName(), permissions);
                })
                .collect(Collectors.toSet());
        return new UserProjection(
                user.getUsername(),
                user.getEmail(),
                roles
        );
    }
}
