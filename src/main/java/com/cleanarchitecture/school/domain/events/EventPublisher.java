package com.cleanarchitecture.school.domain.events;

import java.util.LinkedHashSet;
import java.util.Set;

public class EventPublisher {

    private Set<Listener> listeners = new LinkedHashSet<>();

    public void addListener(Listener listener) {
        this.listeners.add(listener);
    }

    public void publish(Event event) {
        this.listeners.forEach(l -> {
            l.process(event);
        });
    }
}
