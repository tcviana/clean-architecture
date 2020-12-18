package com.cleanarchitecture.school.domain.recommendation;

import com.cleanarchitecture.school.domain.student.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
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

@NoArgsConstructor
@Entity
@Table(name = "RECOMMENDATION")
@Getter
public class Recommendation {

    @Id
    @JoinColumn(name = "INDICATED")
    @OneToOne
    private Student indicated;

    @Id
    @ManyToOne
    @JoinColumn(name = "INDICATIVE")
    private Student indicative;

    @CreatedDate
    @Column(name = "CREATED")
    private LocalDateTime created;

    public Recommendation(Student indicated, Student indicative) {
        this.indicated = indicated;
        this.indicative = indicative;
    }
}
