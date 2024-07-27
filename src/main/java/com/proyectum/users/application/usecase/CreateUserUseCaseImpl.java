package com.proyectum.users.application.usecase;

import com.proyectum.users.ddd.aggregate.AggregateID;
import com.proyectum.users.domain.command.CreateUserCommand;
import com.proyectum.users.domain.model.*;
import com.proyectum.users.domain.repository.SaveUserRepository;
import com.proyectum.users.domain.usecase.CreateUserUseCase;
import com.proyectum.users.infrastructure.repository.SaveUserRepositoryImpl;
import com.proyectum.users.infrastructure.repository.postgres.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final PasswordEncoder passwordEncoder;

    private final SaveUserRepository saveUserRepository;

    @Override
    public void create(CreateUserCommand command) {
        var passwordEncoded = passwordEncoder.encode(command.password());
        var user = UserAggregate.create(
                new AggregateID(command.id()),
                new Username(command.username()),
                new FirstName(command.firstName()),
                new LastName(command.lastName()),
                new Password(passwordEncoded),
                new Email(command.email())
        );
        saveUserRepository.save(user);
        log.info("User created: {}", user);
    }
}
