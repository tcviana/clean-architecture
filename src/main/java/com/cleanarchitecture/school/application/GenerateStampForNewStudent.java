package com.cleanarchitecture.school.application;

import com.cleanarchitecture.school.domain.events.Event;
import com.cleanarchitecture.school.domain.events.Listener;
import com.cleanarchitecture.school.domain.gamification.Medal;
import com.cleanarchitecture.school.domain.gamification.MedalService;
import com.cleanarchitecture.school.domain.gamification.Stamp;
import com.cleanarchitecture.school.domain.student.StudentEnrolled;
import lombok.AllArgsConstructor;

/**
 * A classe {@link GenerateStampForNewStudent} gera a medalha de iniciante quando um aluno é matriculado
 *
 * @author Tiago Coutinho Viana
 * @version 1.0
 */

@AllArgsConstructor
public class GenerateStampForNewStudent extends Listener {

    private MedalService service;

    @Override
    protected void reactTo(Event event) {
        final Medal medal = service.newStampForStudentCpf(Stamp.BEGGINER, event.objects().get("cpf"));
        System.out.println(String.format("Registrado selo %s para o aluno %s",
                medal.getStamp(), medal.getStudentName()));
    }

    @Override
    protected boolean shouldEventProcess(Event event) {
        return event instanceof StudentEnrolled;
    }
}
