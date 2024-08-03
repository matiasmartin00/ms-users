package com.proyectum.users.application.usecase.role;

import com.proyectum.users.domain.command.role.AddPermissionCommand;
import com.proyectum.users.domain.error.DomainError;
import com.proyectum.users.domain.error.RoleNotFoundError;
import com.proyectum.users.domain.model.role.*;
import com.proyectum.users.domain.repository.role.SaveRoleRepository;
import com.proyectum.users.domain.usecase.role.AddRolePermissionUseCase;
import com.proyectum.users.domain.usecase.role.GetPermissionUseCase;
import com.proyectum.users.domain.usecase.role.GetRoleUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddRolePermissionUseCaseImpl implements AddRolePermissionUseCase {

    private final GetRoleUseCase getRoleUseCase;
    private final GetPermissionUseCase getPermissionUseCase;
    private final SaveRoleRepository saveRoleRepository;

    @Override
    public void addPermission(AddPermissionCommand command) {
        var role = findRole(new RoleID(command.roleId()));
        var permission = findPermission(command);
        role.addPermission(permission);
        saveRoleRepository.save(role);
    }

    private RoleAggregate findRole(RoleID id) {
        return getRoleUseCase.getById(id).orElseThrow(RoleNotFoundError::new);
    }

    private Permission findPermission(AddPermissionCommand command) {
        return getPermissionUseCase.getById(new PermissionID(command.id()))
                .orElseGet(() -> new Permission(
                        new PermissionID(command.id()),
                        new Name(command.name()),
                        new Description(command.description())
                ));
    }
}
