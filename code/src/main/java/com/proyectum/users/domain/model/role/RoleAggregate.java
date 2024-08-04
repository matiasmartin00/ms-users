package com.proyectum.users.domain.model.role;

import com.proyectum.ddd.aggregate.Aggregate;
import com.proyectum.users.domain.event.role.RoleCreatedEvent;
import com.proyectum.users.domain.event.role.RolePermissionAddedEvent;
import com.proyectum.users.domain.event.role.RolePermissionDeletedEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RoleAggregate extends Aggregate<RoleID> {

    private Name name;
    private Description description;
    private Set<Permission> permissions;

    public RoleAggregate() {
        super();
        this.permissions = new HashSet<>();
    }

    public RoleAggregate(RoleID id, Name name, Description description, Set<Permission> permissions) {
        super(id);
        this.name = name;
        this.description = description;
        this.permissions = permissions;
    }

    public static RoleAggregate create(RoleID id, Name name, Description description) {
        var role = new RoleAggregate(
                id,
                name,
                description,
                new HashSet<>()
        );
        var event = new RoleCreatedEvent(id, name, description);
        role.registerEvent(event);
        return role;
    }

    public void addPermission(Permission permission) {
        this.permissions.add(permission);
        var event = new RolePermissionAddedEvent(super.getId(), permission.id());
        super.registerEvent(event);
    }

    public void removePermission(Permission permission) {
        this.permissions.remove(permission);
        var event = new RolePermissionDeletedEvent(super.getId(), permission.id());
        super.registerEvent(event);
    }

    public Set<Permission> getPermissions() {
        return Collections.unmodifiableSet(permissions);
    }
}
