package com.proyectum.users.application.usecase.role;

import com.proyectum.users.domain.model.role.Name;
import com.proyectum.users.domain.model.role.Permission;
import com.proyectum.users.domain.model.role.PermissionID;
import com.proyectum.users.domain.repository.role.GetPermissionRepository;
import com.proyectum.users.domain.usecase.role.GetPermissionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetPermissionUseCaseImpl implements GetPermissionUseCase {

    private final GetPermissionRepository getPermissionRepository;

    @Override
    public Optional<Permission> getById(PermissionID id) {
        return getPermissionRepository.findById(id);
    }
}
