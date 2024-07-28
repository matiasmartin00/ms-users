package com.proyectum.users.api;

import com.proyectum.api.RoleApi;
import com.proyectum.model.RoleRequest;
import com.proyectum.model.RoleResponse;
import com.proyectum.users.api.mapper.RoleApiMapper;
import com.proyectum.users.ddd.command.CommandBus;
import com.proyectum.users.ddd.query.QueryBus;
import com.proyectum.users.domain.model.role.RoleAggregate;
import com.proyectum.users.domain.query.role.ListRolesQuery;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RoleController implements RoleApi {

    private final CommandBus commandBus;
    private final QueryBus queryBus;
    private final RoleApiMapper roleApiMapper;

    @Override
    @PreAuthorize("hasAuthority('admin')")
    public ResponseEntity<Void> create(@Valid @RequestBody RoleRequest roleRequest) {
        var command = roleApiMapper.to(roleRequest);
        commandBus.handle(command);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @Override
    public ResponseEntity<RoleResponse> listAll() {
        var roles = (List<RoleAggregate>) queryBus.ask(new ListRolesQuery());
        var response = new RoleResponse();
        response.setData(roles.
                stream()
                .map(roleApiMapper::to)
                .toList());
        return ResponseEntity.ok(response);
    }
}
