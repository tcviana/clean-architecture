package com.cleanarchitecture.school.domain.events;

import com.cleanarchitecture.school.infra.TypeEvent;

import java.util.Map;

/**
 * A interface {@link Event} representa os eventos que são criados pelos {@link Listener}
 *
 * @author Tiago Coutinho Viana
 * @version 1.0
 */

public interface Event {

    Map<String, String> objects();
    TypeEvent type();
}
