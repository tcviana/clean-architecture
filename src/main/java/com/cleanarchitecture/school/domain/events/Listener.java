package com.cleanarchitecture.school.domain.events;

/**
 * A classe {@link Listener} é responsável por ouvir os serviços da aplicação e disparar os {@link Event}
 *
 * @author Tiago Coutinho Viana
 * @version 1.0
 */

public abstract class Listener {

    public void process(Event event) {
        if (this.shouldEventProcess(event)) {
            this.reactTo(event);
        }
    }

    protected abstract void reactTo(Event event);

    protected abstract boolean shouldEventProcess(Event event);
}
