package com.cleanarchitecture.school.domain.student;

import com.cleanarchitecture.school.domain.gamification.GenerateStampForNewStudentLog;
import com.cleanarchitecture.school.domain.gamification.MedalService;
import com.cleanarchitecture.school.domain.events.EventPublisher;
import com.cleanarchitecture.school.domain.events.Event;
import com.cleanarchitecture.school.domain.gamification.Stamp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * A classe {@link StudentService} representa os serviços disponíveis para o {@link Student}
 *
 * @author Tiago Coutinho Viana
 * @version 1.0
 */

@Component
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;
    private final MedalService medalService;

    private void publishEvent(Event event) {
        final EventPublisher publisher = new EventPublisher();
        publisher.addListener(new StudentEnrolledLog());
        publisher.addListener(new GenerateStampForNewStudentLog());
        publisher.publish(event);
    }

    public Student enrollStudent(final Student student) {
        final Student studentEnrolled = repository.save(student);
        medalService.newStampForStudent(Stamp.BEGGINER, student);
        this.publishEvent(new StudentEnrolled(studentEnrolled.getCpfValue()));

        return studentEnrolled;
    }

    public Optional<Student> findById(final Long id) {
       return repository.findById(id);
    }

}
