package com.cleanarchitecture.school.domain.events;

public abstract class Listener {

    public void process(Event event) {
        if (this.shouldEventProcess(event)) {
            this.reactTo(event);
        }
    }

    protected abstract void reactTo(Event event);

    protected abstract boolean shouldEventProcess(Event event);
}
