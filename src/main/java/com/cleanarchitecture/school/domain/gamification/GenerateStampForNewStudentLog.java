package com.cleanarchitecture.school.domain.gamification;

import com.cleanarchitecture.school.domain.events.Event;
import com.cleanarchitecture.school.domain.events.Listener;
import com.cleanarchitecture.school.domain.student.StudentEnrolled;
import lombok.RequiredArgsConstructor;

/**
 * A classe {@link GenerateStampForNewStudentLog} gera o log da medalha de iniciante quando um aluno é matriculado
 *
 * @author Tiago Coutinho Viana
 * @version 1.0
 */


@RequiredArgsConstructor
public class GenerateStampForNewStudentLog extends Listener {

    @Override
    protected void reactTo(Event event) {
        System.out.println(String.format("Registrado selo %s para o aluno %s",
                Stamp.BEGGINER, event.objects().get("cpf")));
    }

    @Override
    protected boolean shouldEventProcess(Event event) {
        return event instanceof StudentEnrolled;
    }
}
