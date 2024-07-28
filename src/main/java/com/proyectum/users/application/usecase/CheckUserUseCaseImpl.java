package com.proyectum.users.application.usecase;

import com.proyectum.users.domain.error.EmailAlreadyExistsError;
import com.proyectum.users.domain.error.UserAlreadyExistsError;
import com.proyectum.users.domain.error.UsernameAlreadyExistsError;
import com.proyectum.users.domain.model.Email;
import com.proyectum.users.domain.model.UserAggregate;
import com.proyectum.users.domain.model.Username;
import com.proyectum.users.domain.repository.ExistsUserRepository;
import com.proyectum.users.domain.usecase.CheckUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CheckUserUseCaseImpl implements CheckUserUseCase {

    private final ExistsUserRepository existsUserRepository;

    @Override
    public void checkUser(UserAggregate user) {
        if (existsUserRepository.existsById(user.getId())) {
            throw new UserAlreadyExistsError();
        }

        if (existsUserRepository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyExistsError();
        }

        if (existsUserRepository.existsByUsername(user.getUsername())) {
            throw new UsernameAlreadyExistsError();
        }
    }
}
