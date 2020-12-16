package com.cleanarchitecture.school.domain.student;

import com.cleanarchitecture.school.domain.events.Event;
import com.cleanarchitecture.school.domain.events.Listener;
import com.cleanarchitecture.school.infra.TypeEvent;

/**
 * A classe {@link StudentEnrolledLog} gera um log de cadastro de novo aluno
 *
 * @author Tiago Coutinho Viana
 * @version 1.0
 */

public class StudentEnrolledLog extends Listener {

    @Override
    protected void reactTo(Event event) {
        final String moment = event.objects().get("moment");
        final String cpf = event.objects().get("cpf");

        System.out.println(String.format("Aluno com CPF %s matriculado em: %s", cpf, moment));
    }

    @Override
    protected boolean shouldEventProcess(Event event) {
        return event.type() == TypeEvent.STUDENT_ENROLLED;
    }
}
