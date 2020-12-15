package com.cleanarchitecture.school.application;

import com.cleanarchitecture.school.domain.events.Event;
import com.cleanarchitecture.school.domain.events.Listener;
import com.cleanarchitecture.school.domain.gamification.Medal;
import com.cleanarchitecture.school.domain.gamification.MedalRepository;
import com.cleanarchitecture.school.domain.gamification.MedalService;
import com.cleanarchitecture.school.domain.gamification.Stamp;
import com.cleanarchitecture.school.domain.student.Student;
import com.cleanarchitecture.school.domain.student.StudentEnrolled;
import com.cleanarchitecture.school.domain.student.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * A classe {@link GenerateStampForNewStudent} gera a medalha de iniciante quando um aluno é matriculado
 *
 * @author Tiago Coutinho Viana
 * @version 1.0
 */

public class GenerateStampForNewStudent extends Listener {

    @Autowired
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
