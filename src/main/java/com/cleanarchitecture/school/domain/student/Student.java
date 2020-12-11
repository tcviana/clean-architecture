/**
 *
 * Esta classe representa o aluno contendo seus dados pessoais.
 *
 * Aggregate Root
 *
 * @author: Tiago Viana
 * @version: 1.0
 */

package com.cleanarchitecture.school.domain.student;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.context.annotation.Primary;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@Getter
@Entity
public class Student {

    private static final int MAX_TELEPHONE_NUMBERS = 2;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    private String email;

    @Embedded
    @Getter(AccessLevel.PRIVATE)
    private Cpf cpf;

    private String name;

    @OrderBy("id")
    @Getter(AccessLevel.NONE)
    @OneToMany(mappedBy = "student", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private Set<Phone> phone = new LinkedHashSet<>();

    private boolean validAddTelephone() {
        if (this.phone.size() == MAX_TELEPHONE_NUMBERS) {
            throw new PhoneExceeded();
        }
        return true;
    }

    public void addTelephone(final Phone phone) {
        if (validAddTelephone()) {
            this.phone.add(phone);
        }
    }

    public Student(@Email String email, String cpf, String name) {
        this.email = email;
        this.cpf = new Cpf(cpf);
        this.name = name;
    }

    public Set<Phone> getPhone() {
        return Collections.unmodifiableSet(this.phone);
    }

    public String getCpfValue() {
        return this.cpf.getValue();
    }

    public String getCpfUnformattedValue() {
        return this.cpf.getUnformattedValue();
    }
}
