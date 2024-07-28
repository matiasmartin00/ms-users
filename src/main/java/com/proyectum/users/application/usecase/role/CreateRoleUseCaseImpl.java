package com.proyectum.users.application.usecase.role;

import com.proyectum.users.ddd.aggregate.AggregateID;
import com.proyectum.users.domain.command.role.CreateRoleCommand;
import com.proyectum.users.domain.model.role.Description;
import com.proyectum.users.domain.model.role.Name;
import com.proyectum.users.domain.model.role.RoleAggregate;
import com.proyectum.users.domain.repository.role.ExistsRoleRepository;
import com.proyectum.users.domain.repository.role.SaveRoleRepository;
import com.proyectum.users.domain.usecase.role.CheckRoleUseCase;
import com.proyectum.users.domain.usecase.role.CreateRoleUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateRoleUseCaseImpl implements CreateRoleUseCase {

    private final CheckRoleUseCase checkRoleUseCase;
    private final SaveRoleRepository saveRoleRepository;

    @Override
    public void create(CreateRoleCommand command) {
        log.info("Create role {}", command);
        var role = RoleAggregate.create(
                new AggregateID(command.id()),
                new Name(command.name()),
                new Description(command.description())
        );
        checkRoleUseCase.checkRole(role);
        saveRoleRepository.save(role);
        log.info("Role {} created", role);
    }
}
