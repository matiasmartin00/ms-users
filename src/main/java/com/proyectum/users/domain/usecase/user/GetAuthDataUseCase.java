package com.proyectum.users.domain.usecase.user;

import com.proyectum.users.domain.model.user.UserProjection;
import com.proyectum.users.domain.query.user.GetAuthDataQuery;

public interface GetAuthDataUseCase {

    UserProjection getAuthData(GetAuthDataQuery query);
}
