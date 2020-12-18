package com.cleanarchitecture.school.application;

import com.cleanarchitecture.school.domain.gamification.Medal;
import com.cleanarchitecture.school.domain.gamification.MedalRepository;
import com.cleanarchitecture.school.domain.gamification.Stamp;
import com.cleanarchitecture.school.domain.student.Student;
import com.cleanarchitecture.school.infra.ApplicationServices;
import lombok.AllArgsConstructor;

/**
 * A classe {@link MedalApplicationService} representa os serviços disponíveis para a {@link Medal}
 *
 * @author Tiago Coutinho Viana
 * @version 1.0
 */

@ApplicationServices
@AllArgsConstructor
public class MedalApplicationService {

    private final MedalRepository medalRepository;

    public Medal newStampForStudent(final Stamp stamp, final Student student) {
        final Medal medal = new Medal(stamp, student);
        return medalRepository.save(medal);
    }
}
