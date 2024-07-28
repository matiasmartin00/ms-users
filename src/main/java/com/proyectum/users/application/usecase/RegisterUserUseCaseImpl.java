package com.proyectum.users.application.usecase;

import com.proyectum.users.ddd.aggregate.AggregateID;
import com.proyectum.users.domain.command.RegisterUserCommand;
import com.proyectum.users.domain.model.*;
import com.proyectum.users.domain.repository.SaveUserRepository;
import com.proyectum.users.domain.usecase.CheckUserUseCase;
import com.proyectum.users.domain.usecase.RegisterUserUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RegisterUserUseCaseImpl implements RegisterUserUseCase {

    private final PasswordEncoder passwordEncoder;

    private final SaveUserRepository saveUserRepository;

    private final CheckUserUseCase checkUserUseCase;

    @Override
    public void create(RegisterUserCommand command) {
        var passwordEncoded = passwordEncoder.encode(command.password());
        var user = UserAggregate.create(
                new AggregateID(command.id()),
                new Username(command.username()),
                new Password(passwordEncoded),
                new Email(command.email())
        );
        checkUserUseCase.checkUser(user);
        saveUserRepository.save(user);
    }
}
