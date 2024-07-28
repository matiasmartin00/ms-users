package com.proyectum.users.api;

import com.proyectum.api.AuthApi;
import com.proyectum.model.SignInRequest;
import com.proyectum.model.SignInResponse;
import com.proyectum.model.SignUpRequest;
import com.proyectum.users.api.mapper.AuthApiMapper;
import com.proyectum.users.ddd.command.CommandBus;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController implements AuthApi {

    private final CommandBus commandBus;
    private final AuthApiMapper authApiMapper;

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
}
