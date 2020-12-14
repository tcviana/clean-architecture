package com.cleanarchitecture.school.domain.student;

import com.cleanarchitecture.school.domain.events.Event;
import com.cleanarchitecture.school.domain.events.EventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    private void publishEvent(Event event) {
        final EventPublisher publisher = new EventPublisher();
        publisher.addListener(new StudentEnrolledLog());
        publisher.publish(event);
    }

    public Student enrollStudent(final Student student) {
        final Student studentEnrolled = repository.save(student);
        this.publishEvent(new StudentEnrolled(studentEnrolled.getCpfValue()));

        return studentEnrolled;
    }

    public Optional<Student> findById(final Long id) {
       return repository.findById(id);
    }

}
