package com.cleanarchitecture.school.domain.recommendation;

import com.cleanarchitecture.school.domain.student.Student;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

/**
 * A classe {@link Recommendation} representa as indicações de um {@link Student} para outro.
 *
 * @author Tiago Coutinho Viana
 * @version 1.0
 */

@AllArgsConstructor
public class Recommendation {

    private Student indicated;

    private Student indicative;

    @CreatedDate
    private LocalDateTime created;
}
