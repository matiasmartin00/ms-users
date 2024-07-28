package com.proyectum.users.application.usecase.role;

import com.proyectum.users.domain.error.RoleAlreadyExistsError;
import com.proyectum.users.domain.error.RoleNameAlreadyExistsError;
import com.proyectum.users.domain.model.role.RoleAggregate;
import com.proyectum.users.domain.repository.role.ExistsRoleRepository;
import com.proyectum.users.domain.usecase.role.CheckRoleUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CheckRoleUseCaseImpl implements CheckRoleUseCase {

    private final ExistsRoleRepository existsRoleRepository;

    @Override
    public void checkRole(RoleAggregate role) {

        if (existsRoleRepository.existsById(role.getId())) {
            throw new RoleAlreadyExistsError();
        }

        if (existsRoleRepository.existsByName(role.getName())) {
            throw new RoleNameAlreadyExistsError();
        }
    }
}
