package com.cleanarchitecture.school.student;


import com.cleanarchitecture.school.domain.student.Student;
import com.cleanarchitecture.school.domain.student.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StudentServiceTest {

    @Autowired
    StudentService service;

    @Test
    public void shouldEnrollStudent() {
        Student student = new Student("test@test.com", "45645678910", "Benedito");
        student.addTelephone("12-98192.0972");
        Student enrollStudent = service.enrollStudent(student);

        assertEquals("Benedito", enrollStudent.getName());
        assertEquals(2, enrollStudent.getId());
        assertEquals(1, student.getPhone().size());
    }

    @Test
    public void shouldFindById() throws Exception {

        final Optional<Student> student = service.findById(1L);

        assertEquals(1, student.get().getId());
        assertEquals("Sebastião das Neves", student.get().getName());

    }
}
