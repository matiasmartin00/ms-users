package com.proyectum.users.api;

import com.proyectum.api.UserApi;
import com.proyectum.model.CreationUserRequest;
import com.proyectum.users.api.mapper.UserApiMapper;
import com.proyectum.users.ddd.command.CommandBus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final CommandBus commandBus;
    private final UserApiMapper userApiMapper;

    @Override
    public ResponseEntity<Void> create(@Valid @RequestBody CreationUserRequest creationUserRequest) {
        var command = userApiMapper.to(creationUserRequest);
        commandBus.handle(command);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }
}
