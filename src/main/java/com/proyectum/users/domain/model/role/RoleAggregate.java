package com.proyectum.users.domain.model.role;

import com.proyectum.users.ddd.aggregate.AggregateID;
import com.proyectum.users.ddd.aggregate.AggregateRoot;
import com.proyectum.users.domain.event.role.RoleCreatedEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RoleAggregate extends AggregateRoot {

    private Name name;
    private Description description;

    public RoleAggregate() {
        super();
    }

    public RoleAggregate(AggregateID id, Name name, Description description) {
        super(id);
        this.name = name;
        this.description = description;
    }

    public static RoleAggregate create(AggregateID id, Name name, Description description) {
        var role = new RoleAggregate(
                id,
                name,
                description
        );
        var event = new RoleCreatedEvent(id, name, description);
        role.addEvent(event);
        return role;
    }
}
