package com.proyectum.users.domain.model;

import com.proyectum.users.ddd.aggregate.AggregateID;
import com.proyectum.users.ddd.aggregate.AggregateRoot;
import com.proyectum.users.domain.event.UserRegisteredEvent;
import lombok.*;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserAggregate extends AggregateRoot {

    private Username username;
    private Password password;
    private Email email;
    private CreatedAt createdAt;
    private UpdatedAt updatedAt;

    private UserAggregate() {
        super();
    }

    private UserAggregate(AggregateID aggregateID, Username username, Password password,
                          Email email, CreatedAt createdAt, UpdatedAt updatedAt) {
        super(aggregateID);
        this.username = username;
        this.password = password;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static UserAggregate create(AggregateID id, Username username, Password password, Email email) {
        var user = new UserAggregate(
                id,
                username,
                password,
                email,
                new CreatedAt(LocalDateTime.now()),
                new UpdatedAt(LocalDateTime.now())
        );

        var event = new UserRegisteredEvent(user.getId(), user.getUsername(), user.getEmail());
        user.addEvent(event);
        return user;
    }
}
