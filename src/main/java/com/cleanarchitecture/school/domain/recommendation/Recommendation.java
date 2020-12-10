package com.cleanarchitecture.school.domain.recommendation;

import com.cleanarchitecture.school.domain.student.Student;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@AllArgsConstructor
public class Recommendation {

    private Student indicated;

    private Student indicative;

    @CreatedDate
    private LocalDateTime created;
}
