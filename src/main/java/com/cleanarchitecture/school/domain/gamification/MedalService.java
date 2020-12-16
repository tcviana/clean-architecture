package com.cleanarchitecture.school.domain.gamification;

import com.cleanarchitecture.school.domain.student.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * A classe {@link MedalService} representa os serviços disponíveis para a {@link Medal}
 *
 * @author Tiago Coutinho Viana
 * @version 1.0
 */

@Component
@AllArgsConstructor
public class MedalService {

    private final MedalRepository medalRepository;

    public Medal newStampForStudent(final Stamp stamp, final Student student) {
        final Medal medal = new Medal(stamp, student);
        return medalRepository.save(medal);
    }
}
