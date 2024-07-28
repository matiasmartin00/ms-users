package com.proyectum.users.domain.usecase;

import com.proyectum.users.domain.model.Email;
import com.proyectum.users.domain.model.UserAggregate;
import com.proyectum.users.domain.model.Username;

public interface CheckUserUseCase {

    void checkUser(UserAggregate user);
}
