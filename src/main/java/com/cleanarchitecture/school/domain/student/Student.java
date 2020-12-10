package com.cleanarchitecture.school.domain.student;

import lombok.AllArgsConstructor;

import javax.validation.constraints.Pattern;
import java.util.Set;

@AllArgsConstructor
public class Student {

    @Pattern(regexp = "^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
    private String email;

    @Pattern(regexp = "^[0-9]{11}$")
    private Integer cpf;

    private String name;

    private Set<Telephone> telephone;

    private void addTelephone(final Telephone telephone) {
        this.telephone.add(telephone);
    }

}
