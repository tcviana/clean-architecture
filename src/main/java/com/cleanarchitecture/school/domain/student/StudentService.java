package com.cleanarchitecture.school.domain.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public Student enrollStudent(final Student student) {
        return repository.save(student);
    }

    public Optional<Student> findById(final Long id) {
       return repository.findById(id);
    }

}
