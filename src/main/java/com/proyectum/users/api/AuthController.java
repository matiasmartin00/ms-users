package com.proyectum.users.api;

import com.proyectum.api.AuthApi;
import com.proyectum.model.*;
import com.proyectum.users.api.mapper.AuthApiMapper;
import com.proyectum.users.ddd.command.CommandBus;
import com.proyectum.users.ddd.query.QueryBus;
import com.proyectum.users.domain.model.user.UserProjection;
import com.proyectum.users.infrastructure.service.CurrentUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AuthController implements AuthApi {

    private final CommandBus commandBus;
    private final QueryBus queryBus;
    private final AuthApiMapper authApiMapper;
    private final CurrentUserService currentUserService;

    @Override
    public ResponseEntity<SignInResponse> signIn(@Valid @RequestBody SignInRequest signIn) {
        var command = authApiMapper.to(signIn);
        var token = commandBus.handle(command);
        var response = authApiMapper.to((String) token);
        return ResponseEntity.ok()
                .body(response);
    }

    @Override
    public ResponseEntity<Void> signUp(@Valid @RequestBody SignUpRequest signUpRequest) {
        var command = authApiMapper.to(signUpRequest);
        commandBus.handle(command);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @Override
    @PreAuthorize("hasAuthority('admin')")
    public ResponseEntity<Void> addRole(UUID userId, AddRoleRequest addRoleRequest) {
        var command = authApiMapper.to(userId, addRoleRequest);
        commandBus.handle(command);
        return ResponseEntity
                .ok()
                .build();
    }

    @Override
    public ResponseEntity<Void> deleteRole(UUID userId, UUID roleId) {
        var command = authApiMapper.to(userId, roleId);
        commandBus.handle(command);
        return ResponseEntity
                .ok()
                .build();
    }

    @Override
    public ResponseEntity<AuthDataResponse> authData() {
        var username = currentUserService.getCurrentUsername();
        var query = authApiMapper.toGetAuthDataQuery(username);
        var authData = (UserProjection) queryBus.ask(query);
        return ResponseEntity.ok(authApiMapper.to(authData));
    }
}
