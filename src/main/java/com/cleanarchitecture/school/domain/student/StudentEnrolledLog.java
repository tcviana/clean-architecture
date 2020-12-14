package com.cleanarchitecture.school.domain.student;

import com.cleanarchitecture.school.domain.events.Event;
import com.cleanarchitecture.school.domain.events.Listener;

import java.time.format.DateTimeFormatter;

public class StudentEnrolledLog extends Listener {

    @Override
    protected void reactTo(Event event) {
        final String moment = ((StudentEnrolled) event).getMoment().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        final String cpf = ((StudentEnrolled) event).getCpf();

        System.out.println(String.format("Aluno com CPF %s matriculado em: %s", cpf, moment));
    }

    @Override
    protected boolean shouldEventProcess(Event event) {
        return event instanceof StudentEnrolled;
    }
}
