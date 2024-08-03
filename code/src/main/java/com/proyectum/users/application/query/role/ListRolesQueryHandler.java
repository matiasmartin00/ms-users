package com.proyectum.users.application.query.role;

import com.proyectum.users.application.usecase.role.ListRolesUseCaseImpl;
import com.proyectum.users.ddd.query.QueryHandler;
import com.proyectum.users.domain.model.role.RoleAggregate;
import com.proyectum.users.domain.query.role.ListRolesQuery;
import com.proyectum.users.domain.usecase.role.ListRolesUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListRolesQueryHandler implements QueryHandler<ListRolesQuery, List<RoleAggregate>> {

    private final ListRolesUseCase listRolesUseCase;

    @Override
    public List<RoleAggregate> ask(ListRolesQuery query) {
        return listRolesUseCase.getAll(query);
    }
}
