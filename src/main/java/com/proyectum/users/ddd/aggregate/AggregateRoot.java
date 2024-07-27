package com.proyectum.users.ddd.aggregate;

import com.proyectum.users.ddd.event.DomainEvent;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class AggregateRoot {

    private AggregateID id;
    private List<DomainEvent> events;

    protected AggregateRoot() {}

    protected AggregateRoot(AggregateID id) {
        this.id = id;
        this.events = new ArrayList<>();
    }

    protected void addEvent(DomainEvent event) {
        events.add(event);
    }
}
