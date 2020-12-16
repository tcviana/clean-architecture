package com.cleanarchitecture.school.domain.events;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * A classe {@link EventPublisher} é responsável por publicar os {@link Event} que são disparados pelos {@link Listener}
 *
 * @author Tiago Coutinho Viana
 * @version 1.0
 */

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
