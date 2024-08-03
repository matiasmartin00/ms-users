package com.proyectum.users.application.usecase.role;

import com.proyectum.users.domain.model.role.RoleAggregate;
import com.proyectum.users.domain.model.role.RoleID;
import com.proyectum.users.domain.repository.role.GetRoleRepository;
import com.proyectum.users.domain.usecase.role.GetRoleUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetRoleUseCaseImpl implements GetRoleUseCase {

    private final GetRoleRepository getRoleRepository;

    @Override
    public Optional<RoleAggregate> getById(RoleID id) {
        return getRoleRepository.findById(id);
    }
}
