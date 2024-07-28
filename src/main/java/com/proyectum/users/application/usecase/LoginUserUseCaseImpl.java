package com.proyectum.users.application.usecase;

import com.proyectum.users.domain.command.LoginUserCommand;
import com.proyectum.users.domain.error.InvalidCredentialsError;
import com.proyectum.users.domain.model.Password;
import com.proyectum.users.domain.model.UserAggregate;
import com.proyectum.users.domain.model.Username;
import com.proyectum.users.domain.repository.GetUserRepository;
import com.proyectum.users.domain.repository.JwtRepository;
import com.proyectum.users.domain.usecase.LoginUserUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class LoginUserUseCaseImpl implements LoginUserUseCase {

    private final PasswordEncoder passwordEncoder;
    private final GetUserRepository getUserRepository;
    private final JwtRepository jwtRepository;

    @Override
    public String login(LoginUserCommand command) {
        var username = new Username(command.username());
        var userOpt = getUserRepository.getByUsername(username);
        return userOpt
                .filter(user -> {
                    var passwordEncoded = user.getPassword().value();
                    return passwordEncoder.matches(command.password(), passwordEncoded);
                })
                .map(jwtRepository::generateToken)
                .orElseThrow(InvalidCredentialsError::new);
    }
}
