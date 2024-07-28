package com.proyectum.users.domain.event;

import com.proyectum.users.ddd.aggregate.AggregateID;
import com.proyectum.users.ddd.event.DomainEvent;
import com.proyectum.users.domain.model.Email;
import com.proyectum.users.domain.model.Username;

public record UserRegisteredEvent(AggregateID id, Username username, Email email) implements DomainEvent {
}
