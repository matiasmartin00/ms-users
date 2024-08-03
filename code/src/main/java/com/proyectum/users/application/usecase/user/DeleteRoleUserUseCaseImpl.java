package com.proyectum.users.application.usecase.user;

import com.proyectum.users.domain.command.user.AddRoleUserCommand;
import com.proyectum.users.domain.command.user.DeleteRoleUserCommand;
import com.proyectum.users.domain.error.RoleNotFoundError;
import com.proyectum.users.domain.error.UserNotFoundError;
import com.proyectum.users.domain.model.role.RoleID;
import com.proyectum.users.domain.model.user.UserID;
import com.proyectum.users.domain.repository.role.GetRoleRepository;
import com.proyectum.users.domain.repository.user.GetUserRepository;
import com.proyectum.users.domain.repository.user.SaveUserRepository;
import com.proyectum.users.domain.usecase.user.AddRoleUserUseCase;
import com.proyectum.users.domain.usecase.user.DeleteRoleUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteRoleUserUseCaseImpl implements DeleteRoleUserUseCase {

    private final GetRoleRepository getRoleRepository;
    private final GetUserRepository getUserRepository;
    private final SaveUserRepository saveUserRepository;

    @Override
    public void deleteRoleUser(DeleteRoleUserCommand command) {
        var userId = new UserID(command.userId());
        var roleId = new RoleID(command.roleId());
        var roleOpt = getRoleRepository.findById(roleId);
        var role = roleOpt.orElseThrow(RoleNotFoundError::new);
        var userOpt = getUserRepository.getById(userId);
        var user = userOpt.orElseThrow(UserNotFoundError::new);
        user.deleteRole(role);
        saveUserRepository.save(user);
    }
}
