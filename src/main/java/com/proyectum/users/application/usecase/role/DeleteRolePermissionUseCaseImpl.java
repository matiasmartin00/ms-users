package com.proyectum.users.application.usecase.role;

import com.proyectum.users.domain.command.role.DeletePermissionCommand;
import com.proyectum.users.domain.error.DomainError;
import com.proyectum.users.domain.error.RoleNotFoundError;
import com.proyectum.users.domain.model.role.PermissionID;
import com.proyectum.users.domain.model.role.RoleID;
import com.proyectum.users.domain.repository.role.SaveRoleRepository;
import com.proyectum.users.domain.usecase.role.DeleteRolePermissionUseCase;
import com.proyectum.users.domain.usecase.role.GetPermissionUseCase;
import com.proyectum.users.domain.usecase.role.GetRoleUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteRolePermissionUseCaseImpl implements DeleteRolePermissionUseCase {

    private final GetRoleUseCase getRoleUseCase;
    private final GetPermissionUseCase getPermissionUseCase;
    private final SaveRoleRepository saveRoleRepository;

    @Override
    public void deletePermission(DeletePermissionCommand command) {
        var roleId = new RoleID(command.roleId());
        var roleOpt = getRoleUseCase.getById(roleId);
        var role = roleOpt.orElseThrow(RoleNotFoundError::new);
        var permissionID = new PermissionID(command.permissionId());
        var permissionOpt = getPermissionUseCase.getById(permissionID);
        if (permissionOpt.isEmpty()) {
            return;
        }
        var permission = permissionOpt.get();
        role.removePermission(permission);
        saveRoleRepository.save(role);
    }
}
