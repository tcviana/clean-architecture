package com.cleanarchitecture.school.domain.student;

import com.cleanarchitecture.school.domain.events.Event;
import com.cleanarchitecture.school.infra.events.TypeEvent;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * A classe {@link StudentEnrolled} registra o evento de matrículo de aluno
 *
 * @author Tiago Coutinho Viana
 * @version 1.0
 */

public class StudentEnrolled implements Event {

    private Map<String, String> objects = new HashMap<>();

    public StudentEnrolled(final String cpf) {
        this.objects.put("cpf", cpf);
        this.objects.put("moment", getDateTime());
    }

    private String getDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }

    @Override
    public Map<String, String> objects() {
        return this.objects;
    }

    @Override
    public TypeEvent type() {
        return TypeEvent.STUDENT_ENROLLED;
    }
}
