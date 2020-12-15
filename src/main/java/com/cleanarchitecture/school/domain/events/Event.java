package com.cleanarchitecture.school.domain.events;

import com.cleanarchitecture.school.infra.events.TypeEvent;

import java.time.LocalDateTime;
import java.util.Map;

public interface Event {

    Map<String, String> objects();
    TypeEvent type();
}
