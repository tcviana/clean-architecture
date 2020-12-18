package com.cleanarchitecture.school.application;

import com.cleanarchitecture.school.domain.gamification.GenerateStampForNewStudentLog;
import com.cleanarchitecture.school.domain.events.EventPublisher;
import com.cleanarchitecture.school.domain.events.Event;
import com.cleanarchitecture.school.domain.gamification.Stamp;
import com.cleanarchitecture.school.domain.student.Student;
import com.cleanarchitecture.school.domain.student.StudentEnrolled;
import com.cleanarchitecture.school.domain.student.StudentEnrolledLog;
import com.cleanarchitecture.school.domain.student.StudentRepository;
import com.cleanarchitecture.school.infra.ApplicationServices;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

/**
 * A classe {@link StudentApplicationService} representa os serviços disponíveis para o {@link Student}
 *
 * @author Tiago Coutinho Viana
 * @version 1.0
 */

@ApplicationServices
@RequiredArgsConstructor
public class StudentApplicationService {

    private final StudentRepository repository;
    private final MedalApplicationService medalApplicationService;

    private void publishEvent(Event event) {
        final EventPublisher publisher = new EventPublisher();
        publisher.addListener(new StudentEnrolledLog());
        publisher.addListener(new GenerateStampForNewStudentLog());
        publisher.publish(event);
    }

    public Student enrollStudent(final Student student) {
        final Student studentEnrolled = repository.save(student);
        medalApplicationService.newStampForStudent(Stamp.BEGGINER, student);
        this.publishEvent(new StudentEnrolled(studentEnrolled.getCpfValue()));

        return studentEnrolled;
    }

    public Optional<Student> findById(final Long id) {
       return repository.findById(id);
    }

}
