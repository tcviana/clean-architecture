package com.cleanarchitecture.school.domain.gamification;

import com.cleanarchitecture.school.domain.student.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * A classe {@link Medal} representa as medalhas conquistadas pelos alunos
 *
 * @author Tiago Coutinho Viana
 * @version 1.0
 */

@Entity
@Table(name = "MEDAL")
@NoArgsConstructor
@Getter
public class Medal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MEDAL")
    private Long id;

    @Column(name = "STAMP")
    @Enumerated(EnumType.STRING)
    private Stamp stamp;

    @Column(name = "ID_STUDENT")
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Student student;

    @CreatedDate
    @Column(name = "CREATED")
    private LocalDateTime created;

    public Medal(Stamp stamp, Student student) {
        this.stamp = stamp;
        this.student = student;
    }

    public String getStudentName() {
        return student.getName();
    }
}
