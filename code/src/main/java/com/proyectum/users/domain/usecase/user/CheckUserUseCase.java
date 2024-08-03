package com.proyectum.users.domain.usecase.user;

import com.proyectum.users.domain.model.user.UserAggregate;

public interface CheckUserUseCase {

    void checkUser(UserAggregate user);
}
