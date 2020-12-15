package com.cleanarchitecture.school.domain.gamification;

import com.cleanarchitecture.school.domain.student.Student;
import com.cleanarchitecture.school.domain.student.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MedalService {

    private MedalRepository medalRepository;
    private StudentRepository studentRepository;

    public Medal newStampForStudentCpf(Stamp stamp, String cpf) {
        final Student student = studentRepository.findByCpfValue(cpf);
        final Medal medal = new Medal(stamp, student);
        return medalRepository.save(medal);
    }
}
