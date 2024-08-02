package com.proyectum.users.ddd.aggregate;

import com.proyectum.users.ddd.event.DomainEvent;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public abstract class AggregateRoot<ID extends ValueObject<UUID>> {

    private ID id;
    private List<DomainEvent> events;

    protected AggregateRoot() {
        this.events = new ArrayList<>();
    }

    protected AggregateRoot(ID id) {
        this();
        this.id = id;
    }

    protected void registerEvent(DomainEvent event) {
        events.add(event);
    }
}
