package com.proyectum.users.ddd.aggregate;

import com.proyectum.users.ddd.event.DomainEvent;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class AggregateRoot {

    private AggregateID id;
    private List<DomainEvent> events;

    protected AggregateRoot() {
        this.events = new ArrayList<>();
    }

    protected AggregateRoot(AggregateID id) {
        this();
        this.id = id;
    }

    protected void addEvent(DomainEvent event) {
        events.add(event);
    }
}
