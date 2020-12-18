package com.cleanarchitecture.school.domain.recommendation;

import com.cleanarchitecture.school.domain.student.Student;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * A classe {@link Recommendation} representa as indicações de um {@link Student} para outro.
 *
 * @author Tiago Coutinho Viana
 * @version 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RECOMMENDATION")
public class Recommendation {

    @Id
    @Column(name = "INDICATED")
    @OneToOne
    private Student indicated;

    @Id
    @Column(name = "INDICATIVE")
    @ManyToOne
    private Student indicative;

    @CreatedDate
    @Column(name = "CREATED")
    private LocalDateTime created;
}
