package com.cleanarchitecture.school.domain.gamification;

import com.cleanarchitecture.school.domain.student.Student;
import com.cleanarchitecture.school.domain.student.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@RequiredArgsConstructor
public class MedalService {

    private final MedalRepository medalRepository;
    private final StudentRepository studentRepository;

    public Medal newStampForStudentCpf(Stamp stamp, String cpf) {
        final Student student = studentRepository.findByCpf(cpf);
        final Medal medal = new Medal(stamp, student);
        return medalRepository.save(medal);
    }
}
