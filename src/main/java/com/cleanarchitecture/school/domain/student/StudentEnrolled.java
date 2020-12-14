package com.cleanarchitecture.school.domain.student;

import com.cleanarchitecture.school.domain.events.Event;
import lombok.Getter;

import java.time.LocalDateTime;

public class StudentEnrolled implements Event {

    @Getter
    private final String cpf;

    @Getter
    private LocalDateTime moment;

    public StudentEnrolled(final String cpf) {
        this.cpf = cpf;
        this.moment = this.moment();
    }

    @Override
    public LocalDateTime moment() {
        return LocalDateTime.now();
    }
}
