package com.cleanarchitecture.school.domain.student;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * A classe {@link Student} representa o aluno contendo seus dados pessoais.
 *
 * Aggregate Root
 *
 * @author: Tiago Coutinho Viana
 * @version: 1.0
 */

@NoArgsConstructor
@Getter
@Entity
@Table(name = "STUDENT")
@ToString
public class Student {

    private static final int MAX_TELEPHONE_NUMBERS = 2;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @Id
    private Long id;

    @Email
    @Column(name = "EMAIL")
    private String email;

    @Embedded
    @Getter(AccessLevel.PRIVATE)
    @Column(name = "CPF")
    private Cpf cpf;

    @Column(name = "NAME")
    private String name;

    @OrderBy("ID_TELEPHONE")
    @Getter(AccessLevel.NONE)
    @OneToMany(mappedBy = "student", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private Set<Phone> phone = new LinkedHashSet<>();

    private boolean validAddTelephone() {
        if (this.phone.size() == MAX_TELEPHONE_NUMBERS) {
            throw new PhoneExceeded();
        }
        return true;
    }

    public void addTelephone(final String phone) {
        if (validAddTelephone()) {
            this.phone.add(new Phone(phone));
        }
    }

    public void updateTelephone(final Set<Phone> phones) {
        if (this.phone.size() > MAX_TELEPHONE_NUMBERS) {
            throw new PhoneExceeded();
        }
        this.phone = phones;
    }

    public Student(@Email String email, String cpf, String name) {
        this.email = email;
        this.cpf = new Cpf(cpf);
        this.name = name;
    }

    public Student(Long id, @Email String email, Cpf cpf, String name, Set<Phone> phone) {
        this.id = id;
        this.email = email;
        this.cpf = cpf;
        this.name = name;
        this.updateTelephone(phone);
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
