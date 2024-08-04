package com.proyectum.users.domain.model.user;

import com.proyectum.ddd.aggregate.Aggregate;
import com.proyectum.users.domain.event.user.UserRegisteredEvent;
import com.proyectum.users.domain.event.user.UserRoleAddedEvent;
import com.proyectum.users.domain.event.user.UserRoleDeletedEvent;
import com.proyectum.users.domain.model.role.RoleAggregate;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserAggregate extends Aggregate<UserID> {

    private Username username;
    private Password password;
    private Email email;
    private CreatedAt createdAt;
    private UpdatedAt updatedAt;
    private Set<RoleAggregate> roles;

    public UserAggregate() {
        super();
        this.roles = new HashSet<>();
    }

    private UserAggregate(UserID aggregateID, Username username, Password password,
                          Email email, CreatedAt createdAt, UpdatedAt updatedAt) {
        super(aggregateID);
        this.username = username;
        this.password = password;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.roles = new HashSet<>();
    }

    public static UserAggregate create(UserID id, Username username, Password password, Email email) {
        var user = new UserAggregate(
                id,
                username,
                password,
                email,
                new CreatedAt(LocalDateTime.now()),
                new UpdatedAt(LocalDateTime.now())
        );

        var event = new UserRegisteredEvent(user.getId(), user.getUsername(), user.getEmail());
        user.registerEvent(event);
        return user;
    }

    public void addRole(RoleAggregate role) {
        this.roles.add(role);
        var event = new UserRoleAddedEvent(super.getId(), role.getId());
        this.registerEvent(event);
    }

    public void deleteRole(RoleAggregate role) {
        this.roles.remove(role);
        var event = new UserRoleDeletedEvent(super.getId(), role.getId());
        this.registerEvent(event);
    }

    public Set<RoleAggregate> getRoles() {
        return Collections.unmodifiableSet(roles);
    }
}
