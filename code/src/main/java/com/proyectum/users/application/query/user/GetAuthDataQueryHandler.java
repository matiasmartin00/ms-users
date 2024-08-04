package com.proyectum.users.application.query.user;

import com.proyectum.cqrs.query.QueryHandler;
import com.proyectum.users.domain.model.user.UserProjection;
import com.proyectum.users.domain.query.user.GetAuthDataQuery;
import com.proyectum.users.domain.usecase.user.GetAuthDataUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetAuthDataQueryHandler implements QueryHandler<GetAuthDataQuery, UserProjection> {

    private final GetAuthDataUseCase getAuthDataUseCase;

    @Override
    public UserProjection ask(GetAuthDataQuery query) {
        return getAuthDataUseCase.getAuthData(query);
    }
}
